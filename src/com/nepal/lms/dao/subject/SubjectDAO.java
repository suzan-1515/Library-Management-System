/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.dao.subject;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.nepal.lms.dao.DAO;
import com.nepal.lms.entity.subject.Subject;
import java.io.IOException;

/**
 *
 * @author Suzn
 */
public interface SubjectDAO extends DAO<Subject> {

    boolean isSubjectAvailable(Subject book) throws IOException, JsonIOException, JsonSyntaxException;

}
