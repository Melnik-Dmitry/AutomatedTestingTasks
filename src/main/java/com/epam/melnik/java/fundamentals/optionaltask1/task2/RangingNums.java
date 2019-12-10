/*
 * Ввести n чисел с консоли.
 * Вывести числа в порядке возрастания (убывания) значений их длины.
 */

package com.epam.melnik.java.fundamentals.optionaltask1.task2;

import com.epam.melnik.java.fundamentals.optionaltask1.util.NumberLengthComparator;
import com.epam.melnik.java.fundamentals.optionaltask1.util.NumbersCreator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RangingNums {

    public static void printIncreasingNumbers() {

        List<Double> nums = increasingNumbersByLength();
        for (Double num : nums) {
            System.out.print(num + " ");
            System.out.println();
        }
    }

    public static void printDecreasingNumbers() {
        List<Double> nums = decreasingNumbersByLength();
        for (Double num : nums) {
            System.out.print(num + " ");
            System.out.println();
        }
    }

    private static List<Double> increasingNumbersByLength() {

        List<Double> nums =
                (List<Double>) NumbersCreator.getNumsAsDouble()
                        .stream()
                        .sorted(new NumberLengthComparator())
                        .collect(Collectors.toList());

        return nums;
    }

    private static List<Double> decreasingNumbersByLength() {
        List<Double> nums = increasingNumbersByLength();
        Collections.reverse(nums);

        return nums;
    }
}
