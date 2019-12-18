package com.epam.melnik.java.collections.maintask.util.entitycreate;

import com.epam.melnik.java.collections.maintask.entity.aircraft.AirCraft;
import com.epam.melnik.java.collections.maintask.entity.aircraft.AirCraftType;
import com.epam.melnik.java.collections.maintask.entity.aircraft.CargoAirCraft;
import com.epam.melnik.java.collections.maintask.entity.aircraft.PassengerAirCraft;
import com.epam.melnik.java.collections.maintask.util.convert.AirCraftInitParameterConvector;
import com.epam.melnik.java.collections.maintask.util.parameterinit.FileParametersReader;
import com.epam.melnik.java.collections.maintask.util.validate.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.epam.melnik.java.collections.maintask.util.parameterinit.ReadParameters.*;

public class AirCraftCreator {

    private static final AirCraftParameterValidator airCraftParameterValidator =
            new AirCraftParameterValidatorImpl();
    private static final CargoAirCraftParameterValidator cargoAirCraftParameterValidator =
            new CargoAirCraftParameterValidatorImpl();
    private static final PassengerAirCraftParameterValidator passengerAirCraftParameterValidator =
            new PassengerAirCraftParameterValidatorImpl();
    private static final FileParametersReader reader = new FileParametersReader();

    public static AirCraft[] createAirPlanesFromFile(String fileParameters, AirCraftType airCraftType) {

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
        String[] amountCargoHatchParams = new String[0];
        String[] amountPortholeParams = new String[0];
        String[] isThereBusinessCLassParams = new String[0];
        int minArrayLength = 0;

        if (airCraftType == AirCraftType.CARGO) {
            amountCargoHatchParams
                    = reader.getInitParams(fileParameters, AMOUNT_CARGO_HATCH);

            minArrayLength = getMinArraysLength(
                    amountPeopleAircraftCrewParams,
                    carryingCapacityParams,
                    passengerCapacityParams,
                    flightRangeParams,
                    fuelConsumptionParams,
                    amountCargoHatchParams);
        } else if (airCraftType == AirCraftType.PASSENGER) {
            amountPortholeParams =
                    reader.getInitParams(fileParameters, AMOUNT_PORTHOLE);
            isThereBusinessCLassParams =
                    reader.getInitParams(fileParameters, IS_THERE_BUSINESS_CLASS);
            minArrayLength = getMinArraysLength(
                    amountPeopleAircraftCrewParams,
                    carryingCapacityParams,
                    passengerCapacityParams,
                    flightRangeParams,
                    fuelConsumptionParams,
                    amountPortholeParams,
                    isThereBusinessCLassParams);
        }

        AirCraft[] cargoAirCrafts = new AirCraft[minArrayLength];

        for (int i = 0; i < minArrayLength; i++) {
            int amountPeopleAircraftCrew = (int) AirCraftInitParameterConvector
                    .convertParameter(amountPeopleAircraftCrewParams[i], AMOUNT_PEOPLE_AIRCRAFT_CREW);
            int carryingCapacity = (int) AirCraftInitParameterConvector
                    .convertParameter(carryingCapacityParams[i], CARRYING_CAPACITY);
            int passengerCapacity = (int) AirCraftInitParameterConvector
                    .convertParameter(passengerCapacityParams[i], PASSENGER_CAPACITY);
            int flightRange = (int) AirCraftInitParameterConvector
                    .convertParameter(flightRangeParams[i], FLIGHT_RANGE);
            int fuelConsumption = (int) AirCraftInitParameterConvector
                    .convertParameter(fuelConsumptionParams[i], FUEL_CONSUMPTION);

            AirCraft craft = null;

            if (airCraftType == AirCraftType.CARGO) {
                int amountCargoHatch = (int) AirCraftInitParameterConvector
                        .convertParameter(amountCargoHatchParams[i], AMOUNT_CARGO_HATCH);

                craft = createCargoAirCraft(
                        amountPeopleAircraftCrew,
                        carryingCapacity,
                        passengerCapacity,
                        flightRange,
                        fuelConsumption,
                        amountCargoHatch);
                craft.setAirCraftType(AirCraftType.CARGO);
                cargoAirCrafts[i] = craft;

            } else if (airCraftType == AirCraftType.PASSENGER) {
                int amountPorthole = (int) AirCraftInitParameterConvector
                        .convertParameter(amountPortholeParams[i], AMOUNT_CARGO_HATCH);
                boolean isThereBusinessCLass = (boolean) AirCraftInitParameterConvector
                        .convertParameter(isThereBusinessCLassParams[i], IS_THERE_BUSINESS_CLASS);

                craft = createPassengerAirCraft(
                        amountPeopleAircraftCrew,
                        carryingCapacity,
                        passengerCapacity,
                        flightRange,
                        fuelConsumption,
                        amountPorthole,
                        isThereBusinessCLass);
                craft.setAirCraftType(AirCraftType.PASSENGER);
            }

            cargoAirCrafts[i] = craft;
        }

        return cargoAirCrafts;
    }

    public static AirCraft createCargoAirCraft(int amountPeopleAircraftCrew,
                                               int carryingCapacity,
                                               int passengerCapacity,
                                               int flightRange,
                                               int fuelConsumption,
                                               int amountCargoHatch) {

        CargoAirCraft cargoAirCraft = new CargoAirCraft();

        if (airCraftParameterValidator.checkAmountPeopleAircraftCrew(amountPeopleAircraftCrew)
                && airCraftParameterValidator
                .checkCarryingCapacity(carryingCapacity, AirCraftType.CARGO)
                && airCraftParameterValidator
                .checkPassengerCapacity(passengerCapacity, AirCraftType.CARGO)
                && airCraftParameterValidator.checkFlightRange(flightRange)
                && airCraftParameterValidator.checkFuelConsumption(fuelConsumption)
                && cargoAirCraftParameterValidator.checkAmountCargoHatch(amountCargoHatch)) {

            cargoAirCraft.setAmountPeopleAircraftCrew(amountPeopleAircraftCrew);
            cargoAirCraft.setCarryingCapacity(carryingCapacity);
            cargoAirCraft.setPassengerCapacity(passengerCapacity);
            cargoAirCraft.setFlightRange(flightRange);
            cargoAirCraft.setFuelConsumption(fuelConsumption);
            cargoAirCraft.setAmountCargoHatch(amountCargoHatch);
            cargoAirCraft.setAirCraftType(AirCraftType.CARGO);
        }

        return cargoAirCraft;
    }

    public static AirCraft createPassengerAirCraft(int amountPeopleAircraftCrew,
                                                   int carryingCapacity,
                                                   int passengerCapacity,
                                                   int flightRange,
                                                   int fuelConsumption,
                                                   int amountPorthole,
                                                   boolean isThereBusinessCLass) {

        PassengerAirCraft passengerAirCraft = new PassengerAirCraft();

        if (airCraftParameterValidator.checkAmountPeopleAircraftCrew(amountPeopleAircraftCrew)
                && airCraftParameterValidator
                .checkCarryingCapacity(carryingCapacity, AirCraftType.PASSENGER)
                && airCraftParameterValidator
                .checkPassengerCapacity(passengerCapacity, AirCraftType.PASSENGER)
                && airCraftParameterValidator.checkFlightRange(flightRange)
                && airCraftParameterValidator.checkFuelConsumption(fuelConsumption)
                && passengerAirCraftParameterValidator.checkAmountPorthole(amountPorthole)) {

            passengerAirCraft.setAmountPeopleAircraftCrew(amountPeopleAircraftCrew);
            passengerAirCraft.setCarryingCapacity(carryingCapacity);
            passengerAirCraft.setPassengerCapacity(passengerCapacity);
            passengerAirCraft.setFlightRange(flightRange);
            passengerAirCraft.setFuelConsumption(fuelConsumption);
            passengerAirCraft.setAmountPorthole(amountPorthole);
            passengerAirCraft.setThereBusinessCLass(isThereBusinessCLass);
            passengerAirCraft.setAirCraftType(AirCraftType.PASSENGER);
        }

        return passengerAirCraft;
    }

    private static int getMinArraysLength(String[]... arrays) {

        List<Integer> arraysLength = new ArrayList<>(arrays.length);
        for (int i = 0; i < arrays.length; i++) {
            arraysLength.add(arrays[i].length);
        }

        int minArrayLength = Collections.min(arraysLength);
        return minArrayLength;
    }
}