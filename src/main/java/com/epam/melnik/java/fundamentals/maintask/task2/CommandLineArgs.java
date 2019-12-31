/*
 * version: 1.1
 * made by Dmitry Melnik
 * 30-Dec-2019
 */

package com.epam.melnik.java.fundamentals.maintask.task2;

/**
 * Util class prints Command Line Arguments
 *
 * @author Dmitry Melnik
 * @see Object
 */

public class CommandLineArgs {

    public static final String EMPTY_COMMAND_LINE_ARGS = "Command line args array is empty";

    /**
     * Method reverses and prints Command Line Arguments
     *
     * @param args
     */
    public static void printCommandLineArgs(String[] args) {

        if (args != null & args.length > 0) {
            String[] mirrorArray = reverseArray(args);

            for (String currentArgument : mirrorArray) {
                System.out.print(currentArgument + " ");
            }
        } else {
            System.out.println(EMPTY_COMMAND_LINE_ARGS);
        }
        System.out.print("\n");
    }

    private static String[] reverseArray(String[] sourceArray) {

        String[] newArray = new String[sourceArray.length];

        int middlePosition = sourceArray.length / 2;

        for (int i = 0; i < middlePosition; i++) {
            int mirrorPosition = sourceArray.length - i - 1;
            newArray[i] = sourceArray[mirrorPosition];
            newArray[mirrorPosition] = sourceArray[i];
        }

        boolean isArrayLengthOdd = sourceArray.length % 2 != 0;
        if (isArrayLengthOdd) {
            newArray[middlePosition] = sourceArray[middlePosition];
        }

        return newArray;
    }
}
