package com.epam.melnik.java.classes.maintask.util.carcreator;

import java.time.LocalDate;
import java.util.Random;

public class ManufactureYearCreator {

    private static final Random random = new Random();
    public static final int startYear = 2000;
    public static final int finishYear = 2020;

    public static LocalDate createManufactureYear() {
        int year = createYear();
        int day = createDay();

        return LocalDate.ofYearDay(year, day);
    }

    public static int createYear() {
        int increment = finishYear - startYear;

        return random.nextInt(increment) + startYear;
    }

    private static int createDay() {

        return random.nextInt(365) + 1;
    }
}
