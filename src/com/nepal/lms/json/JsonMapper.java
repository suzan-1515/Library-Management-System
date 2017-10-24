/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Suzn
 */
public class JsonMapper {

    private final Gson gson;

    private JsonMapper() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public synchronized static JsonMapper getInstance() {
        return GsonHolder.INSTANCE;
    }

    private static class GsonHolder {

        private static final JsonMapper INSTANCE = new JsonMapper();
    }

    /**
     * @return the gson
     */
    public Gson getGson() {
        return gson;
    }
}
