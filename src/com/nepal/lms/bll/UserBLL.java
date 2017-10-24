/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.bll;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.nepal.lms.dao.user.UserDAO;
import com.nepal.lms.dao.user.UserDAOImpl;
import com.nepal.lms.entity.user.User;
import com.nepal.lms.entity.user.UserInfo;
import com.nepal.lms.entity.user.UserParams;
import com.nepal.lms.exception.CorruptedDataException;
import com.nepal.lms.exception.DuplicateRecordException;
import com.nepal.lms.exception.MissingFileException;
import com.nepal.lms.exception.RecordNotFoundException;
import com.nepal.lms.json.JsonMapper;
import com.nepal.lms.util.FileUtils;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Suzn
 */
public class UserBLL {

    public static int insertUser(UserInfo userInfo) throws DuplicateRecordException, MissingFileException, CorruptedDataException {
        UserDAO userDAO = new UserDAOImpl(JsonMapper.getInstance().getGson(), UserParams.FILENAME);
        try {
            int response = -1;
            if (FileUtils.exists(UserParams.FILENAME)) {

                if (userDAO.isUserAvailable(userInfo)) {
                    throw new DuplicateRecordException();
                }

                response = userDAO.append(userInfo);
            } else {
                response = userDAO.save(userInfo);
            }
            return response;
        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(UserParams.FILENAME, e);
        }
    }

    public static int updateUser(UserInfo userInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        UserDAO userDAO = new UserDAOImpl(JsonMapper.getInstance().getGson(), UserParams.FILENAME);
        try {
            if (FileUtils.notExist(UserParams.FILENAME)) {
                throw new MissingFileException(UserParams.FILENAME);
            }
            if (!userDAO.isUserAvailable(userInfo)) {
                throw new RecordNotFoundException();
            }

            return userDAO.update(userInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(UserParams.FILENAME, e);
        }
    }

    public static int deleteUser(UserInfo userInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        UserDAO userDAO = new UserDAOImpl(JsonMapper.getInstance().getGson(), UserParams.FILENAME);
        try {
            if (FileUtils.notExist(UserParams.FILENAME)) {
                throw new MissingFileException(UserParams.FILENAME);
            }
            if (!userDAO.isUserAvailable(userInfo)) {
                throw new RecordNotFoundException();
            }

            return userDAO.remove(userInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(UserParams.FILENAME, e);
        }
    }

    public static UserInfo getUserById(int id) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        UserDAO userDAO = new UserDAOImpl(JsonMapper.getInstance().getGson(), UserParams.FILENAME);
        try {
            if (FileUtils.notExist(UserParams.FILENAME)) {
                throw new MissingFileException(UserParams.FILENAME);
            }

            return userDAO.findById(id);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(UserParams.FILENAME, e);
        }
    }

    public static List<UserInfo> getAllUser() throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        UserDAO userDAO = new UserDAOImpl(JsonMapper.getInstance().getGson(), UserParams.FILENAME);
        try {
            if (FileUtils.notExist(UserParams.FILENAME)) {
                throw new MissingFileException(UserParams.FILENAME);
            }

            return userDAO.findAll();

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(UserParams.FILENAME, e);
        }
    }

    public static boolean isUserAvailable(User user) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        return getUserById(user.getId()) != null;
    }

    public static UserInfo loginUser(User user) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        UserDAO userDAO = new UserDAOImpl(JsonMapper.getInstance().getGson(), UserParams.FILENAME);
        try {
            if (FileUtils.notExist(UserParams.FILENAME)) {
                throw new MissingFileException(UserParams.FILENAME);
            }

            return userDAO.loginUser(user);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(UserParams.FILENAME, e);
        }
    }

}
