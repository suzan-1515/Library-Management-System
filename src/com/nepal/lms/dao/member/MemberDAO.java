/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.dao.member;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.nepal.lms.dao.DAO;
import com.nepal.lms.entity.member.Member;
import com.nepal.lms.entity.member.MemberInfo;
import java.io.IOException;

/**
 *
 * @author Suzn
 */
public interface MemberDAO extends DAO<MemberInfo> {

    boolean isMemberAvailable(Member member) throws IOException, JsonIOException, JsonSyntaxException;

}
