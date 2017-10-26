/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.bll;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.nepal.lms.dao.publisher.PublisherDAO;
import com.nepal.lms.dao.publisher.PublisherDAOImpl;
import com.nepal.lms.entity.publisher.Publisher;
import com.nepal.lms.entity.publisher.PublisherParams;
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
