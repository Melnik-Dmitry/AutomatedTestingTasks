package com.epam.melnik.java.fundamentals.optionaltask1.util;

import com.epam.melnik.java.util.TaskScanner;

import java.util.ArrayList;
import java.util.List;

public class NumbersCreator {

    public static final String MESSAGE_FOR_AMOUNT_NUMBERS = "Enter amount numbers - ";
    public static final String MESSAGE_FOR_ENTER_NUMBER = "Enter numbers for search - ";
    public static final String MESSAGE_FOR_EMPTY_ARRAY = "Array can not be empty.";

    public static List<Double> getNumsAsDouble() {

        int amountNums = getAmountNums();

        while (amountNums <= 0) {
            System.out.println(MESSAGE_FOR_EMPTY_ARRAY);
            amountNums = getAmountNums();
        }

        List<Double> nums = new ArrayList(amountNums);
        System.out.print(MESSAGE_FOR_ENTER_NUMBER);

        for (int i = 0; i < amountNums; i++) {
            nums.add(TaskScanner.getNum());
        }

        return nums;
    }

    public static List<Integer> getNumsAsInteger() {

        int amountNums = getAmountNums();

        while (amountNums <= 0) {
            System.out.println(MESSAGE_FOR_EMPTY_ARRAY);
            amountNums = getAmountNums();
        }

        List<Integer> nums = new ArrayList(amountNums);
        System.out.print(MESSAGE_FOR_ENTER_NUMBER);

        for (int i = 0; i < amountNums; i++) {
            nums.add(TaskScanner.getInteger());
        }

        return nums;
    }

    private static int getAmountNums() {

        System.out.print(MESSAGE_FOR_AMOUNT_NUMBERS);
        int amount = TaskScanner.getInteger();
        return amount;
    }
}
