/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.entity.book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Suzn
 */
public class BookBean implements Serializable {

    private final List<BookInfo> data;

    public BookBean(BookInfo bookInfo) {
        this.data = new ArrayList<>();
        this.data.add(bookInfo);
    }

}
