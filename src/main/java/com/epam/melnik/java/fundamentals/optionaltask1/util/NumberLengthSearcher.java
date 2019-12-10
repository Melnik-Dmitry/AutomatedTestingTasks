package com.epam.melnik.java.fundamentals.optionaltask1.util;

import java.util.List;
import java.util.OptionalDouble;

public class NumberLengthSearcher {

    public static int getNumLength(double num) {

        double absNum = Math.abs(num);

        String numAsString;
        if (absNum % 1 == 0) {
            int number = (int) absNum;
            numAsString = String.valueOf(number);
        } else {
            numAsString = String.valueOf(absNum);
            numAsString = numAsString.replace(".", "");
        }

        int numLength = numAsString.length();
        return numLength;
    }

    public static double getNumsMiddleLength(List<Double> list) {

        OptionalDouble middleLength = OptionalDouble.of(0);

        if (list != null && !list.isEmpty()) {
            middleLength = list
                    .stream()
                    .mapToDouble(num -> getNumLength(num))
                    .average();
        }

        return middleLength.getAsDouble();
    }
}
