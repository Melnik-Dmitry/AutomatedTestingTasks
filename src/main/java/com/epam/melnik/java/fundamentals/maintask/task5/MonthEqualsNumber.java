/*
 * version: 1.1
 * made by Dmitry Melnik
 * 30-Dec-2019
 */

package com.epam.melnik.java.fundamentals.maintask.task5;

import com.epam.melnik.java.util.TaskScanner;
import com.epam.melnik.java.util.Validator;

/**
 * Util class takes month from array
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class MonthEqualsNumber {

    public static final String[] MONTH = {
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "Jule",
            "August",
            "September",
            "October",
            "November",
            "December"
    };

    public static final String MONTH_NUMBER = "Enter a number from 1 to 12: ";

    public static final String WARNING_MESSAGE_FOR_NUMBER_OUTSIDE = "Number is not valid. Try again - ";

    /**
     * Method prints month according to the numbers entered by the user
     */
    public static void getMonth() {

        int monthPosition = getInteger() - 1;
        System.out.println(MONTH[monthPosition]);
    }

    private static int getInteger() {

        System.out.print(MONTH_NUMBER);
        int result = TaskScanner.getInteger();
        boolean isResultTrue = Validator.checkNumber(result);
        while (!isResultTrue) {
            System.out.print(WARNING_MESSAGE_FOR_NUMBER_OUTSIDE);
            result = TaskScanner.getInteger();
            isResultTrue = Validator.checkNumber(result);
        }
        return result;
    }
}
