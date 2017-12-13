/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.dao.publisher;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.sujan.lms.dao.DAO;
import com.sujan.lms.entity.publisher.Publisher;
import java.io.IOException;

/**
 *
 * @author Suzn
 */
public interface PublisherDAO extends DAO<Publisher> {

    boolean isPublisherAvailable(Publisher book) throws IOException, JsonIOException, JsonSyntaxException;

}
