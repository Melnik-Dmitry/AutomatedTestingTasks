/*
 * Отобразить в окне консоли аргументы командной строки в обратном порядке.
 */

package com.epam.melnik.java.fundamentals.maintask.task2;

public class CommandLineArgs {

    public static void printCommandLineArgs(String[] args) {

        String[] mirrorArray = reverseArray(args);

        for (String currentArgument : mirrorArray) {
            System.out.print(currentArgument + " ");
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
