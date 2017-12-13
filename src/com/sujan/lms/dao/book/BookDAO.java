/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.dao.book;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.sujan.lms.dao.DAO;
import com.sujan.lms.entity.book.Book;
import com.sujan.lms.entity.book.BookInfo;
import java.io.IOException;

/**
 *
 * @author Suzn
 */
public interface BookDAO extends DAO<BookInfo> {

    boolean isBookAvailable(Book book) throws IOException, JsonIOException, JsonSyntaxException;

}
