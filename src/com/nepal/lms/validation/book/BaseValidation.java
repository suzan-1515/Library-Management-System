/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.validation.book;

/**
 *
 * @author Suzn
 */
public abstract class BaseValidation {

    protected boolean isStringEmptyOrNull(String s) {
        s = s.trim();
        return (s == null || s.isEmpty() || s.matches(""));
    }

    protected boolean isContactValid(String c) {
        c = c.trim();
        return (c.length() < 9 || c.length() > 10);
    }

}
