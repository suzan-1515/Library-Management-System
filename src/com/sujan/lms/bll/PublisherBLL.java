/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.bll;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.sujan.lms.dao.publisher.PublisherDAO;
import com.sujan.lms.dao.publisher.PublisherDAOImpl;
import com.sujan.lms.entity.publisher.Publisher;
import com.sujan.lms.entity.publisher.PublisherParams;
import com.sujan.lms.exception.CorruptedDataException;
import com.sujan.lms.exception.DuplicateRecordException;
import com.sujan.lms.exception.MissingFileException;
import com.sujan.lms.exception.RecordNotFoundException;
import com.sujan.lms.json.JsonMapper;
import com.sujan.lms.util.FileUtils;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Suzn
 */
public class PublisherBLL {

    public static int insertPublisher(Publisher publisherInfo) throws DuplicateRecordException, MissingFileException, CorruptedDataException {
        PublisherDAO publisherDAO = new PublisherDAOImpl(JsonMapper.getInstance().getGson(), PublisherParams.FILENAME);
        try {
            int response = -1;
            if (FileUtils.exists(PublisherParams.FILENAME)) {

                if (publisherDAO.isPublisherAvailable(publisherInfo)) {
                    throw new DuplicateRecordException();
                }

                response = publisherDAO.append(publisherInfo);
            } else {
                response = publisherDAO.save(publisherInfo);
            }
            return response;
        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(PublisherParams.FILENAME, e);
        }
    }

    public static int updatePublisher(Publisher publisherInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        PublisherDAO publisherDAO = new PublisherDAOImpl(JsonMapper.getInstance().getGson(), PublisherParams.FILENAME);
        try {
            if (FileUtils.notExist(PublisherParams.FILENAME)) {
                throw new MissingFileException(PublisherParams.FILENAME);
            }
            if (!publisherDAO.isPublisherAvailable(publisherInfo)) {
                throw new RecordNotFoundException();
            }

            return publisherDAO.update(publisherInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(PublisherParams.FILENAME, e);
        }
    }

    public static int deletePublisher(Publisher publisherInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        PublisherDAO publisherDAO = new PublisherDAOImpl(JsonMapper.getInstance().getGson(), PublisherParams.FILENAME);
        try {
            if (FileUtils.notExist(PublisherParams.FILENAME)) {
                throw new MissingFileException(PublisherParams.FILENAME);
            }
            if (!publisherDAO.isPublisherAvailable(publisherInfo)) {
                throw new RecordNotFoundException();
            }

            return publisherDAO.remove(publisherInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(PublisherParams.FILENAME, e);
        }
    }

    public static Publisher getPublisherById(int id) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        PublisherDAO publisherDAO = new PublisherDAOImpl(JsonMapper.getInstance().getGson(), PublisherParams.FILENAME);
        try {
            if (FileUtils.notExist(PublisherParams.FILENAME)) {
                throw new MissingFileException(PublisherParams.FILENAME);
            }

            return publisherDAO.findById(id);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(PublisherParams.FILENAME, e);
        }
    }

    public static List<Publisher> getAllPublisher() throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        PublisherDAO publisherDAO = new PublisherDAOImpl(JsonMapper.getInstance().getGson(), PublisherParams.FILENAME);
        try {
            if (FileUtils.notExist(PublisherParams.FILENAME)) {
                throw new MissingFileException(PublisherParams.FILENAME);
            }

            return publisherDAO.findAll();

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(PublisherParams.FILENAME, e);
        }
    }

    public static boolean isPublisherAvailable(Publisher publisher) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        return getPublisherById(publisher.getId()) != null;
    }

}
