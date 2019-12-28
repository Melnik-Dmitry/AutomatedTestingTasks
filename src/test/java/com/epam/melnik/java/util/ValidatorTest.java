package com.epam.melnik.java.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class ValidatorTest {

    private int checkedNumber;
    private boolean checkedNumberResult;
    private String checkedArgument;
    private boolean checkedArgumentResult;

    public ValidatorTest(int checkedNumber,
                         boolean checkedNumberResult,
                         String checkedArgument,
                         boolean checkedArgumentResult) {

        this.checkedNumber = checkedNumber;
        this.checkedNumberResult = checkedNumberResult;
        this.checkedArgument = checkedArgument;
        this.checkedArgumentResult = checkedArgumentResult;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {

        return new Object[][]{
                {0, false, "test", false},
                {-1, false, "-25", true},
                {13, false, "25", true},
                {150, false, "-009", true},
                {6, true, "009", true},
                {2, true, "-9.56", true},
                {1200, false, "156.0000", true},
                {-1200, false, "00.789", true}
        };
    }

    @Test
    public void checkNumber() {

        assertEquals(checkedNumberResult,
                Validator.checkNumber(checkedNumber));
    }

    @Test
    public void isArgumentNumber() {

        assertEquals(checkedArgumentResult,
                Validator.isArgumentNumber(checkedArgument));
    }
}