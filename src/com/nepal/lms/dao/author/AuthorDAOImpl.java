/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.dao.author;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.nepal.lms.entity.author.Author;
import com.nepal.lms.entity.author.AuthorParams;
import com.nepal.lms.util.JsonHelper;
import java.io.FileReader;
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
public class AuthorDAOImpl implements AuthorDAO {

    private static final String FILENAME = "Author.json";
    private final Gson gson;

    public AuthorDAOImpl() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public boolean isAuthorAvailable(Author author) {
        try {
            return findById(author.getId()) != null;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @SuppressWarnings("UseSpecificCatch")
    public int save(Author t) {
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
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @SuppressWarnings("UseSpecificCatch")
    public int update(Author t) {
        try {

            try (Reader reader = new FileReader(FILENAME)) {
                JsonArray rootArray = gson.fromJson(reader, JsonArray.class);
                Iterator<JsonElement> iterator = rootArray.iterator();
                boolean found = false;
                while (iterator.hasNext()) {
                    JsonObject item = iterator.next().getAsJsonObject();
                    if (item.get(AuthorParams.ID).getAsInt() == t.getId()) {

                        item.addProperty(AuthorParams.TITLE, t.getTitle());
                        item.addProperty(AuthorParams.CONTACT, t.getContact());

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
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @SuppressWarnings("UseSpecificCatch")
    public int remove(Author t) {
        try {

            try (Reader reader = new FileReader(FILENAME)) {
                JsonArray rootArray = gson.fromJson(reader, JsonArray.class);
                Iterator<JsonElement> iterator = rootArray.iterator();
                boolean found = false;
                while (iterator.hasNext()) {
                    JsonObject item = iterator.next().getAsJsonObject();
                    if (item.get(AuthorParams.ID).getAsInt() == t.getId()) {
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
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @SuppressWarnings("UseSpecificCatch")
    public Author findById(int id) {
        try {

            try (Reader reader = new FileReader(FILENAME)) {
                JsonArray rootArray = gson.fromJson(reader, JsonArray.class);
                Iterator<JsonElement> iterator = rootArray.iterator();
                while (iterator.hasNext()) {
                    JsonObject item = iterator.next().getAsJsonObject();
                    if (item.get(AuthorParams.ID).getAsInt() == id) {
                        return gson.fromJson(item, Author.class);
                    }
                }
            }
            return null;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @SuppressWarnings("UseSpecificCatch")
    public List<Author> findAll() {
        try {
            if (Files.notExists(Paths.get(FILENAME))) {
                return Collections.EMPTY_LIST;
            } else {
                try (Reader reader = new FileReader(FILENAME)) {
                    return gson.fromJson(reader, new TypeToken<List<Author>>() {
                    }.getType());
                }
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

}
