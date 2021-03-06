/*
 * version: 1.1
 * made by Dmitry Melnik
 * 30-Dec-2019
 */

package com.epam.melnik.java.collections.maintask.util.validation;

/**
 * Implementation interface AirCraftParameterValidator
 *
 * @see com.epam.melnik.java.collections.maintask.model.entity.aircraft.AirCraft
 * @see com.epam.melnik.java.collections.maintask.model.entity.aircraft.PassengerAirCraft
 */
public class PassengerAirCraftParameterValidatorImpl implements PassengerAirCraftParameterValidator {

    public static final int minAmountPorthole = 10;
    public static final int maxAmountPorthole = 50;

    /**
     * Method checks parameter amountPorthole.
     *
     * @param amountPorthole
     * @return boolean
     */
    @Override
    public boolean checkAmountPorthole(int amountPorthole) {

        boolean isAmountPortholeValid = false;
        if (amountPorthole >= minAmountPorthole
                && amountPorthole <= maxAmountPorthole) {
            isAmountPortholeValid = true;
        }
        return isAmountPortholeValid;
    }
}
