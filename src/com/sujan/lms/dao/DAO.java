/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.dao;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Suzn
 * @param <T>
 */
public interface DAO<T> {

    int save(T t) throws IOException, JsonIOException, JsonSyntaxException;

    int append(T t) throws IOException, JsonIOException, JsonSyntaxException;

    int update(T t) throws IOException, JsonIOException, JsonSyntaxException;

    int remove(T t) throws IOException, JsonIOException, JsonSyntaxException;

    T findById(int id) throws IOException, JsonIOException, JsonSyntaxException;

    List<T> findAll() throws IOException, JsonIOException, JsonSyntaxException;
}
