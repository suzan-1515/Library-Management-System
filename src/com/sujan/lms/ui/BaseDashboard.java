/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.ui;

import com.sujan.lms.access.UserAccess;
import com.sujan.lms.entity.user.UserInfo;
import javax.swing.JFrame;
import com.sujan.lms.view.UserPermission;

/**
 *
 * @author Suzn
 */
public abstract class BaseDashboard extends JFrame implements UserPermission {

    private final UserAccess userAccess;

    public BaseDashboard() {
        userAccess = new UserAccess();
    }

    @Override
    public void setupUserView(UserInfo userInfo) {
        if (userAccess.isAdmin(userInfo)) {
            setupAdminView();
        } else if (userAccess.isLibrarian(userInfo)) {
            setupLibrarianView();
        }
    }

    protected abstract void setupAdminView();

    protected abstract void setupLibrarianView();

}
