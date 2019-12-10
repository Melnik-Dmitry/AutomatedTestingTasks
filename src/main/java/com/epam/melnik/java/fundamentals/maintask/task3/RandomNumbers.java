/*
 * Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
 */

package com.epam.melnik.java.fundamentals.maintask.task3;

import com.epam.melnik.java.util.TaskScanner;

import java.util.Random;

public class RandomNumbers {

    public static final String PHRASE_FOR_INTEGER = "Enter amount random numbers - ";

    public static final int LIMIT_RANDOM_NUMBERS = 101;

    public static void printNumbers() {
        int[] numbers = getNumbers();
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.print("\n");
    }

    public static void printNumbersWithNewLine() {
        int[] numbers = getNumbers();
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    private static int getAmountNumbers() {

        System.out.print(PHRASE_FOR_INTEGER);
        int amountNumbers = TaskScanner.getInteger();
        return amountNumbers;
    }

    private static int[] getNumbers() {
        int amountNumbers = getAmountNumbers();
        int[] numbers = new int[amountNumbers];
        Random random = new Random();

        for (int i = 0; i < amountNumbers; i++) {
            numbers[i] = random.nextInt(LIMIT_RANDOM_NUMBERS);
        }

        return numbers;
    }
}
