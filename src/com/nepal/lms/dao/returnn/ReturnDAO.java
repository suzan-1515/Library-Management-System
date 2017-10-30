/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.dao.returnn;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.nepal.lms.dao.DAO;
import com.nepal.lms.entity.returnn.Return;
import java.io.IOException;

/**
 *
 * @author Suzn
 */
public interface ReturnDAO extends DAO<Return> {

    boolean isReturnAvailable(Return r) throws IOException, JsonIOException, JsonSyntaxException;

}
