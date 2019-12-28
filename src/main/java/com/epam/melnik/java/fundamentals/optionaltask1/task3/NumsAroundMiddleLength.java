/*
 * version: 1.1
 * made by Dmitry Melnik
 * 30-Dec-2019
 */

package com.epam.melnik.java.fundamentals.optionaltask1.task3;

import com.epam.melnik.java.fundamentals.optionaltask1.util.NumberLengthComparator;
import com.epam.melnik.java.fundamentals.optionaltask1.util.NumberLengthSearcher;
import com.epam.melnik.java.fundamentals.optionaltask1.util.NumbersCreator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Util class prints numbers around middle length all numbers in array
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class NumsAroundMiddleLength {

    public static final String NUMBERS_LENGTH_LESS_MIDDLE_LENGTH_MESSAGE =
            "Numbers, which length less that middle length all numbers in array -";
    public static final String NUMBERS_LENGTH_MORE_MIDDLE_LENGTH_MESSAGE =
            "Numbers, which length more that middle length all numbers in array -";

    /**
     * Method prints numbers, which length less that middle length all numbers in array
     */
    public static void printNumsLessMiddleLength() {

        List<Double> numsLessMiddleLength = getNumsLessMiddleLength();
        System.out.println(NUMBERS_LENGTH_LESS_MIDDLE_LENGTH_MESSAGE);
        for (Double num : numsLessMiddleLength) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * Method prints numbers, which length more that middle length all numbers in array
     */
    public static void printNumsMoreMiddleLength() {

        List<Double> numsMoreMiddleLength = getNumsMoreMiddleLength();
        System.out.println(NUMBERS_LENGTH_MORE_MIDDLE_LENGTH_MESSAGE);
        for (Double num : numsMoreMiddleLength) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static List<Double> getNumsLessMiddleLength() {

        List<Double> nums = NumbersCreator.getNumsAsDouble();
        double middleLength = NumberLengthSearcher.getNumsMiddleLength(nums);
        System.out.println("middleLength - " + middleLength);
        Collections.sort(nums, new NumberLengthComparator());

        List<Double> numsLessMiddleLength = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (NumberLengthSearcher.getNumLength(nums.get(i)) <= middleLength) {
                numsLessMiddleLength.add(nums.get(i));
            } else {
                break;
            }
        }
        ((ArrayList) numsLessMiddleLength).trimToSize();

        return numsLessMiddleLength;
    }

    private static List<Double> getNumsMoreMiddleLength() {

        List<Double> nums = NumbersCreator.getNumsAsDouble();
        double middleLength = NumberLengthSearcher.getNumsMiddleLength(nums);
        System.out.println("middleLength - " + middleLength);
        Collections.sort(nums, new NumberLengthComparator());
        Collections.reverse(nums);

        List<Double> numsMoreMiddleLength = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (NumberLengthSearcher.getNumLength(nums.get(i)) >= middleLength) {
                numsMoreMiddleLength.add(nums.get(i));
            } else {
                break;
            }
        }
        ((ArrayList) numsMoreMiddleLength).trimToSize();

        return numsMoreMiddleLength;
    }
}
