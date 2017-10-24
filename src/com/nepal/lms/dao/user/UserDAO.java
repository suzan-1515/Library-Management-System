/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.dao.user;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.nepal.lms.dao.DAO;
import com.nepal.lms.entity.user.User;
import com.nepal.lms.entity.user.UserInfo;
import java.io.IOException;

/**
 *
 * @author Suzn
 */
public interface UserDAO extends DAO<UserInfo> {

    boolean isUserAvailable(User user) throws IOException, JsonIOException, JsonSyntaxException;

    UserInfo loginUser(User user) throws IOException, JsonIOException, JsonSyntaxException;

}
