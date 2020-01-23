/*
 * version: 1.1
 * made by Dmitry Melnik
 * 23-Jan-2020
 */

package com.epam.melnik.java.io;

import com.epam.melnik.java.collections.optionaltask.util.TaskFileWriter;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Util class writes directory structure as String in file
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class DirectoryStructureWriter {

    /**
     * Method writes directory structure by @param directoryPath  as String in file @param writeTargetFilePath
     *
     * @param writeTargetFilePath
     * @param directoryPath
     * @return boolean
     * @throws FileNotFoundException    if directory by path @param directoryPath does not exist
     * @throws IllegalArgumentException if @param directoryPath null or empty
     */
    public static boolean write(String writeTargetFilePath, String directoryPath)
            throws FileNotFoundException, IllegalArgumentException {

        List<String> filesInDirectory = Converter.getDirectoryStructureAsString(directoryPath);
        boolean writeResult =
                TaskFileWriter.writeText(writeTargetFilePath,
                        filesInDirectory.toArray(new String[0]));

        return writeResult;
    }
}
