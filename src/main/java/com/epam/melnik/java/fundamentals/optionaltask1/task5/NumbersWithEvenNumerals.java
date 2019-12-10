/*
 * Ввести n чисел с консоли.
 * Найти количество чисел, содержащих только четные цифры,
 * а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.
 */

package com.epam.melnik.java.fundamentals.optionaltask1.task5;

import com.epam.melnik.java.fundamentals.optionaltask1.util.NumbersCreator;

import java.util.ArrayList;
import java.util.List;

public class NumbersWithEvenNumerals {

    private static List<Integer> nums = NumbersCreator.getNumsAsInteger();
    private static List<Integer> restNumbers = new ArrayList<>();

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

    private static boolean isNumberFromEvenNumerals(int num) {

        int nextNumber = num;
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
}
