/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.dao.author;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sujan.lms.entity.author.Author;
import com.sujan.lms.entity.author.AuthorParams;
import com.sujan.lms.util.JsonHelper;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Suzn
 */
public class AuthorDAOImpl implements AuthorDAO {

    private final String filename;
    private final Gson gson;

    /**
     *
     * @param gson
     * @param filename
     */
    public AuthorDAOImpl(Gson gson, String filename) {
        this.gson = gson;
        this.filename = filename;
    }

    /**
     *
     * @param author
     * @return boolean
     * @throws IOException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public boolean isAuthorAvailable(Author author) throws IOException, JsonIOException, JsonSyntaxException {
        return findById(author.getId()) != null;
    }

    /**
     *
     * @param t
     * @return Integer
     * @throws IOException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public int save(Author t) throws IOException, JsonIOException, JsonSyntaxException {
        JsonHelper.writeToFile(Arrays.asList(t), filename, gson);
        return t.getId();
    }

    /**
     *
     * @param t
     * @return Integer
     * @throws IOException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public int append(Author t) throws IOException, JsonIOException, JsonSyntaxException {

        try (Reader reader = new FileReader(filename)) {
            JsonArray rootArray = gson.fromJson(reader, JsonArray.class);
            JsonObject newData = new JsonParser().parse(gson.toJson(t)).getAsJsonObject();

            rootArray.add(newData);

            JsonHelper.writeToFile(rootArray, filename, gson);

        }

        return t.getId();
    }

    /**
     *
     * @param t
     * @return
     * @throws IOException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public int update(Author t) throws IOException, JsonIOException, JsonSyntaxException {

        try (Reader reader = new FileReader(filename)) {
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
                JsonHelper.writeToFile(rootArray, filename, gson);
                return t.getId();
            }

        }
        return -1;
    }

    /**
     *
     * @param t
     * @return
     * @throws IOException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public int remove(Author t) throws IOException, JsonIOException, JsonSyntaxException {

        try (Reader reader = new FileReader(filename)) {
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
                JsonHelper.writeToFile(rootArray, filename, gson);
                return t.getId();
            }

        }
        return -1;

    }

    /**
     *
     * @param id
     * @return Author
     * @throws IOException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public Author findById(int id) throws IOException, JsonIOException, JsonSyntaxException {

        try (Reader reader = new FileReader(filename)) {
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
    }

    /**
     *
     * @return
     * @throws IOException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public List<Author> findAll() throws IOException, JsonIOException, JsonSyntaxException {

        try (Reader reader = new FileReader(filename)) {
            return gson.fromJson(reader, new TypeToken<List<Author>>() {
            }.getType());
        }

    }

}
