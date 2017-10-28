/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.util;

import java.sql.Date;

/**
 *
 * @author Suzn
 */
public class Utils {

    public static int generateRandomID() {
        return (int) (Math.random() * 9000) + 1000;
    }

    public static java.sql.Date calanderToSqlDate(java.util.Calendar calendar) {
        return new java.sql.Date(calendar.getTimeInMillis());
    }

    public static java.util.Calendar sqlToCalandarDate(Date expiryDate) {
        java.util.Calendar c = new java.util.GregorianCalendar();
        c.setTime(expiryDate);
        return c;
    }

}
