/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.entity.transaction;

import com.sujan.lms.entity.Params;

/**
 *
 * @author Suzn
 */
public class TransactionParams extends Params {

    public enum Status {
        BORROWED,
        RETURNED
    }

    public static final String FILENAME = "TransactionInfo.json";

    public static final String BOOK = "Book";
    public static final String MEMBER = "Member";
    public static final String USER = "User";
    public static final String BORROW = "borrow";
    public static final String RETURN = "retrn";
    public static final String STATUS = "status";

}
