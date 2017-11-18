/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.entity.borrow;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Suzn
 */
public class Borrow implements Serializable {

    private int id;
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
