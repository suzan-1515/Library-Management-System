/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.action;

import com.sujan.lms.entity.subject.Subject;

/**
 *
 * @author Suzn
 */
public interface SubjectListener {

    void onSubjectDataChanged(Subject s);

    void onSubectDataRemoved(Subject s);

}
