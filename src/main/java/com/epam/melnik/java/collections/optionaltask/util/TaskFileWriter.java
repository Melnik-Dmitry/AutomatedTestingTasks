/*
 * version: 1.1
 * made by Dmitry Melnik
 * 25-Dec-2019
 */

package com.epam.melnik.java.collections.optionaltask.util;

import java.io.*;

/**
 * Util class writes text to file
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class TaskFileWriter {

    /**
     * Method writes text in file.
     * Returns true if the recording was successful, if not -false.
     *
     * @param filePath
     * @param text
     * @return boolean
     */
    public static boolean writeText(String filePath,
                                    String... text) {

        boolean writeResult = false;
        if (filePath != null) {
            if (text != null && text.length > 0) {

                try (FileWriter writer =
                             new FileWriter(filePath)) {
                    for (int i = 0; i < text.length; i++) {
                        writer.append(text[i]);
                    }
                    writer.flush();
                    writeResult = true;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return writeResult;
    }
}
