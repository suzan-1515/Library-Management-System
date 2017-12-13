/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.book;

import com.sujan.lms.bll.AuthorBLL;
import com.sujan.lms.bll.BookBLL;
import com.sujan.lms.bll.PublisherBLL;
import com.sujan.lms.bll.ShelfBLL;
import com.sujan.lms.bll.SubjectBLL;
import com.sujan.lms.entity.author.Author;
import com.sujan.lms.entity.book.BookInfo;
import com.sujan.lms.entity.publisher.Publisher;
import com.sujan.lms.entity.shelf.Shelf;
import com.sujan.lms.entity.subject.Subject;
import com.sujan.lms.exception.CorruptedDataException;
import com.sujan.lms.exception.DuplicateRecordException;
import com.sujan.lms.exception.MissingFileException;
import com.sujan.lms.exception.RecordNotFoundException;
import com.sujan.lms.util.Utils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

/**
 *
 * @author Suzn
 */
public class BookList {

    @Test
    public void shelfListInsert() {
        ArrayList<String> shelfList = new ArrayList<>();
        shelfList.add("A1");
        shelfList.add("A2");
        shelfList.add("A3");
        shelfList.add("B1");
        shelfList.add("B2");
        shelfList.add("B3");
        shelfList.add("C1");
        shelfList.add("C2");
        shelfList.add("C3");
        shelfList.add("D1");
        shelfList.add("D2");
        shelfList.add("D3");
        shelfList.add("E1");

        shelfList.forEach(data -> {
            try {
                ShelfBLL.insertShelf(new Shelf(Utils.generateRandomID(), shelfList.get(randBetween(0, shelfList.size()))));
            } catch (DuplicateRecordException | MissingFileException | CorruptedDataException ex) {
                Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    @Test
    public void bookListInsert() {
        ArrayList<String> title = new ArrayList<>();
        ArrayList<String> isbn = new ArrayList<>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("note1.txt"));
            String line;
            boolean alter = true;
            while ((line = br.readLine()) != null) {
                if (alter) {
                    title.add(line);
                    alter = false;
                } else {
                    alter = true;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            br = new BufferedReader(new FileReader("note5.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                isbn.add(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            List<Author> authorList = AuthorBLL.getAllAuthor();
            List<Publisher> publisherList = PublisherBLL.getAllPublisher();
            List<Subject> subjectList = SubjectBLL.getAllSubject();
            List<Shelf> shelfList = ShelfBLL.getAllShelf();

            System.out.println("author: "+authorList.size());
            System.out.println("publisher: "+publisherList.size());
            System.out.println("subject: "+subjectList.size());
            System.out.println("shelf: "+shelfList.size());
            System.out.println("title: "+title.size());
            System.out.println("isbn: "+isbn.size());
            
            int id = 5423;
            
            for (int i = 0; i < 100; i++) {
                BookInfo book = new BookInfo();
                book.setId(Utils.generateRandomID());
                book.setTitle(title.get(i));
                book.setSubject(subjectList.get(randBetween(0, subjectList.size()-1)));
                book.setAuthor(authorList.get(i));
                book.setPublisher(publisherList.get(i));
                book.setNumberOfCopy(randBetween(5, 15));
                book.setAvailableCopies(book.getNumberOfCopy());
                book.setEdition(String.valueOf(randBetween(1984, 2016)));
                book.setIsbn(isbn.get(i));
                book.setShelfNo(shelfList.get(randBetween(0, shelfList.size()-1)));

                try {
                    BookBLL.insertBook(book);
                    id++;
                } catch (DuplicateRecordException | MissingFileException | CorruptedDataException ex) {
                    Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (RecordNotFoundException | MissingFileException | CorruptedDataException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

}
