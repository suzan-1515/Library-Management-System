/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.dao.author;

import com.nepal.lms.dao.DAO;
import com.nepal.lms.entity.author.Author;

/**
 *
 * @author Suzn
 */
public interface AuthorDAO extends DAO<Author> {

    boolean isAuthorAvailable(Author author);

}
