/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.bll;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.nepal.lms.dao.transaction.TransactionDAO;
import com.nepal.lms.dao.transaction.TransactionDAOImpl;
import com.nepal.lms.entity.transaction.Transaction;
import com.nepal.lms.entity.transaction.TransactionParams;
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
 * @transaction Suzn
 */
public class TransactionBLL {

    public static int insertTransaction(Transaction transactionInfo) throws DuplicateRecordException, MissingFileException, CorruptedDataException {
        TransactionDAO transactionDAO = new TransactionDAOImpl(JsonMapper.getInstance().getGson(), TransactionParams.FILENAME);
        try {
            int response = -1;
            if (FileUtils.exists(TransactionParams.FILENAME)) {

                if (transactionDAO.isTransactionAvailable(transactionInfo)) {
                    throw new DuplicateRecordException();
                }

                response = transactionDAO.append(transactionInfo);
            } else {
                response = transactionDAO.save(transactionInfo);
            }
            return response;
        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(TransactionParams.FILENAME, e);
        }
    }

    public static int updateTransaction(Transaction transactionInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        TransactionDAO transactionDAO = new TransactionDAOImpl(JsonMapper.getInstance().getGson(), TransactionParams.FILENAME);
        try {
            if (FileUtils.notExist(TransactionParams.FILENAME)) {
                throw new MissingFileException(TransactionParams.FILENAME);
            }
            if (!transactionDAO.isTransactionAvailable(transactionInfo)) {
                throw new RecordNotFoundException();
            }

            return transactionDAO.update(transactionInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(TransactionParams.FILENAME, e);
        }
    }

    public static int deleteTransaction(Transaction transactionInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        TransactionDAO transactionDAO = new TransactionDAOImpl(JsonMapper.getInstance().getGson(), TransactionParams.FILENAME);
        try {
            if (FileUtils.notExist(TransactionParams.FILENAME)) {
                throw new MissingFileException(TransactionParams.FILENAME);
            }
            if (!transactionDAO.isTransactionAvailable(transactionInfo)) {
                throw new RecordNotFoundException();
            }

            return transactionDAO.remove(transactionInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(TransactionParams.FILENAME, e);
        }
    }

    public static Transaction getTransactionById(int id) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        TransactionDAO transactionDAO = new TransactionDAOImpl(JsonMapper.getInstance().getGson(), TransactionParams.FILENAME);
        try {
            if (FileUtils.notExist(TransactionParams.FILENAME)) {
                throw new MissingFileException(TransactionParams.FILENAME);
            }

            return transactionDAO.findById(id);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(TransactionParams.FILENAME, e);
        }
    }

    public static List<Transaction> getAllTransaction() throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        TransactionDAO transactionDAO = new TransactionDAOImpl(JsonMapper.getInstance().getGson(), TransactionParams.FILENAME);
        try {
            if (FileUtils.notExist(TransactionParams.FILENAME)) {
                throw new MissingFileException(TransactionParams.FILENAME);
            }

            return transactionDAO.findAll();

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(TransactionParams.FILENAME, e);
        }
    }

    public static boolean isTransactionAvailable(Transaction transaction) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        return getTransactionById(transaction.getId()) != null;
    }

}
