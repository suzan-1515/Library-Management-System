/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.bll;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.nepal.lms.dao.member.MemberDAO;
import com.nepal.lms.dao.member.MemberDAOImpl;
import com.nepal.lms.entity.member.Member;
import com.nepal.lms.entity.member.MemberInfo;
import com.nepal.lms.entity.member.MemberParams;
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
public class MemberBLL {

    public static int insertMember(MemberInfo memberInfo) throws DuplicateRecordException, MissingFileException, CorruptedDataException {
        MemberDAO memberDAO = new MemberDAOImpl(JsonMapper.getInstance().getGson(), MemberParams.FILENAME);
        try {
            int response = -1;
            if (FileUtils.exists(MemberParams.FILENAME)) {

                if (memberDAO.isMemberAvailable(memberInfo)) {
                    throw new DuplicateRecordException();
                }

                response = memberDAO.append(memberInfo);
            } else {
                response = memberDAO.save(memberInfo);
            }
            return response;
        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(MemberParams.FILENAME, e);
        }
    }

    public static int updateMember(MemberInfo memberInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        MemberDAO memberDAO = new MemberDAOImpl(JsonMapper.getInstance().getGson(), MemberParams.FILENAME);
        try {
            if (FileUtils.notExist(MemberParams.FILENAME)) {
                throw new MissingFileException(MemberParams.FILENAME);
            }
            if (!memberDAO.isMemberAvailable(memberInfo)) {
                throw new RecordNotFoundException();
            }

            return memberDAO.update(memberInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(MemberParams.FILENAME, e);
        }
    }

    public static int deleteMember(MemberInfo memberInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        MemberDAO memberDAO = new MemberDAOImpl(JsonMapper.getInstance().getGson(), MemberParams.FILENAME);
        try {
            if (FileUtils.notExist(MemberParams.FILENAME)) {
                throw new MissingFileException(MemberParams.FILENAME);
            }
            if (!memberDAO.isMemberAvailable(memberInfo)) {
                throw new RecordNotFoundException();
            }

            return memberDAO.remove(memberInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(MemberParams.FILENAME, e);
        }
    }

    public static MemberInfo getMemberById(int id) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        MemberDAO memberDAO = new MemberDAOImpl(JsonMapper.getInstance().getGson(), MemberParams.FILENAME);
        try {
            if (FileUtils.notExist(MemberParams.FILENAME)) {
                throw new MissingFileException(MemberParams.FILENAME);
            }

            return memberDAO.findById(id);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(MemberParams.FILENAME, e);
        }
    }

    public static List<MemberInfo> getAllMember() throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        MemberDAO memberDAO = new MemberDAOImpl(JsonMapper.getInstance().getGson(), MemberParams.FILENAME);
        try {
            if (FileUtils.notExist(MemberParams.FILENAME)) {
                throw new MissingFileException(MemberParams.FILENAME);
            }

            return memberDAO.findAll();

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(MemberParams.FILENAME, e);
        }
    }

    public static boolean isMemberAvailable(Member member) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        return getMemberById(member.getId()) != null;
    }

}
