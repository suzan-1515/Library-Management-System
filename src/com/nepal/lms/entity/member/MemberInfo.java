/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.entity.member;

/**
 *
 * @author Suzn
 */
public class MemberInfo extends Member {

    private long expiryDate;
    private long joinedDate;

    /**
     * @return the expiryDate
     */
    public long getExpiryDate() {
        return expiryDate;
    }

    /**
     * @param expiryDate the expiryDate to set
     */
    public void setExpiryDate(long expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * @return the joinedDate
     */
    public long getJoinedDate() {
        return joinedDate;
    }

    /**
     * @param joinedDate the joinedDate to set
     */
    public void setJoinedDate(long joinedDate) {
        this.joinedDate = joinedDate;
    }

}
