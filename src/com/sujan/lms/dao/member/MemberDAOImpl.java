/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.dao.member;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sujan.lms.entity.member.Member;
import com.sujan.lms.entity.member.MemberInfo;
import com.sujan.lms.entity.member.MemberParams;
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
public class MemberDAOImpl implements MemberDAO {

    private final String filename;
    private final Gson gson;

    /**
     *
     * @param gson
     * @param filename
     */
    public MemberDAOImpl(Gson gson, String filename) {
        this.gson = gson;
        this.filename = filename;
    }

    /**
     *
     * @param member
     * @return
     * @throws IOException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public boolean isMemberAvailable(Member member) throws IOException, JsonIOException, JsonSyntaxException {
        return findById(member.getId()) != null;
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
    public int save(MemberInfo t) throws IOException, JsonIOException, JsonSyntaxException {

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
    public int append(MemberInfo t) throws IOException, JsonIOException, JsonSyntaxException {
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
    public int update(MemberInfo t) throws IOException, JsonIOException, JsonSyntaxException {

        try (Reader reader = new FileReader(filename)) {
            JsonArray rootArray = gson.fromJson(reader, JsonArray.class);
            Iterator<JsonElement> iterator = rootArray.iterator();
            boolean found = false;
            while (iterator.hasNext()) {
                JsonObject item = iterator.next().getAsJsonObject();
                if (item.get(MemberParams.ID).getAsInt() == t.getId()) {

                    item.addProperty(MemberParams.NAME, t.getName());
                    item.add(MemberParams.ADDRESS, gson.toJsonTree(t.getAddress()));
                    item.addProperty(MemberParams.CONTACT, t.getContact());
                    item.addProperty(MemberParams.EXPIRY_DATE, t.getExpiryDate());

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
    public int remove(MemberInfo t) throws IOException, JsonIOException, JsonSyntaxException {

        try (Reader reader = new FileReader(filename)) {
            JsonArray rootArray = gson.fromJson(reader, JsonArray.class);
            Iterator<JsonElement> iterator = rootArray.iterator();
            boolean found = false;
            while (iterator.hasNext()) {
                JsonObject item = iterator.next().getAsJsonObject();
                if (item.get(MemberParams.ID).getAsInt() == t.getId()) {
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
     * @return MemberInfo
     * @throws IOException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public MemberInfo findById(int id) throws IOException, JsonIOException, JsonSyntaxException {

        try (Reader reader = new FileReader(filename)) {
            JsonArray rootArray = gson.fromJson(reader, JsonArray.class);
            Iterator<JsonElement> iterator = rootArray.iterator();
            while (iterator.hasNext()) {
                JsonObject item = iterator.next().getAsJsonObject();
                if (item.get(MemberParams.ID).getAsInt() == id) {
                    return gson.fromJson(item, MemberInfo.class);
                }
            }
        }

        return null;
    }

    /**
     *
     * @return @throws IOException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public List<MemberInfo> findAll() throws IOException, JsonIOException, JsonSyntaxException {

        try (Reader reader = new FileReader(filename)) {
            return gson.fromJson(reader, new TypeToken<List<MemberInfo>>() {
            }.getType());
        }

    }

}
