/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.bll;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.sujan.lms.dao.user.UserDAO;
import com.sujan.lms.dao.user.UserDAOImpl;
import com.sujan.lms.entity.user.User;
import com.sujan.lms.entity.user.UserInfo;
import com.sujan.lms.entity.user.UserParams;
import com.sujan.lms.exception.CorruptedDataException;
import com.sujan.lms.exception.DuplicateRecordException;
import com.sujan.lms.exception.MissingFileException;
import com.sujan.lms.exception.RecordNotFoundException;
import com.sujan.lms.exception.UnAvailableUsernameException;
import com.sujan.lms.json.JsonMapper;
import com.sujan.lms.util.FileUtils;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Suzn
 */
public class UserBLL {

    public static int insertUser(UserInfo userInfo) throws DuplicateRecordException, 
            MissingFileException, CorruptedDataException, UnAvailableUsernameException {
        UserDAO userManager = new UserDAOImpl(JsonMapper.getInstance().getGson(), UserParams.FILENAME);
        try {
            int response = -1;
            if (FileUtils.exists(UserParams.FILENAME)) {

                if (userManager.isUserAvailable(userInfo)) {
                    throw new DuplicateRecordException();
                }
                
                if(userManager.isUsernameAlreadyUsed(userInfo.getUsername())){
                    throw new UnAvailableUsernameException();
                }

                response = userManager.append(userInfo);
            } else {
                response = userManager.save(userInfo);
            }
            return response;
        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(UserParams.FILENAME, e);
        }
    }

    public static int updateUser(UserInfo userInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        UserDAO userManager = new UserDAOImpl(JsonMapper.getInstance().getGson(), UserParams.FILENAME);
        try {
            if (FileUtils.notExist(UserParams.FILENAME)) {
                throw new MissingFileException(UserParams.FILENAME);
            }
            if (!userManager.isUserAvailable(userInfo)) {
                throw new RecordNotFoundException();
            }

            return userManager.update(userInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(UserParams.FILENAME, e);
        }
    }

    public static int deleteUser(UserInfo userInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        UserDAO userManager = new UserDAOImpl(JsonMapper.getInstance().getGson(), UserParams.FILENAME);
        try {
            if (FileUtils.notExist(UserParams.FILENAME)) {
                throw new MissingFileException(UserParams.FILENAME);
            }
            if (!userManager.isUserAvailable(userInfo)) {
                throw new RecordNotFoundException();
            }

            return userManager.remove(userInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(UserParams.FILENAME, e);
        }
    }

    public static UserInfo getUserById(int id) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        UserDAO userManager = new UserDAOImpl(JsonMapper.getInstance().getGson(), UserParams.FILENAME);
        try {
            if (FileUtils.notExist(UserParams.FILENAME)) {
                throw new MissingFileException(UserParams.FILENAME);
            }

            return userManager.findById(id);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(UserParams.FILENAME, e);
        }
    }

    public static List<UserInfo> getAllUser() throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        UserDAO userManager = new UserDAOImpl(JsonMapper.getInstance().getGson(), UserParams.FILENAME);
        try {
            if (FileUtils.notExist(UserParams.FILENAME)) {
                throw new MissingFileException(UserParams.FILENAME);
            }

            return userManager.findAll();

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
        UserDAO userManager = new UserDAOImpl(JsonMapper.getInstance().getGson(), UserParams.FILENAME);
        try {
            if (FileUtils.notExist(UserParams.FILENAME)) {
                throw new MissingFileException(UserParams.FILENAME);
            }

            return userManager.loginUser(user);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(UserParams.FILENAME, e);
        }
    }

}
