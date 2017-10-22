/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.dao.book;

import com.nepal.lms.dao.DAO;
import com.nepal.lms.entity.book.Book;
import com.nepal.lms.entity.book.BookInfo;

/**
 *
 * @author Suzn
 */
public interface BookDAO extends DAO<BookInfo> {

    boolean isBookAvailable(Book book);

}
