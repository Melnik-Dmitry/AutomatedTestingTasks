/*
 * version: 1.1
 * made by Dmitry Melnik
 * 23-Jan-2020
 */

package com.epam.melnik.java.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Util class for directory structure reading
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class DirectoryStructureReader {

    private List<File> files;

    /**
     * Method gets file structure (including all in directories and files) as List<File>
     *
     * @param file
     * @return List<File>
     * @throws IllegalArgumentException if @param file null
     * @throws FileNotFoundException if @param file does not exist
     */
    public List<File> getFileFullStructure(File file)
            throws IllegalArgumentException, FileNotFoundException {

        if (file != null) {
            if (file.exists()) {
                files = new ArrayList<>();
                getAllLevelStructure(file);
            } else {
                throw new FileNotFoundException();
            }
        } else {
            throw new IllegalArgumentException();
        }
        return files;
    }

    private File[] getFileStructure(File file) {

        File[] structure = file.listFiles();
        return structure;
    }

    private void getAllLevelStructure(File incomeFile) {

        File[] fistLevel = getFileStructure(incomeFile);
        for (File file : fistLevel) {
            files.add(file);
            if (file.isDirectory()) {
                getAllLevelStructure(file);
            }
        }
    }
}