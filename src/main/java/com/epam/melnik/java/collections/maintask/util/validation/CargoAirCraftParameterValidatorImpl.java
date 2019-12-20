/*
 * version: 1.1
 * made by Dmitry Melnik
 * 25-Dec-2019
 */

package com.epam.melnik.java.collections.maintask.util.validation;

/**
 * Implementation interface AirCraftParameterValidator
 *
 * @see com.epam.melnik.java.collections.maintask.model.entity.aircraft.AirCraft
 * @see com.epam.melnik.java.collections.maintask.model.entity.aircraft.CargoAirCraft
 */
public class CargoAirCraftParameterValidatorImpl implements CargoAirCraftParameterValidator {

    public static final int minAmountCargoHatch = 1;
    public static final int maxAmountCargoHatch = 10;

    /**
     * Method checks parameter amountCargoHatch.
     *
     * @param amountCargoHatch
     * @return boolean
     */
    @Override
    public boolean checkAmountCargoHatch(int amountCargoHatch) {

        boolean isAmountCargoHatchValid = false;
        if (amountCargoHatch >= minAmountCargoHatch
                && amountCargoHatch <= maxAmountCargoHatch) {
            isAmountCargoHatchValid = true;
        }
        return isAmountCargoHatchValid;
    }
}
