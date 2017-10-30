/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.action;

import com.nepal.lms.entity.returnn.Return;

/**
 *
 * @author Suzn
 */
public interface ReturnListener {

    void onReturnDataChanged(Return r);

    void onReturnDataRemoved(Return r);

}
