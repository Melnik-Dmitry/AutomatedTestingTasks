/*
 * version: 1.1
 * made by Dmitry Melnik
 * 30-Dec-2019
 */

package com.epam.melnik.java.collections.optionaltask.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Util class sorts String[]
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class TextSorter {

    public static void main(String[] args) {

        List<String> rey = increaseSortByLengthLine(null);
        System.out.println();
    }

    /**
     * Method sorts String [] by length
     *
     * @param strings
     * @return List<String>
     */
    public static List<String> increaseSortByLengthLine(String... strings) {

        List<String> sortedByLengthLineArray;

        if (strings != null) {
            if (strings.length > 1) {
                sortedByLengthLineArray = Arrays.asList(strings);
                Collections.sort(sortedByLengthLineArray,
                        (firstLine, secondLine) -> firstLine.length() - secondLine.length());
            } else {
                sortedByLengthLineArray = Arrays.asList(strings);
            }
        } else {
            sortedByLengthLineArray = new ArrayList<>(0);
        }
        return sortedByLengthLineArray;
    }
}
