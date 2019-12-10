package com.epam.melnik.java.util;

import java.util.regex.Pattern;

public class Validator {

    public static final int MIN_NUM = 1;

    public static final int MAX_NUM = 12;

    public static final String NUMBER_PATTERN = "[0-9]{1,}(,|.){0,1}[0-9]{0,}";

    public static boolean checkNumber(int number) {

        boolean isNumberInLimit = false;

        if (number >= MIN_NUM && number <= MAX_NUM) {
            isNumberInLimit = true;
        }

        return isNumberInLimit;
    }

    public static boolean isArgumentNumber(String argument) {

        return Pattern.matches(NUMBER_PATTERN, argument);
    }
}
