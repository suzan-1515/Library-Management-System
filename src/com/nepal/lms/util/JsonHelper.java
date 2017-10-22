/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 *
 * @author Suzn
 */
public class JsonHelper {

    public static void writeToFile(JsonElement element, String filename, Gson gson) throws IOException {
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(element, writer);
        }
    }

    public static void writeToFile(List<?> list, String filename, Gson gson) throws IOException {
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(list, writer);
        }
    }

}
