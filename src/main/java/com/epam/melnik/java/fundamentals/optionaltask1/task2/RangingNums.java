/*
 * version: 1.1
 * made by Dmitry Melnik
 * 30-Dec-2019
 */

package com.epam.melnik.java.fundamentals.optionaltask1.task2;

import com.epam.melnik.java.fundamentals.optionaltask1.util.NumberLengthComparator;
import com.epam.melnik.java.fundamentals.optionaltask1.util.NumbersCreator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Util class ranks numbers by length
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class RangingNums {

    public static final String INCREASING_NUMBERS_MESSAGE =
            "Numbers in ascending order of their length values - ";
    public static final String DECREASING_NUMBERS_MESSAGE =
            "Numbers in descending order of their length values - ";

    /**
     * Method prints numbers in ascending order of their length
     */
    public static void printIncreasingNumbers() {

        List<Double> nums = increasingNumbersByLength();
        System.out.print(INCREASING_NUMBERS_MESSAGE);
        for (Double num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * Method prints numbers in descending order of their length
     */
    public static void printDecreasingNumbers() {
        List<Double> nums = decreasingNumbersByLength();
        System.out.print(DECREASING_NUMBERS_MESSAGE);
        for (Double num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
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
