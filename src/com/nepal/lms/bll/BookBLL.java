/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.bll;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.nepal.lms.dao.book.BookDAO;
import com.nepal.lms.dao.book.BookDAOImpl;
import com.nepal.lms.entity.book.Book;
import com.nepal.lms.entity.book.BookInfo;
import com.nepal.lms.entity.book.BookParams;
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
public class BookBLL {

    public static int insertBook(BookInfo bookInfo) throws DuplicateRecordException, MissingFileException, CorruptedDataException {
        BookDAO bookDAO = new BookDAOImpl(JsonMapper.getInstance().getGson(), BookParams.FILENAME);
        try {
            int response = -1;
            if (FileUtils.exists(BookParams.FILENAME)) {

                if (bookDAO.isBookAvailable(bookInfo)) {
                    throw new DuplicateRecordException();
                }

                response = bookDAO.append(bookInfo);
            } else {
                response = bookDAO.save(bookInfo);
            }
            return response;
        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(BookParams.FILENAME, e);
        }
    }

    public static int updateBook(BookInfo bookInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        BookDAO bookDAO = new BookDAOImpl(JsonMapper.getInstance().getGson(), BookParams.FILENAME);
        try {
            if (FileUtils.notExist(BookParams.FILENAME)) {
                throw new MissingFileException(BookParams.FILENAME);
            }
            if (!bookDAO.isBookAvailable(bookInfo)) {
                throw new RecordNotFoundException();
            }

            return bookDAO.update(bookInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(BookParams.FILENAME, e);
        }
    }

    public static int deleteBook(BookInfo bookInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        BookDAO bookDAO = new BookDAOImpl(JsonMapper.getInstance().getGson(), BookParams.FILENAME);
        try {
            if (FileUtils.notExist(BookParams.FILENAME)) {
                throw new MissingFileException(BookParams.FILENAME);
            }
            if (!bookDAO.isBookAvailable(bookInfo)) {
                throw new RecordNotFoundException();
            }

            return bookDAO.remove(bookInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(BookParams.FILENAME, e);
        }
    }

    public static BookInfo getBookById(int id) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        BookDAO bookDAO = new BookDAOImpl(JsonMapper.getInstance().getGson(), BookParams.FILENAME);
        try {
            if (FileUtils.notExist(BookParams.FILENAME)) {
                throw new MissingFileException(BookParams.FILENAME);
            }

            return bookDAO.findById(id);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(BookParams.FILENAME, e);
        }
    }

    public static List<BookInfo> getAllBook() throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        BookDAO bookDAO = new BookDAOImpl(JsonMapper.getInstance().getGson(), BookParams.FILENAME);
        try {
            if (FileUtils.notExist(BookParams.FILENAME)) {
                throw new MissingFileException(BookParams.FILENAME);
            }

            return bookDAO.findAll();

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(BookParams.FILENAME, e);
        }
    }

    public static boolean isBookAvailable(Book book) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        return getBookById(book.getId()) != null;
    }

}
