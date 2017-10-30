/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.entity.borrow;

import com.nepal.lms.entity.book.Book;
import com.nepal.lms.entity.book.BookInfo;
import com.nepal.lms.entity.member.Member;
import com.nepal.lms.entity.user.User;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Suzn
 */
public class Borrow implements Serializable {

    private int id;
    private BookInfo book;
    private Member member;
    private User user;
    private int numOfDays;
    private long returningDate;
    private Timestamp timestamp;

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
     * @return the book
     */
    public BookInfo getBook() {
        return book;
    }

    /**
     * @param book the books to set
     */
    public void setBook(BookInfo book) {
        this.book = book;
    }

    /**
     * @return the member
     */
    public Member getMember() {
        return member;
    }

    /**
     * @param member the member to set
     */
    public void setMember(Member member) {
        this.member = member;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the numOfDays
     */
    public int getNumOfDays() {
        return numOfDays;
    }

    /**
     * @param numOfDays the numOfDays to set
     */
    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    /**
     * @return the returningDate
     */
    public long getReturningDate() {
        return returningDate;
    }

    /**
     * @param returningDate the returningDate to set
     */
    public void setReturningDate(long returningDate) {
        this.returningDate = returningDate;
    }

    /**
     * @return the timestamp
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

}
