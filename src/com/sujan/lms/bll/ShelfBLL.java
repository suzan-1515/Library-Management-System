/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.bll;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.sujan.lms.dao.shelf.ShelfDAO;
import com.sujan.lms.dao.shelf.ShelfDAOImpl;
import com.sujan.lms.entity.shelf.Shelf;
import com.sujan.lms.entity.shelf.ShelfParams;
import com.sujan.lms.exception.CorruptedDataException;
import com.sujan.lms.exception.DuplicateRecordException;
import com.sujan.lms.exception.MissingFileException;
import com.sujan.lms.exception.RecordNotFoundException;
import com.sujan.lms.json.JsonMapper;
import com.sujan.lms.util.FileUtils;
import java.io.IOException;
import java.util.List;

/**
 *
 * @shelf Suzn
 */
public class ShelfBLL {

    public static int insertShelf(Shelf shelfInfo) throws DuplicateRecordException, MissingFileException, CorruptedDataException {
        ShelfDAO shelfDAO = new ShelfDAOImpl(JsonMapper.getInstance().getGson(), ShelfParams.FILENAME);
        try {
            int response = -1;
            if (FileUtils.exists(ShelfParams.FILENAME)) {

                if (shelfDAO.isShelfAvailable(shelfInfo)) {
                    throw new DuplicateRecordException();
                }

                response = shelfDAO.append(shelfInfo);
            } else {
                response = shelfDAO.save(shelfInfo);
            }
            return response;
        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(ShelfParams.FILENAME, e);
        }
    }

    public static int updateShelf(Shelf shelfInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        ShelfDAO shelfDAO = new ShelfDAOImpl(JsonMapper.getInstance().getGson(), ShelfParams.FILENAME);
        try {
            if (FileUtils.notExist(ShelfParams.FILENAME)) {
                throw new MissingFileException(ShelfParams.FILENAME);
            }
            if (!shelfDAO.isShelfAvailable(shelfInfo)) {
                throw new RecordNotFoundException();
            }

            return shelfDAO.update(shelfInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(ShelfParams.FILENAME, e);
        }
    }

    public static int deleteShelf(Shelf shelfInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        ShelfDAO shelfDAO = new ShelfDAOImpl(JsonMapper.getInstance().getGson(), ShelfParams.FILENAME);
        try {
            if (FileUtils.notExist(ShelfParams.FILENAME)) {
                throw new MissingFileException(ShelfParams.FILENAME);
            }
            if (!shelfDAO.isShelfAvailable(shelfInfo)) {
                throw new RecordNotFoundException();
            }

            return shelfDAO.remove(shelfInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(ShelfParams.FILENAME, e);
        }
    }

    public static Shelf getShelfById(int id) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        ShelfDAO shelfDAO = new ShelfDAOImpl(JsonMapper.getInstance().getGson(), ShelfParams.FILENAME);
        try {
            if (FileUtils.notExist(ShelfParams.FILENAME)) {
                throw new MissingFileException(ShelfParams.FILENAME);
            }

            return shelfDAO.findById(id);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(ShelfParams.FILENAME, e);
        }
    }

    public static List<Shelf> getAllShelf() throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        ShelfDAO shelfDAO = new ShelfDAOImpl(JsonMapper.getInstance().getGson(), ShelfParams.FILENAME);
        try {
            if (FileUtils.notExist(ShelfParams.FILENAME)) {
                throw new MissingFileException(ShelfParams.FILENAME);
            }

            return shelfDAO.findAll();

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(ShelfParams.FILENAME, e);
        }
    }

    public static boolean isShelfAvailable(Shelf shelf) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        return getShelfById(shelf.getId()) != null;
    }

}
