/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.dao.book;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.nepal.lms.entity.book.Book;
import com.nepal.lms.entity.book.BookInfo;
import com.nepal.lms.entity.book.BookParams;
import com.nepal.lms.util.JsonHelper;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
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
    public int save(BookInfo t) {
        try {

            if (Files.notExists(Paths.get(FILENAME))) {
                JsonHelper.writeToFile(Arrays.asList(t), FILENAME, gson);
            } else {
                try (Reader reader = new FileReader(FILENAME)) {
                    JsonArray rootArray = gson.fromJson(reader, JsonArray.class);
                    JsonObject newData = new JsonParser().parse(gson.toJson(t)).getAsJsonObject();

                    rootArray.add(newData);

                    JsonHelper.writeToFile(rootArray, FILENAME, gson);

                }
            }
            return t.getId();
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(BookInfo t) {
        try {

            try (Reader reader = new FileReader(FILENAME)) {
                JsonArray rootArray = gson.fromJson(reader, JsonArray.class);
                Iterator<JsonElement> iterator = rootArray.iterator();
                boolean found = false;
                while (iterator.hasNext()) {
                    JsonObject item = iterator.next().getAsJsonObject();
                    if (item.get(BookParams.ID).getAsInt() == t.getId()) {

                        item.addProperty(BookParams.AVAILABLE_COPIES, t.getAvailableCopies());
                        item.addProperty(BookParams.TITLE, t.getTitle());
                        item.add(BookParams.SUBJECT, gson.toJsonTree(t.getSubject()));
                        item.add(BookParams.AUTHOR, gson.toJsonTree(t.getAuthor()));
                        item.add(BookParams.PUBLISHER, gson.toJsonTree(t.getPublisher()));
                        item.addProperty(BookParams.EDITION, t.getEdition());
                        item.addProperty(BookParams.ISBN, t.getIsbn());
                        item.add(BookParams.SHELF_NO, gson.toJsonTree(t.getShelfNo()));
                        item.addProperty(BookParams.NUMBER_OF_COPY, t.getNumberOfCopy());

                        found = true;
                        break;
                    }
                }
                if (found) {
                    JsonHelper.writeToFile(rootArray, FILENAME, gson);
                    return t.getId();
                }

            }
            return -1;
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public int remove(BookInfo t) {
        try {

            try (Reader reader = new FileReader(FILENAME)) {
                JsonArray rootArray = gson.fromJson(reader, JsonArray.class);
                Iterator<JsonElement> iterator = rootArray.iterator();
                boolean found = false;
                while (iterator.hasNext()) {
                    JsonObject item = iterator.next().getAsJsonObject();
                    if (item.get(BookParams.ID).getAsInt() == t.getId()) {
                        rootArray.remove(item);
                        found = true;
                        break;
                    }
                }
                if (found) {
                    JsonHelper.writeToFile(rootArray, FILENAME, gson);
                    return t.getId();
                }

            }
            return -1;
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public BookInfo findById(int id) {
        try {

            try (Reader reader = new FileReader(FILENAME)) {
                JsonArray rootArray = gson.fromJson(reader, JsonArray.class);
                Iterator<JsonElement> iterator = rootArray.iterator();
                while (iterator.hasNext()) {
                    JsonObject item = iterator.next().getAsJsonObject();
                    if (item.get(BookParams.ID).getAsInt() == id) {
                        return gson.fromJson(item, BookInfo.class);
                    }
                }
            }
            return null;
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

    @Override
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
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

}
