package com.epam.melnik.java.collections.maintask.util.airplanefactory;

import com.epam.melnik.java.collections.maintask.entity.AirCraft;
import com.epam.melnik.java.collections.maintask.entity.AirCraftType;
import com.epam.melnik.java.collections.maintask.entity.CargoAirPlane;
import com.epam.melnik.java.collections.maintask.util.validate.AirCraftParameterValidator;
import com.epam.melnik.java.collections.maintask.util.validate.AirCraftParameterValidatorImpl;
import com.epam.melnik.java.collections.maintask.util.validate.CargoAirCraftParameterValidator;
import com.epam.melnik.java.collections.maintask.util.validate.CargoAirCraftParameterValidatorImpl;

public class CargoAirPlaneCreator {

    private static final AirCraftParameterValidator airCraftParameterValidator =
            new AirCraftParameterValidatorImpl(AirCraftType.CARGO);
    private static final CargoAirCraftParameterValidator cargoAirCraftParameterValidator =
            new CargoAirCraftParameterValidatorImpl();


    public static AirCraft createAirPlane(int amountPeopleAircraftCrew,
                                          int carryingCapacity,
                                          int passengerCapacity,
                                          int flightRange,
                                          int fuelConsumption,
                                          int amountCargoHatch) {

        CargoAirPlane cargoAirCraft = new CargoAirPlane();

        if (airCraftParameterValidator.checkAmountPeopleAircraftCrew(amountPeopleAircraftCrew)
                && airCraftParameterValidator.checkCarryingCapacity(carryingCapacity)
                && airCraftParameterValidator.checkPassengerCapacity(passengerCapacity)
                && airCraftParameterValidator.checkFlightRange(flightRange)
                && airCraftParameterValidator.checkFuelConsumption(fuelConsumption)
                && cargoAirCraftParameterValidator.checkAmountCargoHatch(amountCargoHatch)) {

            cargoAirCraft.setAmountPeopleAircraftCrew(amountPeopleAircraftCrew);
            cargoAirCraft.setCarryingCapacity(carryingCapacity);
            cargoAirCraft.setPassengerCapacity(passengerCapacity);
            cargoAirCraft.setFlightRange(flightRange);
            cargoAirCraft.setFuelConsumption(fuelConsumption);
            cargoAirCraft.setAmountCargoHatch(amountCargoHatch);
        }

        return cargoAirCraft;
    }
}
