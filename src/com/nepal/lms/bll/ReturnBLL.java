/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.bll;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.nepal.lms.dao.returnn.ReturnDAO;
import com.nepal.lms.dao.returnn.ReturnDAOImpl;
import com.nepal.lms.entity.returnn.Return;
import com.nepal.lms.entity.returnn.ReturnParams;
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
 * @returnn Suzn
 */
public class ReturnBLL {

    public static int insertReturn(Return returnnInfo) throws DuplicateRecordException, MissingFileException, CorruptedDataException {
        ReturnDAO returnnDAO = new ReturnDAOImpl(JsonMapper.getInstance().getGson(), ReturnParams.FILENAME);
        try {
            int response = -1;
            if (FileUtils.exists(ReturnParams.FILENAME)) {

                if (returnnDAO.isReturnAvailable(returnnInfo)) {
                    throw new DuplicateRecordException();
                }

                response = returnnDAO.append(returnnInfo);
            } else {
                response = returnnDAO.save(returnnInfo);
            }
            return response;
        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(ReturnParams.FILENAME, e);
        }
    }

    public static int updateReturn(Return returnnInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        ReturnDAO returnnDAO = new ReturnDAOImpl(JsonMapper.getInstance().getGson(), ReturnParams.FILENAME);
        try {
            if (FileUtils.notExist(ReturnParams.FILENAME)) {
                throw new MissingFileException(ReturnParams.FILENAME);
            }
            if (!returnnDAO.isReturnAvailable(returnnInfo)) {
                throw new RecordNotFoundException();
            }

            return returnnDAO.update(returnnInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(ReturnParams.FILENAME, e);
        }
    }

    public static int deleteReturn(Return returnnInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        ReturnDAO returnnDAO = new ReturnDAOImpl(JsonMapper.getInstance().getGson(), ReturnParams.FILENAME);
        try {
            if (FileUtils.notExist(ReturnParams.FILENAME)) {
                throw new MissingFileException(ReturnParams.FILENAME);
            }
            if (!returnnDAO.isReturnAvailable(returnnInfo)) {
                throw new RecordNotFoundException();
            }

            return returnnDAO.remove(returnnInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(ReturnParams.FILENAME, e);
        }
    }

    public static Return getReturnById(int id) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        ReturnDAO returnnDAO = new ReturnDAOImpl(JsonMapper.getInstance().getGson(), ReturnParams.FILENAME);
        try {
            if (FileUtils.notExist(ReturnParams.FILENAME)) {
                throw new MissingFileException(ReturnParams.FILENAME);
            }

            return returnnDAO.findById(id);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(ReturnParams.FILENAME, e);
        }
    }

    public static List<Return> getAllReturn() throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        ReturnDAO returnnDAO = new ReturnDAOImpl(JsonMapper.getInstance().getGson(), ReturnParams.FILENAME);
        try {
            if (FileUtils.notExist(ReturnParams.FILENAME)) {
                throw new MissingFileException(ReturnParams.FILENAME);
            }

            return returnnDAO.findAll();

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(ReturnParams.FILENAME, e);
        }
    }

    public static boolean isReturnAvailable(Return returnn) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        return getReturnById(returnn.getId()) != null;
    }

}
