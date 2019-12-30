/*
 * version: 1.1
 * made by Dmitry Melnik
 * 30-Dec-2019
 */

package com.epam.melnik.java.collections.maintask.util.validation;

import com.epam.melnik.java.collections.maintask.model.entity.aircraft.AirCraftType;

/**
 * Interface checks initialization parameters abstract class Aircraft
 */
public interface AirCraftParameterValidator {

    boolean checkAmountPeopleAircraftCrew(int amountPeopleAircraftCrew);

    boolean checkCarryingCapacity(int carryingCapacity, AirCraftType airCraftType);

    boolean checkPassengerCapacity(int passengerCapacity, AirCraftType airCraftType);

    boolean checkFlightRange(int flightRange);

    boolean checkFuelConsumption(int fuelConsumption);
}
