/*
 * Ввести n чисел с консоли.
 * Найти самое короткое и самое длинное число.
 * Вывести найденные числа и их длину.
 */

package com.epam.melnik.java.fundamentals.optionaltask1.task1;

import com.epam.melnik.java.fundamentals.optionaltask1.util.NumberLengthSearcher;
import com.epam.melnik.java.fundamentals.optionaltask1.util.NumbersCreator;

import java.util.List;

public class SearchNumByLength {

    public static double searchNumWithMinLength() {

        List<Double> nums = NumbersCreator.getNumsAsDouble();
        Double min = nums.get(0);

        for (int i = 0; i < nums.size(); i++) {
            if (NumberLengthSearcher.getNumLength(nums.get(i))
                    < NumberLengthSearcher.getNumLength(min)) {
                min = nums.get(i);
            }
        }
        return min;
    }

    public static double searchNumWithMaxLength() {

        List<Double> nums = NumbersCreator.getNumsAsDouble();
        Double max = nums.get(0);

        for (int i = 0; i < nums.size(); i++) {
            if (NumberLengthSearcher.getNumLength(nums.get(i))
                    > NumberLengthSearcher.getNumLength(max)) {
                max = nums.get(i);
            }
        }
        return max;
    }
}