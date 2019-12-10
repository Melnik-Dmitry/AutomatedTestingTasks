/*
 * Ввести n чисел с консоли.
 * Вывести на консоль те числа, длина которых меньше (больше)
 * средней длины по всем числам, а также длину.
 */

package com.epam.melnik.java.fundamentals.optionaltask1.task3;

import com.epam.melnik.java.fundamentals.optionaltask1.util.NumberLengthComparator;
import com.epam.melnik.java.fundamentals.optionaltask1.util.NumberLengthSearcher;
import com.epam.melnik.java.fundamentals.optionaltask1.util.NumbersCreator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumsAroundMiddleLength {

    public static void printNumsLessMiddleLength() {

        List<Double> numsLessMiddleLength = getNumsLessMiddleLength();
//        System.out.println("newArraySize - " + numsLessMiddleLength.size());
        for (Double num : numsLessMiddleLength) {
            System.out.print(num + " ");
        }
    }

    public static void printNumsMoreMiddleLength() {

        List<Double> numsMoreMiddleLength = getNumsMoreMiddleLength();
//        System.out.println("newArraySize - " + numsMoreMiddleLength.size());
        for (Double num : numsMoreMiddleLength) {
            System.out.print(num + " ");
        }
    }

    private static List<Double> getNumsLessMiddleLength() {

        List<Double> nums = NumbersCreator.getNumsAsDouble();
        double middleLength = NumberLengthSearcher.getNumsMiddleLength(nums);
//        System.out.println("middleLength - " + middleLength);
        Collections.sort(nums, new NumberLengthComparator());

//        for (int i = 0; i < nums.size(); i++) {
//            System.out.println(nums.get(i));
//        }


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
//        for (int i = 0; i < nums.size(); i++) {
//            System.out.print(nums.get(i) + " ");
//        }

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
