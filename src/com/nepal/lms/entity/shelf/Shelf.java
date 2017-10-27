/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.entity.shelf;

import java.io.Serializable;

/**
 *
 * @author Suzn
 */
public class Shelf implements Serializable{
    
    private int id;
    private String location;

    public Shelf() {
    }
    
    public Shelf(int id, String location) {
        this.id = id;
        this.location = location;
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
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }
    
}
