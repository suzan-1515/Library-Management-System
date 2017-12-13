/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.lms.exception;

/**
 *
 * @author Suzn
 */
public class MissingFileException extends Exception {

    /**
     * Creates a new instance of <code>MissingFileException</code> without
     * detail message.
     */
    public MissingFileException() {
    }

    /**
     * Constructs an instance of <code>MissingFileException</code> with the
     * specified detail message.
     *
     * @param filename the missing filename.
     */
    public MissingFileException(String filename) {
        super(String.format("%s file is missing!", filename));
    }

    /**
     *
     * @param filename
     * @param thrwbl
     */
    public MissingFileException(String filename, Throwable thrwbl) {
        super(String.format("%s file is missing!", filename), thrwbl);
    }

    /**
     *
     * @param thrwbl
     */
    public MissingFileException(Throwable thrwbl) {
        super(thrwbl);
    }

}
