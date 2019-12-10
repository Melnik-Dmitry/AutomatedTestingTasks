package com.epam.melnik.java.collections.maintask.util.validate;

public interface AirCraftParameterValidator {

    boolean checkAmountPeopleAircraftCrew(int amountPeopleAircraftCrew);

    boolean checkCarryingCapacity(int carryingCapacity);

    boolean checkPassengerCapacity(int passengerCapacity);

    boolean checkFlightRange(int flightRange);

    boolean checkFuelConsumption(int fuelConsumption);
}
