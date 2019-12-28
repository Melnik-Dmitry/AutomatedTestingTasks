/*
 * version: 1.1
 * made by Dmitry Melnik
 * 30-Dec-2019
 */

package com.epam.melnik.java.fundamentals.optionaltask1.task5;

import com.epam.melnik.java.fundamentals.optionaltask1.util.NumbersCreator;

import java.util.ArrayList;
import java.util.List;

/**
 * Util class searches for numbers by even and odd numbers
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class NumbersWithEvenNumerals {

    private static List<Integer> nums = NumbersCreator.getNumsAsInteger();
    private static List<Integer> restNumbers = new ArrayList<>();

    /**
     * Method gets amount numbers containing only even digits
     *
     * @return int
     */
    public static int getAmountNumsWithEvenNumerals() {

        int amountNumbersWithEvenNumerals = 0;
        for (int i = 0; i < nums.size(); i++) {
            Integer currentNumber = nums.get(i);
            if (isNumberFromEvenNumerals(currentNumber)) {
                amountNumbersWithEvenNumerals++;
            } else {
                restNumbers.add(currentNumber);
            }
        }
        return amountNumbersWithEvenNumerals;
    }

    /**
     * Method gets amount numbers with an equal number of even and odd digits
     *
     * @return int
     */
    public static int getAmountNumbersWithEqualNumberEvenAndOddDigits() {

        int amountNumsWithEqualNumberEvenAndOddDigits = 0;

        if (!restNumbers.isEmpty()) {

            for (int i = 0; i < restNumbers.size(); i++) {
                Integer currentNumber = restNumbers.get(i);
                int remainder = currentNumber % 10;
                int numLength = 1;
                int amountEvenNumerals = 0;

                if (checkIsEven(remainder)) {
                    amountEvenNumerals++;
                }
                currentNumber = (currentNumber - remainder) / 10;

                while (currentNumber != 0) {
                    remainder = currentNumber % 10;
                    numLength++;
                    if (checkIsEven(remainder)) {
                        amountEvenNumerals++;
                    }
                    currentNumber = (currentNumber - remainder) / 10;
                }

                if (amountEvenNumerals == (numLength - amountEvenNumerals)) {
                    amountNumsWithEqualNumberEvenAndOddDigits++;
                }
            }
        }
        return amountNumsWithEqualNumberEvenAndOddDigits;
    }

    private static boolean isNumberFromEvenNumerals(int num) {

        int nextNumber = Math.abs(num);
        int remainder = num % 10;
        int numLength = 1;
        int amountEvenNumerals = 0;

        if (checkIsEven(remainder)) {
            amountEvenNumerals++;
        }
        nextNumber = (nextNumber - remainder) / 10;

        while (nextNumber != 0) {
            remainder = nextNumber % 10;
            numLength++;
            if (checkIsEven(remainder)) {
                amountEvenNumerals++;
            }
            nextNumber = (nextNumber - remainder) / 10;
        }
        boolean isNumberFromEvenNumerals = false;
        if (numLength == amountEvenNumerals) {
            isNumberFromEvenNumerals = true;
        }

        return isNumberFromEvenNumerals;
    }

    private static boolean checkIsEven(int num) {

        boolean isEven = false;
        if (num % 2 == 0) {
            isEven = true;
        }
        return isEven;
    }
}
