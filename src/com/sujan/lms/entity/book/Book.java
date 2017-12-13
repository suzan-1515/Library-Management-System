/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.entity.book;

import com.sujan.lms.entity.shelf.Shelf;
import com.sujan.lms.entity.author.Author;
import com.sujan.lms.entity.publisher.Publisher;
import com.sujan.lms.entity.subject.Subject;
import java.io.Serializable;

/**
 *
 * @author Suzn
 */
public class Book implements Serializable {

    private int id;
    private String title;
    private Subject subject;
    private Author author;
    private Publisher publisher;
    private String edition;
    private String isbn;
    private Shelf shelfNo;
    private int numberOfCopy;

    public Book() {
    }

    
    
    public Book(int id) {
        this.id = id;
    }

        
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * @return the author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * @return the publisher
     */
    public Publisher getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the edition
     */
    public String getEdition() {
        return edition;
    }

    /**
     * @param edition the edition to set
     */
    public void setEdition(String edition) {
        this.edition = edition;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the shelfNo
     */
    public Shelf getShelfNo() {
        return shelfNo;
    }

    /**
     * @param shelfNo the shelfNo to set
     */
    public void setShelfNo(Shelf shelfNo) {
        this.shelfNo = shelfNo;
    }

    /**
     * @return the numberOfCopy
     */
    public int getNumberOfCopy() {
        return numberOfCopy;
    }

    /**
     * @param numberOfCopy the numberOfCopy to set
     */
    public void setNumberOfCopy(int numberOfCopy) {
        this.numberOfCopy = numberOfCopy;
    }

}
