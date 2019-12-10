package com.epam.melnik.java.collections.maintask.util.validate;

public class PassengerAirCraftParameterValidatorImpl implements PassengerAirCraftParameterValidator {

    public static final int minAmountPorthole = 10;
    public static final int maxAmountPorthole = 50;

    @Override
    public boolean checkAmountPorthole(int amountPorthole) {
        boolean result = false;
        if (amountPorthole >= minAmountPorthole && amountPorthole <= maxAmountPorthole) {
            result = true;
        }
        return result;
    }
}
