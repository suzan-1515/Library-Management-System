/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.entity.transaction;

import com.nepal.lms.entity.book.BookInfo;
import com.nepal.lms.entity.borrow.Borrow;
import com.nepal.lms.entity.member.MemberInfo;
import com.nepal.lms.entity.returnn.Return;
import com.nepal.lms.entity.user.UserInfo;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Suzn
 */
public class Transaction implements Serializable {

    private int id;
    private BookInfo book;
    private MemberInfo member;
    private UserInfo user;
    private Borrow borrow;
    private Return retrn;
    private boolean status;
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
     * @param book the book to set
     */
    public void setBook(BookInfo book) {
        this.book = book;
    }

    /**
     * @return the member
     */
    public MemberInfo getMember() {
        return member;
    }

    /**
     * @param member the member to set
     */
    public void setMember(MemberInfo member) {
        this.member = member;
    }

    /**
     * @return the user
     */
    public UserInfo getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UserInfo user) {
        this.user = user;
    }

    /**
     * @return the borrow
     */
    public Borrow getBorrow() {
        return borrow;
    }

    /**
     * @param borrow the borrow to set
     */
    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    /**
     * @return the retrn
     */
    public Return getRetrn() {
        return retrn;
    }

    /**
     * @param retrn the retrn to set
     */
    public void setRetrn(Return retrn) {
        this.retrn = retrn;
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

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

}
