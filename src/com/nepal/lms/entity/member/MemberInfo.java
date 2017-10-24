/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.entity.member;

import java.sql.Date;

/**
 *
 * @author Suzn
 */
public class MemberInfo extends Member {

    private String membershipId;
    private Date expiryDate;
    private Date joinedDate;

    /**
     * @return the membershipId
     */
    public String getMembershipId() {
        return membershipId;
    }

    /**
     * @param membershipId the membershipId to set
     */
    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    /**
     * @return the expiryDate
     */
    public Date getExpiryDate() {
        return expiryDate;
    }

    /**
     * @param expiryDate the expiryDate to set
     */
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * @return the joinedDate
     */
    public Date getJoinedDate() {
        return joinedDate;
    }

    /**
     * @param joinedDate the joinedDate to set
     */
    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

}
