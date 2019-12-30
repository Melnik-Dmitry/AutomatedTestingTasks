package com.epam.melnik.java.collections.maintask.util.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class CargoAirCraftParameterValidatorImplTest {

    private int amountCargoHatch;
    private boolean amountCargoHatchResult;

    private CargoAirCraftParameterValidator validator = new CargoAirCraftParameterValidatorImpl();

    @Parameterized.Parameters
    public static Object[][] testData() {

        return new Object[][]{
                {1, true},
                {10, true},
                {-1, false},
                {100, false}
        };
    }

    public CargoAirCraftParameterValidatorImplTest(int amountCargoHatch,
                                                   boolean amountCargoHatchResult) {

        this.amountCargoHatch = amountCargoHatch;
        this.amountCargoHatchResult = amountCargoHatchResult;
    }

    @Test
    public void checkAmountCargoHatch() {

        assertEquals(amountCargoHatchResult, validator.checkAmountCargoHatch(amountCargoHatch));
    }
}