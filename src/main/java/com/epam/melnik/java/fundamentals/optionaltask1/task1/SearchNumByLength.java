/*
 * version: 1.1
 * made by Dmitry Melnik
 * 30-Dec-2019
 */

package com.epam.melnik.java.fundamentals.optionaltask1.task1;

import com.epam.melnik.java.fundamentals.optionaltask1.util.NumberLengthSearcher;
import com.epam.melnik.java.fundamentals.optionaltask1.util.NumbersCreator;

import java.util.List;

/**
 * Util class searches min or max number by length
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class SearchNumByLength {

    /**
     * Methods searches number with min length
     *
     * @return double
     */
    public static double searchNumWithMinLength() {

        List<Double> nums = NumbersCreator.getNumsAsDouble();
        Double minNumber = nums.get(0);

        for (int i = 0; i < nums.size(); i++) {
            if (NumberLengthSearcher.getNumLength(nums.get(i))
                    < NumberLengthSearcher.getNumLength(minNumber)) {
                minNumber = nums.get(i);
            }
        }
        return minNumber;
    }

    /**
     * Methods searches number with max length
     *
     * @return double
     */
    public static double searchNumWithMaxLength() {

        List<Double> nums = NumbersCreator.getNumsAsDouble();
        Double maxNumber = nums.get(0);

        for (int i = 0; i < nums.size(); i++) {
            if (NumberLengthSearcher.getNumLength(nums.get(i))
                    > NumberLengthSearcher.getNumLength(maxNumber)) {
                maxNumber = nums.get(i);
            }
        }
        return maxNumber;
    }
}