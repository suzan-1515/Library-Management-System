/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.entity.address;

import java.io.Serializable;

/**
 *
 * @author Suzn
 */
public class Address implements Serializable {

    private String permanent;
    private String temporary;

    public Address() {
    }

    public Address(String permanent, String temporary) {
        this.permanent = permanent;
        this.temporary = temporary;
    }

    public Address(String temporary) {
        this.permanent = temporary;
        this.temporary = temporary;
    }

    /**
     * @return the permanent
     */
    public String getPermanent() {
        return permanent;
    }

    /**
     * @param permanent the permanent to set
     */
    public void setPermanent(String permanent) {
        this.permanent = permanent;
    }

    /**
     * @return the temporary
     */
    public String getTemporary() {
        return temporary;
    }

    /**
     * @param temporary the temporary to set
     */
    public void setTemporary(String temporary) {
        this.temporary = temporary;
    }

}
