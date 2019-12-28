/*
 * version: 1.1
 * made by Dmitry Melnik
 * 30-Dec-2019
 */

package com.epam.melnik.java.util;

import java.util.regex.Pattern;

/**
 * Util class checks data validation
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class Validator {

    public static final int MIN_NUM = 1;

    public static final int MAX_NUM = 12;

    public static final String NUMBER_PATTERN = "-?[0-9]+(,|.)?[0-9]*";

    /**
     * Method checks is number in limit
     *
     * @param number
     * @return boolean
     */
    public static boolean checkNumber(int number) {

        boolean isNumberInLimit = false;

        if (number >= MIN_NUM && number <= MAX_NUM) {
            isNumberInLimit = true;
        }

        return isNumberInLimit;
    }

    /**
     * Method checks is argument number
     *
     * @param argument
     * @return
     */
    public static boolean isArgumentNumber(String argument) {

        return Pattern.matches(NUMBER_PATTERN, argument);
    }
}
