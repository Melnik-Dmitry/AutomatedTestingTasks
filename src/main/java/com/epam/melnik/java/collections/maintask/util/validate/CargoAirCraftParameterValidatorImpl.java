package com.epam.melnik.java.collections.maintask.util.validate;

public class CargoAirCraftParameterValidatorImpl implements CargoAirCraftParameterValidator {

    public static final int minAmountCargoHatch = 1;
    public static final int maxAmountCargoHatch = 10;

    @Override
    public boolean checkAmountCargoHatch(int amountCargoHatch) {
        boolean result = false;
        if (amountCargoHatch >= minAmountCargoHatch && amountCargoHatch <= maxAmountCargoHatch) {
            result = true;
        }
        return result;
    }
}
