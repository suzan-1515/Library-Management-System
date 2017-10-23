/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.book;

import com.nepal.lms.dao.subject.SubjectDAO;
import com.nepal.lms.dao.subject.SubjectDAOImpl;
import com.nepal.lms.entity.subject.Subject;
import java.io.FileNotFoundException;
import java.util.List;
import javax.management.RuntimeErrorException;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.Matchers;
import org.junit.Assert;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Suzn
 */
public class SubjectTest {

    static SubjectDAO subjectDAO;

    @BeforeClass
    public static void setup() {
        subjectDAO = new SubjectDAOImpl();
    }

    @Test
    public void insertSubjectTestCase() {
        Subject subject = new Subject(3, "Economics");
        Assert.assertEquals(subject.getId(), subjectDAO.save(subject));
    }

    @Test
    public void updateSubjectTestCase() {
        Subject subject = new Subject(2, "Python");
        Assert.assertEquals(subject.getId(), subjectDAO.update(subject));
    }

    @Test
    public void updateSubjectWithInvalidIdTestCase() {
        Subject subject = new Subject(4, "Python");
        Assert.assertEquals(-1, subjectDAO.update(subject));
    }

    @Test
    public void updateSubjectWithInvalidFileTestCase() {
        try{
        Subject subject = new Subject(4, "Python");
        subjectDAO.update(subject);
        fail("Expected an FileNotFoundException to be thrown");
        }catch(Exception e){
            assertThat(e.getMessage(), Matchers.containsString("FileNotFound"));
        }

    }

    @Test
    public void deleteSubjectTestCase() {
        Subject subject = new Subject(3, "");
        Assert.assertEquals(subject.getId(), subjectDAO.remove(subject));
    }

    @Test
    public void deleteSubjectWithInvalidIdTestCase() {
        Subject subject = new Subject(4, "");
        Assert.assertEquals(-1, subjectDAO.remove(subject));
    }

    @Test
    public void viewSubjectsTestCase() {
        List<Subject> subjects = subjectDAO.findAll();
        Assert.assertFalse(subjects.isEmpty());
        subjects.stream().forEach((subject) -> System.out.println(subject.getTitle()));
    }

    @Test
    public void viewSubjectsWithInvalidFileTestCase() {
        List<Subject> subjects = subjectDAO.findAll();
        Assert.assertTrue(subjects.isEmpty());
    }

}
