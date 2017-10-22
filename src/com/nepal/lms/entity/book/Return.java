/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.entity.book;

import com.nepal.lms.entity.member.Member;
import com.nepal.lms.entity.user.User;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Suzn
 */
public class Return implements Serializable{
    
    private int id;
    private Books books;
    private Member member;
    private User user;
    private Fine fine;
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
     * @return the books
     */
    public Books getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(Books books) {
        this.books = books;
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
     * @return the fine
     */
    public Fine getFine() {
        return fine;
    }

    /**
     * @param fine the fine to set
     */
    public void setFine(Fine fine) {
        this.fine = fine;
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
