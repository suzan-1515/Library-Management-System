/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.dao.transaction;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.sujan.lms.dao.DAO;
import com.sujan.lms.entity.transaction.Transaction;
import java.io.IOException;

/**
 *
 * @author Suzn
 */
public interface TransactionDAO extends DAO<Transaction> {

    boolean isTransactionAvailable(Transaction transaction) throws IOException, JsonIOException, JsonSyntaxException;

}
