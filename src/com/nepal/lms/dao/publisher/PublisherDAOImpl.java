/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.dao.publisher;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.nepal.lms.entity.publisher.Publisher;
import com.nepal.lms.entity.publisher.PublisherParams;
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
public class PublisherDAOImpl implements PublisherDAO {

    private static final String FILENAME = "Publisher.json";
    private final Gson gson;

    public PublisherDAOImpl() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public boolean isPublisherAvailable(Publisher subject) {
        try {
            return findById(subject.getId()) != null;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @SuppressWarnings("UseSpecificCatch")
    public int save(Publisher t) {
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
    public int update(Publisher t) {
        try {

            try (Reader reader = new FileReader(FILENAME)) {
                JsonArray rootArray = gson.fromJson(reader, JsonArray.class);
                Iterator<JsonElement> iterator = rootArray.iterator();
                boolean found = false;
                while (iterator.hasNext()) {
                    JsonObject item = iterator.next().getAsJsonObject();
                    if (item.get(PublisherParams.ID).getAsInt() == t.getId()) {

                        item.addProperty(PublisherParams.TITLE, t.getTitle());
                        item.addProperty(PublisherParams.CONTACT, t.getContact());

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
    public int remove(Publisher t) {
        try {

            try (Reader reader = new FileReader(FILENAME)) {
                JsonArray rootArray = gson.fromJson(reader, JsonArray.class);
                Iterator<JsonElement> iterator = rootArray.iterator();
                boolean found = false;
                while (iterator.hasNext()) {
                    JsonObject item = iterator.next().getAsJsonObject();
                    if (item.get(PublisherParams.ID).getAsInt() == t.getId()) {
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
    public Publisher findById(int id) {
        try {

            try (Reader reader = new FileReader(FILENAME)) {
                JsonArray rootArray = gson.fromJson(reader, JsonArray.class);
                Iterator<JsonElement> iterator = rootArray.iterator();
                while (iterator.hasNext()) {
                    JsonObject item = iterator.next().getAsJsonObject();
                    if (item.get(PublisherParams.ID).getAsInt() == id) {
                        return gson.fromJson(item, Publisher.class);
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
    public List<Publisher> findAll() {
        try {
            if (Files.notExists(Paths.get(FILENAME))) {
                return Collections.EMPTY_LIST;
            } else {
                try (Reader reader = new FileReader(FILENAME)) {
                    return gson.fromJson(reader, new TypeToken<List<Publisher>>() {
                    }.getType());
                }
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
    }

}
