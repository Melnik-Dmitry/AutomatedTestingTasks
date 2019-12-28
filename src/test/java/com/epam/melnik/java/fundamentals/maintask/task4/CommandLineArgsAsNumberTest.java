package com.epam.melnik.java.fundamentals.maintask.task4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class CommandLineArgsAsNumberTest {

    private String[] args;
    private double argsSumResult;
    private double argsMultiplicationResult;

    public CommandLineArgsAsNumberTest(String[] args,
                                       double argsSumResult,
                                       double argsMultiplicationResult) {

        this.args = args;
        this.argsSumResult = argsSumResult;
        this.argsMultiplicationResult = argsMultiplicationResult;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {

        return new Object[][]{
                {new String[]{"one", "two"}, 0, 0},
                {null, 0, 0},
                {new String[]{"1", "-1"}, 0, -1},
                {new String[]{"one", "-1"}, -1, -1},
                {new String[]{"12.1", "-10.23"}, 1.87, -123.783},
                {new String[]{"0.20", "-1.3"}, -1.1, -0.26}
        };
    }

    @Test
    public void argsSum() {

        assertEquals (argsSumResult,
                CommandLineArgsAsNumber.argsSum(args), 0.01);
    }

    @Test
    public void argsMultiplication() {

        assertEquals (argsMultiplicationResult,
                CommandLineArgsAsNumber.argsMultiplication(args), 0.01);
    }
}