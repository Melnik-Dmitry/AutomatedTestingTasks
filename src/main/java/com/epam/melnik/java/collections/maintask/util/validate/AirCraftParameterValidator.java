package com.epam.melnik.java.collections.maintask.util.validate;

import com.epam.melnik.java.collections.maintask.entity.aircraft.AirCraftType;

public interface AirCraftParameterValidator {

    boolean checkAmountPeopleAircraftCrew(int amountPeopleAircraftCrew);

    boolean checkCarryingCapacity(int carryingCapacity, AirCraftType airCraftType);

    boolean checkPassengerCapacity(int passengerCapacity, AirCraftType airCraftType);

    boolean checkFlightRange(int flightRange);

    boolean checkFuelConsumption(int fuelConsumption);
}
