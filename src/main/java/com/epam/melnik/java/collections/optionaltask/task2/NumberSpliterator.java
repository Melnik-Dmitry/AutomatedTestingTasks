/*
 * version: 1.1
 * made by Dmitry Melnik
 * 30-Dec-2019
 */

package com.epam.melnik.java.collections.optionaltask.task2;

import java.util.LinkedList;

/**
 * Util class splits Integer
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class NumberSpliterator {

    public static final int DIVIDER = 10;

    /**
     * Method splits number by digits, adds digits in LinkedList
     *
     * @param number
     * @return LinkedList<Integer>
     */
    public static LinkedList<Integer> splitNumber(int number) {

        int numberByModule = Math.abs(number);
        LinkedList<Integer> numberDigits = new LinkedList<>();
        int numberRemains = numberByModule % DIVIDER;
        numberDigits.add(numberRemains);
        numberByModule = (numberByModule - numberRemains) / DIVIDER;

        while (numberByModule != 0) {
            numberRemains = numberByModule % DIVIDER;
            numberDigits.add(numberRemains);
            numberByModule = (numberByModule - numberRemains) / DIVIDER;
        }

        return numberDigits;
    }

    /**
     * Method reverses number in reverse order.
     * Returns reverse number
     *
     * @param number
     * @return int
     */
    public static int getNumberWithReverseDigits(int number) {

        LinkedList<Integer> numberDigits = splitNumber(number);
        int numberWithReverseDigits = 0;
        int amountDigits = numberDigits.size();
        for (int i = 0; i < amountDigits; i++) {
            numberWithReverseDigits +=
                    ((int) Math.pow(DIVIDER, i)) * numberDigits.removeLast();
        }
        if (number < 0) {
            numberWithReverseDigits *= -1;
        }

        return numberWithReverseDigits;
    }
}