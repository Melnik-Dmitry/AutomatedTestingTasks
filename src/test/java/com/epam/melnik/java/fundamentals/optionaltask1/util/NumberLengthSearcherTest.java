package com.epam.melnik.java.fundamentals.optionaltask1.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class NumberLengthSearcherTest {

    private double number;
    private int numberLengthResult;
    private List<Double> numbers;
    private double middleLengthAllStrings;

    public NumberLengthSearcherTest(double number,
                                    int numberLengthResult,
                                    List<Double> numbers,
                                    double middleLengthAllStrings) {

        this.number = number;
        this.numberLengthResult = numberLengthResult;
        this.numbers = numbers;
        this.middleLengthAllStrings = middleLengthAllStrings;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {

        return new Object[][]{
                {-2.30, 2, Arrays.asList(new Double[]{1.0, null, 1.02}), 2},
                {-0.3, 2, null, 0},
                {233, 3, Arrays.asList(new Double[]{1.0012, 1.23}), 4},
                {-1.0, 1, Arrays.asList(new Double[]{-001.0012, -1121.23, -0023.05}), 5},
                {-1, 1, Arrays.asList(new Double[]{-101.001152, -1121.23, -0023.05}), 6.33},
                {0005.0, 1, Arrays.asList(new Double[]{111.01, 1.23, 0023.0, 56.894}), 3.75}
        };
    }

    @Test
    public void getNumLength() {

        assertEquals(numberLengthResult, NumberLengthSearcher.getNumLength(number), 0.01);
    }

    @Test
    public void getNumsMiddleLength() {

        assertEquals(middleLengthAllStrings, NumberLengthSearcher.getNumsMiddleLength(numbers), 0.01);
    }
}