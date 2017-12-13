/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.bll;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.sujan.lms.dao.book.BookDAO;
import com.sujan.lms.dao.book.BookDAOImpl;
import com.sujan.lms.entity.book.Book;
import com.sujan.lms.entity.book.BookInfo;
import com.sujan.lms.entity.book.BookParams;
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
 * @author Suzn
 */
public class BookBLL {

    public static int insertBook(BookInfo bookInfo) throws DuplicateRecordException, MissingFileException, CorruptedDataException {
        BookDAO bookManager = new BookDAOImpl(JsonMapper.getInstance().getGson(), BookParams.FILENAME);
        try {
            int response = -1;
            if (FileUtils.exists(BookParams.FILENAME)) {

                if (bookManager.isBookAvailable(bookInfo)) {
                    throw new DuplicateRecordException();
                }

                response = bookManager.append(bookInfo);
            } else {
                response = bookManager.save(bookInfo);
            }
            return response;
        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(BookParams.FILENAME, e);
        }
    }

    public static int updateBook(BookInfo bookInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        BookDAO bookManager = new BookDAOImpl(JsonMapper.getInstance().getGson(), BookParams.FILENAME);
        try {
            if (FileUtils.notExist(BookParams.FILENAME)) {
                throw new MissingFileException(BookParams.FILENAME);
            }
            if (!bookManager.isBookAvailable(bookInfo)) {
                throw new RecordNotFoundException();
            }

            return bookManager.update(bookInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(BookParams.FILENAME, e);
        }
    }

    public static int deleteBook(BookInfo bookInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        BookDAO bookManager = new BookDAOImpl(JsonMapper.getInstance().getGson(), BookParams.FILENAME);
        try {
            if (FileUtils.notExist(BookParams.FILENAME)) {
                throw new MissingFileException(BookParams.FILENAME);
            }
            if (!bookManager.isBookAvailable(bookInfo)) {
                throw new RecordNotFoundException();
            }

            return bookManager.remove(bookInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(BookParams.FILENAME, e);
        }
    }

    public static BookInfo getBookById(int id) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        BookDAO bookManager = new BookDAOImpl(JsonMapper.getInstance().getGson(), BookParams.FILENAME);
        try {
            if (FileUtils.notExist(BookParams.FILENAME)) {
                throw new MissingFileException(BookParams.FILENAME);
            }

            return bookManager.findById(id);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(BookParams.FILENAME, e);
        }
    }

    public static List<BookInfo> getAllBook() throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        BookDAO bookManager = new BookDAOImpl(JsonMapper.getInstance().getGson(), BookParams.FILENAME);
        try {
            if (FileUtils.notExist(BookParams.FILENAME)) {
                throw new MissingFileException(BookParams.FILENAME);
            }

            return bookManager.findAll();

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
