/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.util;

import java.sql.Date;
import java.util.Calendar;
import javax.swing.JTable;

/**
 *
 * @author Suzn
 */
public class Utils {

    public static int generateRandomID() {
        return (int) (Math.random() * 90000) + 10000;
    }

    public static java.sql.Date calanderToSqlDate(java.util.Calendar calendar) {
        return new java.sql.Date(calendar.getTimeInMillis());
    }

    public static java.util.Calendar sqlToCalandarDate(Date expiryDate) {
        java.util.Calendar c = new java.util.GregorianCalendar();
        c.setTime(expiryDate);
        return c;
    }

    public static Calendar millisToCalendar(long expiryDate) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(expiryDate);
        return c;
    }

    public static java.sql.Date millisToSql(long expiryDate) {
        return new java.sql.Date(expiryDate);
    }

    public static boolean isTableRowSelected(final javax.swing.JTable table) {
        return table.getSelectedRow() > -1;
    }

    public static int getIdFromTable(JTable table, int row) {
        return (int) table.getModel().getValueAt(row, 0);
    }
   

}
