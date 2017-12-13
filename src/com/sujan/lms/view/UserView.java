/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.view;

import com.sujan.lms.entity.user.UserInfo;

/**
 *
 * @author Suzn
 */
public interface UserView extends View<UserInfo> {

    void onUserRowDataAdd(UserInfo u);

    void onUserDataRemove(UserInfo u);

}
