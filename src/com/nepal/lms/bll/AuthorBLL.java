/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.bll;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.nepal.lms.dao.author.AuthorDAO;
import com.nepal.lms.dao.author.AuthorDAOImpl;
import com.nepal.lms.entity.author.Author;
import com.nepal.lms.entity.author.AuthorParams;
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
public class AuthorBLL {

    public static int insertAuthor(Author authorInfo) throws DuplicateRecordException, MissingFileException, CorruptedDataException {
        AuthorDAO authorDAO = new AuthorDAOImpl(JsonMapper.getInstance().getGson(), AuthorParams.FILENAME);
        try {
            int response = -1;
            if (FileUtils.exists(AuthorParams.FILENAME)) {

                if (authorDAO.isAuthorAvailable(authorInfo)) {
                    throw new DuplicateRecordException();
                }

                response = authorDAO.append(authorInfo);
            } else {
                response = authorDAO.save(authorInfo);
            }
            return response;
        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(AuthorParams.FILENAME, e);
        }
    }

    public static int updateAuthor(Author authorInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        AuthorDAO authorDAO = new AuthorDAOImpl(JsonMapper.getInstance().getGson(), AuthorParams.FILENAME);
        try {
            if (FileUtils.notExist(AuthorParams.FILENAME)) {
                throw new MissingFileException(AuthorParams.FILENAME);
            }
            if (!authorDAO.isAuthorAvailable(authorInfo)) {
                throw new RecordNotFoundException();
            }

            return authorDAO.update(authorInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(AuthorParams.FILENAME, e);
        }
    }

    public static int deleteAuthor(Author authorInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        AuthorDAO authorDAO = new AuthorDAOImpl(JsonMapper.getInstance().getGson(), AuthorParams.FILENAME);
        try {
            if (FileUtils.notExist(AuthorParams.FILENAME)) {
                throw new MissingFileException(AuthorParams.FILENAME);
            }
            if (!authorDAO.isAuthorAvailable(authorInfo)) {
                throw new RecordNotFoundException();
            }

            return authorDAO.remove(authorInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(AuthorParams.FILENAME, e);
        }
    }

    public static Author getAuthorById(int id) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        AuthorDAO authorDAO = new AuthorDAOImpl(JsonMapper.getInstance().getGson(), AuthorParams.FILENAME);
        try {
            if (FileUtils.notExist(AuthorParams.FILENAME)) {
                throw new MissingFileException(AuthorParams.FILENAME);
            }

            return authorDAO.findById(id);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(AuthorParams.FILENAME, e);
        }
    }

    public static List<Author> getAllAuthor() throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        AuthorDAO authorDAO = new AuthorDAOImpl(JsonMapper.getInstance().getGson(), AuthorParams.FILENAME);
        try {
            if (FileUtils.notExist(AuthorParams.FILENAME)) {
                throw new MissingFileException(AuthorParams.FILENAME);
            }

            return authorDAO.findAll();

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(AuthorParams.FILENAME, e);
        }
    }

    public static boolean isAuthorAvailable(Author author) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        return getAuthorById(author.getId()) != null;
    }

}
