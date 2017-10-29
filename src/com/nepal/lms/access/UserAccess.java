/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.access;

import com.nepal.lms.entity.user.UserInfo;

/**
 *
 * @author Suzn
 */
public class UserAccess {

    public static final int ADMIN = 1;
    public static final int LIBRARIAN = 2;

    public boolean isAdmin(UserInfo userInfo) {
        return userInfo.getRole().getId() == ADMIN;
    }

    public boolean isLibrarian(UserInfo userInfo) {
        return userInfo.getRole().getId() == LIBRARIAN;
    }

}
