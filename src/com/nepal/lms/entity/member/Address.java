/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.entity.member;

import java.io.Serializable;

/**
 *
 * @author Suzn
 */
public class Address implements Serializable{
    
    private int id;
    private String permanent;
    private String temporary;

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
