/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.ui.dashboard;

import com.nepal.lms.access.UserAccess;
import com.nepal.lms.entity.user.UserInfo;
import com.nepal.lms.view.UserView;
import javax.swing.JFrame;

/**
 *
 * @author Suzn
 */
public abstract class BaseDashboard extends JFrame implements UserView {

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
