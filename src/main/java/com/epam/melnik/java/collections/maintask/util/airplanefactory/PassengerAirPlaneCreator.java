package com.epam.melnik.java.collections.maintask.util.airplanefactory;

import com.epam.melnik.java.collections.maintask.entity.AirCraft;
import com.epam.melnik.java.collections.maintask.entity.AirCraftType;
import com.epam.melnik.java.collections.maintask.entity.PassengerAirPlane;
import com.epam.melnik.java.collections.maintask.util.validate.AirCraftParameterValidator;
import com.epam.melnik.java.collections.maintask.util.validate.AirCraftParameterValidatorImpl;
import com.epam.melnik.java.collections.maintask.util.validate.PassengerAirCraftParameterValidator;
import com.epam.melnik.java.collections.maintask.util.validate.PassengerAirCraftParameterValidatorImpl;

public class PassengerAirPlaneCreator {

    private static final AirCraftParameterValidator airCraftParameterValidator =
            new AirCraftParameterValidatorImpl(AirCraftType.PASSENGER);
    private static final PassengerAirCraftParameterValidator passengerAirCraftParameterValidator =
            new PassengerAirCraftParameterValidatorImpl();

    public static AirCraft createAirCraft(int amountPeopleAircraftCrew,
                                          int carryingCapacity,
                                          int passengerCapacity,
                                          int flightRange,
                                          int fuelConsumption,
                                          int amountPorthole) {

        PassengerAirPlane passengerAirPlane = new PassengerAirPlane();

        if (airCraftParameterValidator.checkAmountPeopleAircraftCrew(amountPeopleAircraftCrew)
                && airCraftParameterValidator.checkCarryingCapacity(carryingCapacity)
                && airCraftParameterValidator.checkPassengerCapacity(passengerCapacity)
                && airCraftParameterValidator.checkFlightRange(flightRange)
                && airCraftParameterValidator.checkFuelConsumption(fuelConsumption)
                && passengerAirCraftParameterValidator.checkAmountPorthole(amountPorthole)) {

            passengerAirPlane.setAmountPeopleAircraftCrew(amountPeopleAircraftCrew);
            passengerAirPlane.setCarryingCapacity(carryingCapacity);
            passengerAirPlane.setPassengerCapacity(passengerCapacity);
            passengerAirPlane.setFlightRange(flightRange);
            passengerAirPlane.setFuelConsumption(fuelConsumption);
            passengerAirPlane.setAmountPorthole(amountPorthole);
        }


        return passengerAirPlane;
    }

}
