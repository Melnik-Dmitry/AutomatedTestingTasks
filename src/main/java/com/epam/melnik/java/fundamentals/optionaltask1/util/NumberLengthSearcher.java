/*
 * version: 1.1
 * made by Dmitry Melnik
 * 30-Dec-2019
 */

package com.epam.melnik.java.fundamentals.optionaltask1.util;

import java.util.List;
import java.util.OptionalDouble;

/**
 * Util class gets numbers length
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class NumberLengthSearcher {

    /**
     * Method counts amounts digit and returns it
     *
     * @param num
     * @return int
     */
    public static int getNumLength(double num) {

        double absNum = Math.abs(num);

        String numAsString;
        if (absNum % 1 == 0) {
            int number = (int) absNum;
            numAsString = String.valueOf(number);
        } else {
            numAsString = String.valueOf(absNum);
            numAsString = numAsString.replace(".", "");
        }

        int numLength = numAsString.length();
        return numLength;
    }

    /**
     * Method returns the average length all Strings in the array
     *
     * @param list
     * @return double
     */
    public static double getNumsMiddleLength(List<Double> list) {

        OptionalDouble middleLength = OptionalDouble.of(0);

        if (list != null && !list.isEmpty()) {
            middleLength = list
                    .stream()
                    .filter(num -> num != null)
                    .mapToDouble(num -> getNumLength(num))
                    .average();
        }

        return middleLength.getAsDouble();
    }
}
