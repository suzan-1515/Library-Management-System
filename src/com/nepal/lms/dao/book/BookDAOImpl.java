/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.dao.book;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.nepal.lms.entity.book.Book;
import com.nepal.lms.entity.book.BookInfo;
import com.nepal.lms.entity.book.BookBean;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Suzn
 */
public class BookDAOImpl implements BookDAO {

    private static final String FILENAME = "BookInfo.json";
    private final Gson gson;

    public BookDAOImpl() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public boolean isBookAvailable(Book book) {
        try {
            return findById(book.getId()) != null;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @SuppressWarnings("UseSpecificCatch")
    public int save(BookInfo t) {
        try {

            if (Files.notExists(Paths.get(FILENAME))) {
                try (Writer writer = new FileWriter(FILENAME)) {
                    gson.toJson(Arrays.asList(t), writer);
                }
            } else {
                try (Reader reader = new FileReader(FILENAME)) {
                    JsonArray rootArray = gson.fromJson(reader, JsonArray.class);
                    JsonObject newData = new JsonParser().parse(gson.toJson(t)).getAsJsonObject();

                    rootArray.add(newData);

                    try (Writer writer = new FileWriter(FILENAME)) {
                        gson.toJson(rootArray, writer);
                    }

                }
            }
            return t.getId();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(BookInfo t) {
        try {

            return 0;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public int remove(BookInfo t) {
        try {

            return 0;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public BookInfo findById(int id) {
        try {

            return null;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @SuppressWarnings("UseSpecificCatch")
    public List<BookInfo> findAll() {
        try {
            if (Files.notExists(Paths.get(FILENAME))) {
                return Collections.EMPTY_LIST;
            } else {
                try (Reader reader = new FileReader(FILENAME)) {
                    return gson.fromJson(reader, new TypeToken<List<BookInfo>>() {
                    }.getType());
                }
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

}
