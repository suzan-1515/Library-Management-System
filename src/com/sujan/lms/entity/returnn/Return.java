/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.entity.returnn;

import com.sujan.lms.entity.book.Fine;
import java.io.Serializable;

/**
 *
 * @author Suzn
 */
public class Return implements Serializable {

    private int id;
    private Fine fine;
    private long returnedDate;

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
     * @return the returnedDate
     */
    public long getReturnedDate() {
        return returnedDate;
    }

    /**
     * @param returnedDate the returnedDate to set
     */
    public void setReturnedDate(long returnedDate) {
        this.returnedDate = returnedDate;
    }

}
