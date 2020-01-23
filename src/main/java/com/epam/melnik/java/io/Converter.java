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
 * Util class changes directory structure as String
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class Converter {

    public static final char SYSTEM_SEPARATOR = '\\';

    private static final String LEVEL_DOWN_PREFIX = "|--";
    private static final String TAB_PREFIX = "   ";

    /**
     * Method returns directory structure (including all in directories and files) as List<String>
     *
     * @param directoryPath
     * @return List<String>
     * @throws FileNotFoundException if directory by path @param directoryPath does not exist
     * @throws IllegalArgumentException if @param directoryPath null or empty
     */
    public static List<String> getDirectoryStructureAsString(String directoryPath)
            throws FileNotFoundException, IllegalArgumentException {

        List<String> fileStructureToString;
        if (directoryPath != null && !directoryPath.isEmpty()) {
            File file = new File(directoryPath);
            DirectoryStructureReader reader = new DirectoryStructureReader();
            List<File> fileStructure = reader.getFileFullStructure(file);
            fileStructureToString = new ArrayList<>(fileStructure.size());

            fileStructureToString.add(directoryPath + "\r\n");
            for (int i = 0; i < fileStructure.size(); i++) {
                String nameCurrentFile = fileStructure.get(i).getAbsolutePath();
                fileStructureToString.add(getPrefix(getAmountLevels(nameCurrentFile))
                        + fileStructure.get(i).getName() + "\r\n");
            }
        } else {
            throw new IllegalArgumentException();
        }

        return fileStructureToString;
    }

    private static String getPrefix(int amountPrefix) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < amountPrefix - 1; i++) {
            builder.append(TAB_PREFIX);
        }
        builder.append(LEVEL_DOWN_PREFIX);
        return builder.toString();
    }

    private static int getAmountLevels(String filePath) {

        return (int) filePath.chars().filter(symbol -> symbol == SYSTEM_SEPARATOR).count();
    }
}
