/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.entity.author;

import java.io.Serializable;

/**
 *
 * @author Suzn
 */
public class Author implements Serializable {

    private int id;
    private String title;
    private String contact;

    public Author() {
    }

    public Author(int id) {
        this.id = id;
    }

    public Author(int id, String title, String contact) {
        this.id = id;
        this.title = title;
        this.contact = contact;
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
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
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

}
