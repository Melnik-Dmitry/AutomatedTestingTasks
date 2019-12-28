package com.epam.melnik.java.fundamentals.optionaltask1.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class NumberLengthComparatorTest {

    private Object firstNumber;
    private Object secondNumber;
    private int compareResult;
    private NumberLengthComparator comparator = new NumberLengthComparator();

    public NumberLengthComparatorTest(Object firstNumber,
                                      Object secondNumber,
                                      int compareResult) {

        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.compareResult = compareResult;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {

        return new Object[][]{
                {0.23, 1.265, -1},
                {1.02, null, 0},
                {-1.2, -23.25, -1},
                {0.23, 0.23, 0},
                {0.23564, 1.69, 1}
        };
    }

    @Test
    public void compare() {

        assertEquals(compareResult, comparator.compare(firstNumber, secondNumber));
    }
}