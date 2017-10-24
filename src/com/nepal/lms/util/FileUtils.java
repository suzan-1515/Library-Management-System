/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.util;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Suzn
 */
public class FileUtils {

    public static boolean exists(final String filename) {
        return Files.exists(Paths.get(filename));
    }

    public static boolean notExist(final String filename) {
        return Files.notExists(Paths.get(filename));
    }

}
