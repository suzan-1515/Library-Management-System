/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.bll;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.sujan.lms.dao.member.MemberDAO;
import com.sujan.lms.dao.member.MemberDAOImpl;
import com.sujan.lms.entity.member.Member;
import com.sujan.lms.entity.member.MemberInfo;
import com.sujan.lms.entity.member.MemberParams;
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
public class MemberBLL {

    public static int insertMember(MemberInfo memberInfo) throws DuplicateRecordException, MissingFileException, CorruptedDataException {
        MemberDAO memberManager = new MemberDAOImpl(JsonMapper.getInstance().getGson(), MemberParams.FILENAME);
        try {
            int response = -1;
            if (FileUtils.exists(MemberParams.FILENAME)) {

                if (memberManager.isMemberAvailable(memberInfo)) {
                    throw new DuplicateRecordException();
                }

                response = memberManager.append(memberInfo);
            } else {
                response = memberManager.save(memberInfo);
            }
            return response;
        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(MemberParams.FILENAME, e);
        }
    }

    public static int updateMember(MemberInfo memberInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        MemberDAO memberManager = new MemberDAOImpl(JsonMapper.getInstance().getGson(), MemberParams.FILENAME);
        try {
            if (FileUtils.notExist(MemberParams.FILENAME)) {
                throw new MissingFileException(MemberParams.FILENAME);
            }
            if (!memberManager.isMemberAvailable(memberInfo)) {
                throw new RecordNotFoundException();
            }

            return memberManager.update(memberInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(MemberParams.FILENAME, e);
        }
    }

    public static int deleteMember(MemberInfo memberInfo) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        MemberDAO memberManager = new MemberDAOImpl(JsonMapper.getInstance().getGson(), MemberParams.FILENAME);
        try {
            if (FileUtils.notExist(MemberParams.FILENAME)) {
                throw new MissingFileException(MemberParams.FILENAME);
            }
            if (!memberManager.isMemberAvailable(memberInfo)) {
                throw new RecordNotFoundException();
            }

            return memberManager.remove(memberInfo);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(MemberParams.FILENAME, e);
        }
    }

    public static MemberInfo getMemberById(int id) throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        MemberDAO memberManager = new MemberDAOImpl(JsonMapper.getInstance().getGson(), MemberParams.FILENAME);
        try {
            if (FileUtils.notExist(MemberParams.FILENAME)) {
                throw new MissingFileException(MemberParams.FILENAME);
            }

            return memberManager.findById(id);

        } catch (JsonSyntaxException e) {
            throw new CorruptedDataException(e);
        } catch (JsonIOException | IOException e) {
            throw new MissingFileException(MemberParams.FILENAME, e);
        }
    }

    public static List<MemberInfo> getAllMember() throws RecordNotFoundException, MissingFileException, CorruptedDataException {
        MemberDAO memberManager = new MemberDAOImpl(JsonMapper.getInstance().getGson(), MemberParams.FILENAME);
        try {
            if (FileUtils.notExist(MemberParams.FILENAME)) {
                throw new MissingFileException(MemberParams.FILENAME);
            }

            return memberManager.findAll();

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
