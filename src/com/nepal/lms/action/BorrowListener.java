/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.action;

import com.nepal.lms.entity.borrow.Borrow;

/**
 *
 * @author Suzn
 */
public interface BorrowListener {

    void onBorrowDataChanged(Borrow b);

    void onBorrowDataRemoved(Borrow b);

}
