/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.view;

import com.sujan.lms.entity.member.MemberInfo;

/**
 *
 * @author Suzn
 */
public interface MemberView extends View<MemberInfo> {

    void onMemberRowDataAdd(MemberInfo m);

    void onMemberDataRemove(MemberInfo m);

}
