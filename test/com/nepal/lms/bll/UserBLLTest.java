/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.bll;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.nepal.lms.dao.user.UserDAO;
import com.nepal.lms.entity.user.User;
import com.nepal.lms.entity.user.UserInfo;
import com.nepal.lms.entity.user.UserParams;
import com.nepal.lms.exception.CorruptedDataException;
import com.nepal.lms.exception.DuplicateRecordException;
import com.nepal.lms.exception.MissingFileException;
import com.nepal.lms.exception.RecordNotFoundException;
import com.nepal.lms.util.Logy;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Suzn
 */
public class UserBLLTest {

    DummyUserBLL dummyUserBLL;

    @Before
    public void setUp() {
        dummyUserBLL = new DummyUserBLL();
    }

    /**
     * Test of insertUser method, of class UserBLL.
     */
    @Test
    public void testInsertUser() {
        System.out.println("insertUser initializing");
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);

        int expResult = userInfo.getId();
        int result;

        try {
            result = dummyUserBLL.insertUser(userInfo);
            assertEquals(expResult, result);
        } catch (DuplicateRecordException ex) {
            Logy.e(ex);
            assertTrue(ex.getMessage().contains("Record already exist!"));
        } catch (MissingFileException ex) {
            Logy.e(ex);
            assertTrue(ex.getMessage().contains("file is missing"));
        } catch (CorruptedDataException ex) {
            Logy.e(ex);
            assertTrue(ex.getMessage().contains("File data is corrupted"));
        }

    }

    /**
     * Test of updateUser method, of class UserBLL.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser initializing");
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        int expResult = userInfo.getId();
        int result;
        try {
            result = dummyUserBLL.updateUser(userInfo);
            assertEquals(expResult, result);
        } catch (RecordNotFoundException ex) {
            Logy.e(ex);
            assertTrue(ex.getMessage().contains("Record does not exist"));
        } catch (MissingFileException ex) {
            Logy.e(ex);
            assertTrue(ex.getMessage().contains("file is missing"));
        } catch (CorruptedDataException ex) {
            Logy.e(ex);
            assertTrue(ex.getMessage().contains("File data is corrupted"));
        }
    }

    /**
     * Test of deleteUser method, of class UserBLL.
     */
    @Test
    public void testDeleteUser() throws Exception {
        System.out.println("deleteUser");
        UserInfo userInfo = null;
        int expResult = 0;
        int result = UserBLL.deleteUser(userInfo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserById method, of class UserBLL.
     */
    @Test
    public void testGetUserById() throws Exception {
        System.out.println("getUserById");
        int id = 0;
        UserInfo expResult = null;
        UserInfo result = UserBLL.getUserById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllUser method, of class UserBLL.
     */
    @Test
    public void testGetAllUser() throws Exception {
        System.out.println("getAllUser");
        List<UserInfo> expResult = null;
        List<UserInfo> result = UserBLL.getAllUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isUserAvailable method, of class UserBLL.
     */
    @Test
    public void testIsUserAvailable() throws Exception {
        System.out.println("isUserAvailable");
        User user = null;
        boolean expResult = false;
        boolean result = UserBLL.isUserAvailable(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private class DummyUserDAO implements UserDAO {

        @Override
        public boolean isUserAvailable(User user) throws IOException, JsonIOException, JsonSyntaxException {
            Logy.d("User available check");
            return true;
        }

        @Override
        public int save(UserInfo t) throws IOException, JsonIOException, JsonSyntaxException {
            Logy.d("Saving user");
            return t.getId();
        }

        @Override
        public int append(UserInfo t) throws IOException, JsonIOException, JsonSyntaxException {
            Logy.d("Appending user");
            return t.getId();
        }

        @Override
        public int update(UserInfo t) throws IOException, JsonIOException, JsonSyntaxException {
            Logy.d("Updating user");
            return t.getId();
        }

        @Override
        public int remove(UserInfo t) throws IOException, JsonIOException, JsonSyntaxException {
            Logy.d("Removing user");
            return t.getId();
        }

        @Override
        public UserInfo findById(int id) throws IOException, JsonIOException, JsonSyntaxException {
            Logy.d("searching user by id");
            return new UserInfo();
        }

        @Override
        public List<UserInfo> findAll() throws IOException, JsonIOException, JsonSyntaxException {
            Logy.d("Fetching all user data");
            return Arrays.asList(new UserInfo());
        }

        @Override
        public UserInfo loginUser(User user) throws IOException, JsonIOException, JsonSyntaxException {
            Logy.d("Authenticating user");
            return new UserInfo();
        }

    }

    private class DummyUserBLL {

        public int insertUser(UserInfo userInfo) throws DuplicateRecordException, MissingFileException, CorruptedDataException {
            UserDAO userDAO = new DummyUserDAO();
            try {
                int response = -1;
                if (true) {
                    Logy.d("UserInfo file exist");
                    if (userDAO.isUserAvailable(userInfo)) {
                        throw new DuplicateRecordException();
                    }

                    response = userDAO.append(userInfo);
                } else {
                    Logy.d("UserInfo file does not exist");
                    response = userDAO.save(userInfo);
                }
                return response;
            } catch (JsonSyntaxException e) {
                throw new CorruptedDataException(e);
            } catch (JsonIOException | IOException e) {
                throw new MissingFileException(UserParams.FILENAME, e);
            }
        }

        public int updateUser(UserInfo userInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
            UserDAO userDAO = new DummyUserDAO();
            try {
                if (false) {
                    throw new MissingFileException(UserParams.FILENAME);
                }
                if (!userDAO.isUserAvailable(userInfo)) {
                    throw new RecordNotFoundException();
                }

                return userDAO.update(userInfo);

            } catch (JsonSyntaxException e) {
                throw new CorruptedDataException(e);
            } catch (JsonIOException | IOException e) {
                throw new MissingFileException(UserParams.FILENAME, e);
            }
        }

        public int deleteUser(UserInfo userInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
            UserDAO userDAO = new DummyUserDAO();
            try {
                if (false) {
                    throw new MissingFileException(UserParams.FILENAME);
                }
                if (!userDAO.isUserAvailable(userInfo)) {
                    throw new RecordNotFoundException();
                }

                return userDAO.remove(userInfo);

            } catch (JsonSyntaxException e) {
                throw new CorruptedDataException(e);
            } catch (JsonIOException | IOException e) {
                throw new MissingFileException(UserParams.FILENAME, e);
            }
        }

        public UserInfo getUserById(int id) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
            UserDAO userDAO = new DummyUserDAO();
            try {
                if (false) {
                    throw new MissingFileException(UserParams.FILENAME);
                }

                return userDAO.findById(id);

            } catch (JsonSyntaxException e) {
                throw new CorruptedDataException(e);
            } catch (JsonIOException | IOException e) {
                throw new MissingFileException(UserParams.FILENAME, e);
            }
        }

        public List<UserInfo> getAllUser() throws RecordNotFoundException, MissingFileException, CorruptedDataException {
            UserDAO userDAO = new DummyUserDAO();
            try {
                if (false) {
                    throw new MissingFileException(UserParams.FILENAME);
                }

                return userDAO.findAll();

            } catch (JsonSyntaxException e) {
                throw new CorruptedDataException(e);
            } catch (JsonIOException | IOException e) {
                throw new MissingFileException(UserParams.FILENAME, e);
            }
        }

        public boolean isUserAvailable(User user) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
            return getUserById(user.getId()) != null;
        }
    }

}
