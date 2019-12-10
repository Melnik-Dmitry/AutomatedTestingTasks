/*
 * Ввести n чисел с консоли.
 * Найти число, в котором количество различных цифр минимально.
 * Если таких чисел несколько, найти первое из них.
 */

package com.epam.melnik.java.fundamentals.optionaltask1.task4;

import com.epam.melnik.java.fundamentals.optionaltask1.util.NumbersCreator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AmountNumerals {

    public static int numberWithMinDifferentNumerals() {

        List<Integer> nums = NumbersCreator.getNumsAsInteger();
        Integer numberWithMinDifferentNumerals = nums.get(0);
        int minLengthSet =
                getAmountDifferentNumeralsInNumber(numberWithMinDifferentNumerals).size();

        for (int i = 0; i < nums.size(); i++) {
            Integer currentNumber = nums.get(i);
            int amountDifferentNumeralsInCurrentNumber =
                    getAmountDifferentNumeralsInNumber(currentNumber).size();
            if (amountDifferentNumeralsInCurrentNumber < minLengthSet) {
                numberWithMinDifferentNumerals = currentNumber;
                minLengthSet = amountDifferentNumeralsInCurrentNumber;
            }
        }

        return numberWithMinDifferentNumerals;
    }

    private static Set<Integer> getAmountDifferentNumeralsInNumber(int num) {

        int nextNumber = num;
        int remainder = num % 10;

        Set<Integer> numerals = new HashSet();
        numerals.add(remainder);

        nextNumber = (nextNumber - remainder) / 10;

        while (nextNumber != 0) {
            remainder = nextNumber % 10;
            numerals.add(remainder);
            nextNumber = (nextNumber - remainder) / 10;
        }

        return numerals;
    }
}
