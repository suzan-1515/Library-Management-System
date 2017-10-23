/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.book;

import com.nepal.lms.dao.book.BookDAO;
import com.nepal.lms.dao.book.BookDAOImpl;
import com.nepal.lms.entity.author.Author;
import com.nepal.lms.entity.book.BookInfo;
import com.nepal.lms.entity.publisher.Publisher;
import com.nepal.lms.entity.shelf.Shelf;
import com.nepal.lms.entity.subject.Subject;
import java.io.IOException;
import java.util.List;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Suzn
 */
public class BookTest {

    static BookDAO bookDAO;

    @BeforeClass
    public static void setup() throws IOException {
        bookDAO = new BookDAOImpl();
    }

    @Test
    public void insertBookTestCase() {
        BookInfo book = new BookInfo();
        book.setId(2);
        book.setAuthor(new Author(1, "Sujan", "8526552"));
        book.setEdition("2008");
        book.setIsbn("252kj52");
        book.setNumberOfCopy(5);
        book.setPublisher(new Publisher(1, "Janata Publication", "4425639"));
        book.setShelfNo(new Shelf(1, "A4"));
        book.setSubject(new Subject(1, "Java"));
        book.setTitle("OOP Java");

        assertEquals(book.getId(), bookDAO.save(book));

    }

    @Test(expected = RuntimeException.class)
    public void insertBookWithException() {
        BookInfo book = new BookInfo();
        book.setId(2);
        book.setAuthor(new Author(1, "Sujan", "8526552"));
        book.setEdition("2008");
        book.setIsbn("252kj52");
        book.setNumberOfCopy(5);
        book.setPublisher(new Publisher(1, "Janata Publication", "4425639"));
        book.setShelfNo(new Shelf(1, "B4"));
        book.setSubject(new Subject(1, "Java"));
        book.setTitle("OOP Java");

        bookDAO.save(book);
    }

    @Test
    public void updateBookTestCase() {
        BookInfo book = new BookInfo();
        book.setId(1);
        book.setAuthor(new Author(2, "Rajesh", "2562"));
        book.setEdition("2010");
        book.setIsbn("2256fs");
        book.setNumberOfCopy(10);
        book.setPublisher(new Publisher(3, "Mero Publication", "455225"));
        book.setShelfNo(new Shelf(2, "B7"));
        book.setSubject(new Subject(4, "C++"));
        book.setTitle("C++ ho ho");

        assertEquals(book.getId(), bookDAO.update(book));
    }

    @Test
    public void updateBookWithInvalidIdTestCase() {
        BookInfo book = new BookInfo();
        book.setId(2);
        book.setAuthor(new Author(2, "Rajesh", "2562"));
        book.setEdition("2010");
        book.setIsbn("2256fs");
        book.setNumberOfCopy(10);
        book.setPublisher(new Publisher(3, "Mero Publication", "455225"));
        book.setShelfNo(new Shelf(2, "B7"));
        book.setSubject(new Subject(4, "C++"));
        book.setTitle("C++ ho ho");

        assertEquals(-1, bookDAO.update(book));
    }

    @Test
    public void getBookByIdTestCase() {
        BookInfo findById = bookDAO.findById(2);
        Assert.assertNotNull(findById);
        System.out.println(findById.getId());
    }

    @Test
    public void removeBookByIdTestCase() {
        BookInfo bookInfo = new BookInfo();
        bookInfo.setId(2);
        int id = bookDAO.remove(bookInfo);
        Assert.assertEquals(2, id);
    }

    @Test
    public void viewBookTestCase() {
        List<BookInfo> bookList = bookDAO.findAll();
        TestCase.assertFalse(bookList.isEmpty());
        bookList.stream().forEach(val -> System.out.printf("Title: %s \nId: %d\n", val.getTitle(), val.getId()));
    }

}
