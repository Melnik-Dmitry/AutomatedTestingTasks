/*
 *  Ввести целые числа как аргументы командной строки,
 * подсчитать их сумму (произведение) и вывести результат на консоль.
 */


package com.epam.melnik.java.fundamentals.maintask.task4;

import com.epam.melnik.java.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandLineArgsAsNumber {

    public static double argsSum(String[] args) {

        double sum = getNumbers(args)
                .stream()
                .mapToDouble(number -> Double.valueOf(number))
                .sum();
        return sum;
    }

    public static double argsMultiplication(String[] args) {

        double[] nums = getNumbers(args).stream()
                .mapToDouble(num -> Double.valueOf(num))
                .toArray();
        double result = 1;
        for (Double num : nums) {
            result *= num;
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