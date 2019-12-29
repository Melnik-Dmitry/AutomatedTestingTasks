/*
 * version: 1.1
 * made by Dmitry Melnik
 * 30-Dec-2019
 */

package com.epam.melnik.java.classes.maintask.util.carcreator;

import java.util.Random;

/**
 * Utility class designed to generate CarModel.
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class RegistrationNumberCreator {

    private static Random random = new Random();
    private static String[] registrationSeries = new String[]{"AA", "AB", "AC"};
    private static final int MAX_NUMBER_FOR_REGISTRATION_NUMBER = 10;
    private static final int AMOUNT_NUMBERS_FOR_REGISTRATION_NUMBER = 4;

    /**
     * Method creates car's registration number
     *
     * @return String
     */
    public static String createNumber() {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < AMOUNT_NUMBERS_FOR_REGISTRATION_NUMBER; i++) {
            builder.append(random.nextInt(MAX_NUMBER_FOR_REGISTRATION_NUMBER));
        }
        builder.append(" - ");
        String registrationNumberSeries =
                registrationSeries[random.nextInt(registrationSeries.length)];
        builder.append(registrationNumberSeries);

        return builder.toString();
    }
}
