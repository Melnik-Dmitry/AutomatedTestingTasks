/*
 * version: 1.1
 * made by Dmitry Melnik
 * 25-Dec-2019
 */

package com.epam.melnik.java.classes.maintask.util.carcreator;

import java.time.LocalDate;
import java.util.Random;

/**
 * Utility class designed to generate car's manufacture year.
 *
 * @author Dmitry Melnik
 * @see Object
 * @see LocalDate
 */
public class ManufactureYearCreator {

    private static final Random random = new Random();
    public static final int startYear = 2000;
    public static final int finishYear = 2020;

    /**
     * create car's manufacture year
     *
     * @return LocalDate
     */
    public static LocalDate createManufactureYear() {

        int year = createYear();
        int day = createDay();

        return LocalDate.ofYearDay(year, day);
    }

    private static int createYear() {

        int incrementFinishStartYear = finishYear - startYear;

        return random.nextInt(incrementFinishStartYear) + startYear;
    }

    private static int createDay() {

        return random.nextInt(365) + 1;
    }
}
