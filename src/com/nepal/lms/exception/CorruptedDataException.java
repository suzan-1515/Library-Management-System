/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.exception;

/**
 *
 * @author Suzn
 */
public class CorruptedDataException extends Exception {

    /**
     * Creates a new instance of <code>CorruptedDataexception</code> without
     * detail message.
     */
    public CorruptedDataException() {
        this("File data is corrupted!");
    }

    /**
     * Constructs an instance of <code>CorruptedDataexception</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CorruptedDataException(String msg) {
        super(msg);
    }

    public CorruptedDataException(Throwable thrwbl) {
        super("File data is corrupted!", thrwbl);
    }

    public CorruptedDataException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

}
