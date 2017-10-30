/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.bll;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.nepal.lms.dao.borrow.BorrowDAO;
import com.nepal.lms.dao.borrow.BorrowDAOImpl;
import com.nepal.lms.entity.borrow.Borrow;
import com.nepal.lms.entity.borrow.BorrowParams;
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
 * @borrow Suzn
 */
public class BorrowBLL {

    public static int insertBorrow(Borrow borrowInfo) throws DuplicateRecordException, MissingFileException, CorruptedDataException {
        BorrowDAO borrowDAO = new BorrowDAOImpl(JsonMapper.getInstance().getGson(), BorrowParams.FILENAME);
        try {
            int response = -1;
            if (FileUtils.exists(BorrowParams.FILENAME)) {

                if (borrowDAO.isBorrowAvailable(borrowInfo)) {
                    throw new DuplicateRecordException();
                }

                response = borrowDAO.append(borrowInfo);
            } else {
                response = borrowDAO.save(borrowInfo);
            }
            return response;
        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(BorrowParams.FILENAME, e);
        }
    }

    public static int updateBorrow(Borrow borrowInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        BorrowDAO borrowDAO = new BorrowDAOImpl(JsonMapper.getInstance().getGson(), BorrowParams.FILENAME);
        try {
            if (FileUtils.notExist(BorrowParams.FILENAME)) {
                throw new MissingFileException(BorrowParams.FILENAME);
            }
            if (!borrowDAO.isBorrowAvailable(borrowInfo)) {
                throw new RecordNotFoundException();
            }

            return borrowDAO.update(borrowInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(BorrowParams.FILENAME, e);
        }
    }

    public static int deleteBorrow(Borrow borrowInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        BorrowDAO borrowDAO = new BorrowDAOImpl(JsonMapper.getInstance().getGson(), BorrowParams.FILENAME);
        try {
            if (FileUtils.notExist(BorrowParams.FILENAME)) {
                throw new MissingFileException(BorrowParams.FILENAME);
            }
            if (!borrowDAO.isBorrowAvailable(borrowInfo)) {
                throw new RecordNotFoundException();
            }

            return borrowDAO.remove(borrowInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(BorrowParams.FILENAME, e);
        }
    }

    public static Borrow getBorrowById(int id) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        BorrowDAO borrowDAO = new BorrowDAOImpl(JsonMapper.getInstance().getGson(), BorrowParams.FILENAME);
        try {
            if (FileUtils.notExist(BorrowParams.FILENAME)) {
                throw new MissingFileException(BorrowParams.FILENAME);
            }

            return borrowDAO.findById(id);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(BorrowParams.FILENAME, e);
        }
    }

    public static List<Borrow> getAllBorrow() throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        BorrowDAO borrowDAO = new BorrowDAOImpl(JsonMapper.getInstance().getGson(), BorrowParams.FILENAME);
        try {
            if (FileUtils.notExist(BorrowParams.FILENAME)) {
                throw new MissingFileException(BorrowParams.FILENAME);
            }

            return borrowDAO.findAll();

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(BorrowParams.FILENAME, e);
        }
    }

    public static boolean isBorrowAvailable(Borrow borrow) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        return getBorrowById(borrow.getId()) != null;
    }

}
