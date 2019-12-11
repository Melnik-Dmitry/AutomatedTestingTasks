package com.epam.melnik.java.collections.maintask.util.entitycreate;

import com.epam.melnik.java.collections.maintask.entity.aircraft.AirCraft;
import com.epam.melnik.java.collections.maintask.entity.aircraft.AirCraftType;
import com.epam.melnik.java.collections.maintask.entity.aircraft.PassengerAirPlane;
import com.epam.melnik.java.collections.maintask.util.convert.AirPlaneInitParameterConvector;
import com.epam.melnik.java.collections.maintask.util.parameterinit.FileParametersReader;
import com.epam.melnik.java.collections.maintask.util.validate.AirCraftParameterValidator;
import com.epam.melnik.java.collections.maintask.util.validate.AirCraftParameterValidatorImpl;
import com.epam.melnik.java.collections.maintask.util.validate.PassengerAirCraftParameterValidator;
import com.epam.melnik.java.collections.maintask.util.validate.PassengerAirCraftParameterValidatorImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.epam.melnik.java.collections.maintask.util.parameterinit.ReadedParameters.*;

public class PassengerAirPlaneCreator {

    private static final AirCraftParameterValidator airCraftParameterValidator =
            new AirCraftParameterValidatorImpl(AirCraftType.PASSENGER);
    private static final PassengerAirCraftParameterValidator passengerAirCraftParameterValidator =
            new PassengerAirCraftParameterValidatorImpl();

    public static AirCraft[] createAirPlaneFromFile(String fileParameters) {

        FileParametersReader reader = new FileParametersReader();

        String[] amountPeopleAircraftCrewParams =
                reader.getInitParams(fileParameters, AMOUNT_PEOPLE_AIRCRAFT_CREW);
        String[] carryingCapacityParams =
                reader.getInitParams(fileParameters, CARRYING_CAPACITY);
        String[] passengerCapacityParams =
                reader.getInitParams(fileParameters, PASSENGER_CAPACITY);
        String[] flightRangeParams =
                reader.getInitParams(fileParameters, FLIGHT_RANGE);
        String[] fuelConsumptionParams =
                reader.getInitParams(fileParameters, FUEL_CONSUMPTION);
        String[] amountPortholeParams =
                reader.getInitParams(fileParameters, AMOUNT_PORTHOLE);
        String[] isThereBusinessCLassParams =
                reader.getInitParams(fileParameters, IS_THERE_BUSINESS_CLASS);

        List<Integer> arraysLength = new ArrayList<>();
        arraysLength.add(amountPeopleAircraftCrewParams.length);
        arraysLength.add(carryingCapacityParams.length);
        arraysLength.add(passengerCapacityParams.length);
        arraysLength.add(flightRangeParams.length);
        arraysLength.add(fuelConsumptionParams.length);
        arraysLength.add(amountPortholeParams.length);
        arraysLength.add(isThereBusinessCLassParams.length);

        int minArrayLength = Collections.min(arraysLength);
        AirCraft[] cargoAirCrafts = new AirCraft[minArrayLength];

        for (int i = 0; i < minArrayLength; i++) {
            int amountPeopleAircraftCrew = (int) AirPlaneInitParameterConvector
                    .convertParameter(amountPeopleAircraftCrewParams[i], AMOUNT_PEOPLE_AIRCRAFT_CREW);
            int carryingCapacity = (int) AirPlaneInitParameterConvector
                    .convertParameter(carryingCapacityParams[i], CARRYING_CAPACITY);
            int passengerCapacity = (int) AirPlaneInitParameterConvector
                    .convertParameter(passengerCapacityParams[i], PASSENGER_CAPACITY);
            int flightRange = (int) AirPlaneInitParameterConvector
                    .convertParameter(flightRangeParams[i], FLIGHT_RANGE);
            int fuelConsumption = (int) AirPlaneInitParameterConvector
                    .convertParameter(fuelConsumptionParams[i], FUEL_CONSUMPTION);
            int amountPorthole = (int) AirPlaneInitParameterConvector
                    .convertParameter(amountPortholeParams[i], AMOUNT_CARGO_HATCH);
            boolean isThereBusinessCLass = (boolean) AirPlaneInitParameterConvector
                    .convertParameter(isThereBusinessCLassParams[i], IS_THERE_BUSINESS_CLASS);

            AirCraft craft = createAirCraft(
                    amountPeopleAircraftCrew,
                    carryingCapacity,
                    passengerCapacity,
                    flightRange,
                    fuelConsumption,
                    amountPorthole,
                    isThereBusinessCLass);
            cargoAirCrafts[i] = craft;
        }

        return cargoAirCrafts;
    }

    public static AirCraft createAirCraft(int amountPeopleAircraftCrew,
                                          int carryingCapacity,
                                          int passengerCapacity,
                                          int flightRange,
                                          int fuelConsumption,
                                          int amountPorthole,
                                          boolean isThereBusinessCLass) {

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
            passengerAirPlane.setThereBusinessCLass(isThereBusinessCLass);
        }

        return passengerAirPlane;
    }
}
