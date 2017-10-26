/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.bll;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.nepal.lms.dao.subject.SubjectDAO;
import com.nepal.lms.dao.subject.SubjectDAOImpl;
import com.nepal.lms.entity.subject.Subject;
import com.nepal.lms.entity.subject.SubjectParams;
import com.nepal.lms.exception.CorruptedDataException;
import com.nepal.lms.exception.DuplicateRecordException;
import com.nepal.lms.exception.MissingFileException;
import com.nepal.lms.exception.RecordNotFoundException;
import com.nepal.lms.json.JsonMapper;
import com.nepal.lms.util.FileUtils;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Suzn
 */
public class SubjectBLL {

    public static int insertSubject(Subject subjectInfo) throws DuplicateRecordException, MissingFileException, CorruptedDataException {
        SubjectDAO subjectDAO = new SubjectDAOImpl(JsonMapper.getInstance().getGson(), SubjectParams.FILENAME);
        try {
            int response = -1;
            if (FileUtils.exists(SubjectParams.FILENAME)) {

                if (subjectDAO.isSubjectAvailable(subjectInfo)) {
                    throw new DuplicateRecordException();
                }

                response = subjectDAO.append(subjectInfo);
            } else {
                response = subjectDAO.save(subjectInfo);
            }
            return response;
        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(SubjectParams.FILENAME, e);
        }
    }

    public static int updateSubject(Subject subjectInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        SubjectDAO subjectDAO = new SubjectDAOImpl(JsonMapper.getInstance().getGson(), SubjectParams.FILENAME);
        try {
            if (FileUtils.notExist(SubjectParams.FILENAME)) {
                throw new MissingFileException(SubjectParams.FILENAME);
            }
            if (!subjectDAO.isSubjectAvailable(subjectInfo)) {
                throw new RecordNotFoundException();
            }

            return subjectDAO.update(subjectInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(SubjectParams.FILENAME, e);
        }
    }

    public static int deleteSubject(Subject subjectInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        SubjectDAO subjectDAO = new SubjectDAOImpl(JsonMapper.getInstance().getGson(), SubjectParams.FILENAME);
        try {
            if (FileUtils.notExist(SubjectParams.FILENAME)) {
                throw new MissingFileException(SubjectParams.FILENAME);
            }
            if (!subjectDAO.isSubjectAvailable(subjectInfo)) {
                throw new RecordNotFoundException();
            }

            return subjectDAO.remove(subjectInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(SubjectParams.FILENAME, e);
        }
    }

    public static Subject getSubjectById(int id) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        SubjectDAO subjectDAO = new SubjectDAOImpl(JsonMapper.getInstance().getGson(), SubjectParams.FILENAME);
        try {
            if (FileUtils.notExist(SubjectParams.FILENAME)) {
                throw new MissingFileException(SubjectParams.FILENAME);
            }

            return subjectDAO.findById(id);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(SubjectParams.FILENAME, e);
        }
    }

    public static List<Subject> getAllSubject() throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        SubjectDAO subjectDAO = new SubjectDAOImpl(JsonMapper.getInstance().getGson(), SubjectParams.FILENAME);
        try {
            if (FileUtils.notExist(SubjectParams.FILENAME)) {
                throw new MissingFileException(SubjectParams.FILENAME);
            }

            return subjectDAO.findAll();

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(SubjectParams.FILENAME, e);
        }
    }

    public static boolean isSubjectAvailable(Subject subject) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        return getSubjectById(subject.getId()) != null;
    }

}
