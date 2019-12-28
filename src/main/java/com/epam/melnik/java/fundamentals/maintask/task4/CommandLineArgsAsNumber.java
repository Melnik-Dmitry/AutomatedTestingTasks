/*
 * version: 1.1
 * made by Dmitry Melnik
 * 30-Dec-2019
 */

package com.epam.melnik.java.fundamentals.maintask.task4;

import com.epam.melnik.java.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Util class performs mathematical operations with Command Line arguments
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class CommandLineArgsAsNumber {

    /**
     * Methods returns the sum of numbers, if they represent a number
     *
     * @param args
     * @return double
     */
    public static double argsSum(String[] args) {

        double argsSum = 0;
        if (args != null) {
            argsSum = getNumbers(args)
                    .stream()
                    .mapToDouble(number -> Double.valueOf(number))
                    .sum();
        }
        return argsSum;
    }

    /**
     * Methods returns the multiplication of numbers, if they represent a number
     *
     * @param args
     * @return double
     */
    public static double argsMultiplication(String[] args) {

        double result = 0;
        if (args != null) {
            double[] nums = getNumbers(args).stream()
                    .mapToDouble(num -> Double.valueOf(num))
                    .toArray();
            if (nums.length > 0) {
                result = 1;
                for (Double num : nums) {
                    result *= num;
                }
            }
        }
        return result;
    }

    private static List<String> getNumbers(String[] args) {

        List<String> nums =
                Arrays.stream(args)
                        .filter(argument -> Validator.isArgumentNumber(argument))
                        .collect(Collectors.toList());

        return nums;
    }
}