/*
 * version: 1.1
 * made by Dmitry Melnik
 * 30-Dec-2019
 */

package com.epam.melnik.java.util;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Util class accepts console data entered by the user
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class TaskScanner {

    public static final String WARNING_MESSAGE_FOR_WRONG_NAME = "This is not name. Try again - ";
    public static final String WARNING_MESSAGE_FOR_INTEGER = "This is not Integer. Try again - ";
    public static final String WARNING_MESSAGE_FOR_WRONG_NUMBER = "This is not Number. Try again - ";

    public static final String NAME_PATTERN = "[a-zA-Z]{1,}";

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Method accepts data, as userName from the console entered by the user.
     * If the entered data is not valid offers to make another attempt to enter data
     *
     * @return String
     */
    public static String getName() {

        String userEnter = scanner.next();

        while (!Pattern.matches(NAME_PATTERN, userEnter)) {
            System.out.print(WARNING_MESSAGE_FOR_WRONG_NAME);
            userEnter = scanner.next();
        }

        return userEnter;
    }

    /**
     * Method accepts data, as Integer from the console entered by the user.
     * If the entered data is not valid offers to make another attempt to enter data
     *
     * @return int
     */
    public static int getInteger() {

        boolean isInteger = scanner.hasNextInt();
        while (!isInteger) {
            System.out.print(WARNING_MESSAGE_FOR_INTEGER);
            String next = scanner.next();
            isInteger = scanner.hasNextInt();
        }
        int userEnter = scanner.nextInt();

        return userEnter;
    }

    /**
     * Method accepts data, as Integer or Double from the console entered by the user.
     * If the entered data is not valid offers to make another attempt to enter data
     *
     * @return double
     */
    public static double getNum() {

        boolean isNum = scanner.hasNextInt() || scanner.hasNextDouble();
        while (!isNum) {
            System.out.println(WARNING_MESSAGE_FOR_WRONG_NUMBER);
            String next = scanner.next();
            isNum = scanner.hasNextInt() || scanner.hasNextDouble();
        }
        double number = scanner.nextDouble();

        return number;
    }
}
