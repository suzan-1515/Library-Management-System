/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.dao.user;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.nepal.lms.entity.user.User;
import com.nepal.lms.entity.user.UserInfo;
import com.nepal.lms.entity.user.UserParams;
import com.nepal.lms.util.JsonHelper;
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
public class UserDAOImpl implements UserDAO {

    private final String filename;
    private final Gson gson;

    /**
     *
     * @param gson
     * @param filename
     */
    public UserDAOImpl(Gson gson, String filename) {
        this.gson = gson;
        this.filename = filename;
    }

    /**
     *
     * @param user
     * @return boolean
     * @throws java.io.IOException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public boolean isUserAvailable(User user) throws IOException, JsonIOException, JsonSyntaxException {
        return findById(user.getId()) != null;
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
    public int save(UserInfo t) throws IOException, JsonIOException, JsonSyntaxException {

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
    public int append(UserInfo t) throws IOException, JsonIOException, JsonSyntaxException {

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
     * @return Integer
     * @throws IOException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public int update(UserInfo t) throws IOException, JsonIOException, JsonSyntaxException {

        try (Reader reader = new FileReader(filename)) {
            JsonArray rootArray = gson.fromJson(reader, JsonArray.class
            );
            Iterator<JsonElement> iterator = rootArray.iterator();
            boolean found = false;
            while (iterator.hasNext()) {
                JsonObject item = iterator.next().getAsJsonObject();
                if (item.get(UserParams.ID).getAsInt() == t.getId()) {

                    item.addProperty(UserParams.NAME, t.getName());
                    item.addProperty(UserParams.USERNAME, t.getUsername());
                    item.addProperty(UserParams.PASSWORD, t.getPassword());
                    item.add(UserParams.ROLE, gson.toJsonTree(t.getRole()));

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
     * @return Integer
     * @throws IOException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public int remove(UserInfo t) throws IOException, JsonIOException, JsonSyntaxException {

        try (Reader reader = new FileReader(filename)) {
            JsonArray rootArray = gson.fromJson(reader, JsonArray.class
            );
            Iterator<JsonElement> iterator = rootArray.iterator();
            boolean found = false;
            while (iterator.hasNext()) {
                JsonObject item = iterator.next().getAsJsonObject();
                if (item.get(UserParams.ID).getAsInt() == t.getId()) {
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
     * @return UserInfo
     * @throws IOException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public UserInfo findById(int id) throws IOException, JsonIOException, JsonSyntaxException {

        try (Reader reader = new FileReader(filename)) {
            JsonArray rootArray = gson.fromJson(reader, JsonArray.class
            );
            Iterator<JsonElement> iterator = rootArray.iterator();
            while (iterator.hasNext()) {
                JsonObject item = iterator.next().getAsJsonObject();

                if (item.get(UserParams.ID).getAsInt() == id) {
                    return gson.fromJson(item, UserInfo.class
                    );
                }
            }
        }
        return null;
    }

    /**
     *
     * @return List<UserInfo>
     * @throws IOException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public List<UserInfo> findAll() throws IOException, JsonIOException, JsonSyntaxException {
        try (Reader reader = new FileReader(filename)) {
            return gson.fromJson(reader, new TypeToken<List<UserInfo>>() {
            }.getType());
        }
    }

    /**
     *
     * @param user
     * @return UserInfo
     * @throws IOException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public UserInfo loginUser(User user) throws IOException, JsonIOException, JsonSyntaxException {
        try (Reader reader = new FileReader(filename)) {
            JsonArray rootArray = gson.fromJson(reader, JsonArray.class
            );
            Iterator<JsonElement> iterator = rootArray.iterator();
            while (iterator.hasNext()) {
                JsonObject item = iterator.next().getAsJsonObject();

                if (item.get(UserParams.USERNAME).getAsString().equals(user.getUsername())
                        && item.get(UserParams.PASSWORD).getAsString().equals(user.getPassword())) {
                    return gson.fromJson(item, UserInfo.class
                    );
                }
            }
        }
        
        return null;
    }

}
