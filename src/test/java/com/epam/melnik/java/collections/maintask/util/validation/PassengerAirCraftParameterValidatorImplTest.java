package com.epam.melnik.java.collections.maintask.util.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class PassengerAirCraftParameterValidatorImplTest {

    private int amountPorthole;
    private boolean amountPortholeResult;

    private PassengerAirCraftParameterValidator validator = new PassengerAirCraftParameterValidatorImpl();

    @Parameterized.Parameters
    public static Object[][] testData() {

        return new Object[][]{
                {10, true},
                {50, true},
                {-10, false},
                {500, false}
        };
    }

    public PassengerAirCraftParameterValidatorImplTest(int amountPorthole,
                                                       boolean amountPortholeResult) {

        this.amountPorthole = amountPorthole;
        this.amountPortholeResult = amountPortholeResult;
    }

    @Test
    public void checkAmountPorthole() {

        assertEquals(amountPortholeResult, validator.checkAmountPorthole(amountPorthole));
    }
}