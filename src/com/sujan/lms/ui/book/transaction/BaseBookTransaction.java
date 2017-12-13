/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.ui.book.transaction;

import com.sujan.lms.bll.BookBLL;
import com.sujan.lms.bll.MemberBLL;
import com.sujan.lms.custom.Alert;
import com.sujan.lms.entity.book.BookInfo;
import com.sujan.lms.entity.member.MemberInfo;
import com.sujan.lms.exception.CorruptedDataException;
import com.sujan.lms.exception.MissingFileException;
import com.sujan.lms.exception.RecordNotFoundException;
import com.sujan.lms.util.Logy;
import java.awt.Frame;
import java.util.Calendar;

/**
 *
 * @author Suzn
 */
public abstract class BaseBookTransaction extends javax.swing.JDialog {

    public BaseBookTransaction(Frame frame, boolean bln) {
        super(frame, bln);
    }

    protected BookInfo getBook(String bookId) {
        try {
            return BookBLL.getBookById(Integer.parseInt(bookId));
        } catch (RecordNotFoundException | MissingFileException | CorruptedDataException ex) {
            Logy.e(ex);
            Alert.showError(this, ex.getMessage());
        }

        return null;
    }

    protected MemberInfo getMember(String memberId) {
        try {
            return MemberBLL.getMemberById(Integer.parseInt(memberId));
        } catch (RecordNotFoundException | MissingFileException | CorruptedDataException ex) {
            Logy.e(ex);
            Alert.showError(this, ex.getMessage());
        }

        return null;
    }

    protected int getDays(Calendar expiryDate) {
        return (int) ((expiryDate.getTime().getTime() - Calendar.getInstance().getTime().getTime())
                / (1000 * 60 * 60 * 24));
    }

}
