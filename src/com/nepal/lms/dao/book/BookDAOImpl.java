/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.dao.book;

import com.google.gson.Gson;
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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Suzn
 */
public class BookDAOImpl implements BookDAO {

    private final String filename;
    private final Gson gson;

    /**
     *
     * @param gson
     * @param filename
     */
    public BookDAOImpl(Gson gson, String filename) {
        this.gson = gson;
        this.filename = filename;
    }

    /**
     *
     * @param book
     * @return boolean
     * @throws IOException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public boolean isBookAvailable(Book book) throws IOException, JsonIOException, JsonSyntaxException {
        return findById(book.getId()) != null;

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
    public int save(BookInfo t) throws IOException, JsonIOException, JsonSyntaxException {

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
    public int append(BookInfo t) throws IOException, JsonIOException, JsonSyntaxException {
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
    public int update(BookInfo t) throws IOException, JsonIOException, JsonSyntaxException {

        try (Reader reader = new FileReader(filename)) {
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
    public int remove(BookInfo t) throws IOException, JsonIOException, JsonSyntaxException {

        try (Reader reader = new FileReader(filename)) {
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
                JsonHelper.writeToFile(rootArray, filename, gson);
                return t.getId();
            }

        }

        return -1;
    }

    /**
     *
     * @param id
     * @return BoookInfo
     * @throws IOException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public BookInfo findById(int id) throws IOException, JsonIOException, JsonSyntaxException {

        try (Reader reader = new FileReader(filename)) {
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
    }

    /**
     *
     * @return @throws IOException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    @Override
    public List<BookInfo> findAll() throws IOException, JsonIOException, JsonSyntaxException {

        try (Reader reader = new FileReader(filename)) {
            return gson.fromJson(reader, new TypeToken<List<BookInfo>>() {
            }.getType());
        }

    }

}
