/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.entity.book;

/**
 *
 * @author Suzn
 */
public class BookInfo extends Book {

    private int availableCopies;

    /**
     * @return the available
     */
    public boolean isAvailable() {
        return getAvailableCopies() > 0;
    }

    /**
     * @return the availableCopies
     */
    public int getAvailableCopies() {
        return availableCopies;
    }

    /**
     * @param availableCopies the availableCopies to set
     */
    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    @Override
    public void setNumberOfCopy(int numberOfCopy) {
        super.setNumberOfCopy(numberOfCopy);
        setAvailableCopies(numberOfCopy);
    }

}
