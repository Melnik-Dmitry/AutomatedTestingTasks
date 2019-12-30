package com.epam.melnik.java.collections.optionaltask.task2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class NumberSpliteratorTest {

    private int number;
    private List<Integer> splitNumberResult;
    private int reverseNumberResult;

    @Parameterized.Parameters
    public static Object[][] testData() {

        List<Integer> splitFirstNumber = new LinkedList<>();
        splitFirstNumber.add(0);

        List<Integer> splitSecondNumber = new LinkedList<>();
        splitSecondNumber.add(0);
        splitSecondNumber.add(0);
        splitSecondNumber.add(1);

        List<Integer> splitThirdNumber = new LinkedList<>();
        splitThirdNumber.add(3);
        splitThirdNumber.add(2);
        splitThirdNumber.add(1);

        return new Object[][]{
                {0, splitFirstNumber, 0},
                {100, splitSecondNumber, 1},
                {-100, splitSecondNumber, -1},
                {123, splitThirdNumber, 321},
                {-123, splitThirdNumber, -321}
        };
    }

    public NumberSpliteratorTest(int number,
                                 List<Integer> splitNumberResult,
                                 int reverseNumberResult) {

        this.number = number;
        this.splitNumberResult = splitNumberResult;
        this.reverseNumberResult = reverseNumberResult;
    }

    @Test
    public void splitNumber() {

        assertEquals(splitNumberResult, NumberSpliterator.splitNumber(number));
    }

    @Test
    public void getNumberWithReverseDigits() {

        assertEquals(reverseNumberResult, NumberSpliterator.getNumberWithReverseDigits(number));
    }
}