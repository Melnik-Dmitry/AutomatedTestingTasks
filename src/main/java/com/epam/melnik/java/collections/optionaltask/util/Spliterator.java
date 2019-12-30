/*
 * version: 1.1
 * made by Dmitry Melnik
 * 30-Dec-2019
 */

package com.epam.melnik.java.collections.optionaltask.util;

/**
 * Util class splits String
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class Spliterator {

    public static final String END_LINE_SPLITERATOR = "\r\n";

    /**
     * Method splits @param text using the specified separator
     *
     * @param text
     * @param spliterator
     * @return
     */
    public static String[] splitReadText(String text, String spliterator) {

        String[] splitText = new String[0];

        if (text != null && spliterator != null && !text.isEmpty()) {
            splitText = text.split(spliterator);
        }

        return splitText;
    }

    /**
     * Method splits @param text using the specified separator.
     * If @param text = null or empty method returns array with zero length.
     * Prepares split String array for reverse,
     * adds symbol '.' to all lines exclude first
     *
     * @param text
     * @return String[]
     */
    public static String[] splitReadTextForReverse(String text, String spliterator) {

        String[] splitText = splitReadText(text, spliterator);

        if (text != null && spliterator != null && !text.isEmpty()) {
            splitText = fillLinesWithSplitSymbols(splitText);
        }

        return splitText;
    }

    private static String[] fillLinesWithSplitSymbols(String[] text) {

        for (int i = text.length - 1; i > 0; i--) {
            text[i] += END_LINE_SPLITERATOR;
        }
        return text;
    }
}
