package com.epam.melnik.java.collections.maintask.util.entitycreate;

import com.epam.melnik.java.collections.maintask.entity.aircraft.AirCraft;
import com.epam.melnik.java.collections.maintask.entity.aircraft.AirCraftType;
import com.epam.melnik.java.collections.maintask.entity.aircraft.CargoAirPlane;
import com.epam.melnik.java.collections.maintask.util.convert.AirPlaneInitParameterConvector;
import com.epam.melnik.java.collections.maintask.util.parameterinit.FileParametersReader;
import com.epam.melnik.java.collections.maintask.util.parameterinit.ReadedParameters;
import com.epam.melnik.java.collections.maintask.util.validate.AirCraftParameterValidator;
import com.epam.melnik.java.collections.maintask.util.validate.AirCraftParameterValidatorImpl;
import com.epam.melnik.java.collections.maintask.util.validate.CargoAirCraftParameterValidator;
import com.epam.melnik.java.collections.maintask.util.validate.CargoAirCraftParameterValidatorImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CargoAirPlaneCreator {

    private static final AirCraftParameterValidator airCraftParameterValidator =
            new AirCraftParameterValidatorImpl(AirCraftType.CARGO);
    private static final CargoAirCraftParameterValidator cargoAirCraftParameterValidator =
            new CargoAirCraftParameterValidatorImpl();

    public static AirCraft[] createAirPlaneFromFile(String fileParameters) {

        FileParametersReader reader = new FileParametersReader();

        String[] amountPeopleAircraftCrewParams =
                reader.getInitParams(fileParameters, ReadedParameters.AMOUNT_PEOPLE_AIRCRAFT_CREW);
        String[] carryingCapacityParams =
                reader.getInitParams(fileParameters, ReadedParameters.CARRYING_CAPACITY);
        String[] passengerCapacityParams =
                reader.getInitParams(fileParameters, ReadedParameters.PASSENGER_CAPACITY);
        String[] flightRangeParams =
                reader.getInitParams(fileParameters, ReadedParameters.FLIGHT_RANGE);
        String[] fuelConsumptionParams =
                reader.getInitParams(fileParameters, ReadedParameters.FUEL_CONSUMPTION);
        String[] amountCargoHatchParams =
                reader.getInitParams(fileParameters, ReadedParameters.AMOUNT_CARGO_HATCH);

        List<Integer> arraysLength = new ArrayList<>();
        arraysLength.add(amountPeopleAircraftCrewParams.length);
        arraysLength.add(carryingCapacityParams.length);
        arraysLength.add(passengerCapacityParams.length);
        arraysLength.add(flightRangeParams.length);
        arraysLength.add(fuelConsumptionParams.length);
        arraysLength.add(amountCargoHatchParams.length);

        int minArrayLength = Collections.min(arraysLength);
        AirCraft[] cargoAirCrafts = new AirCraft[minArrayLength];

        for (int i = 0; i < minArrayLength; i++) {
            int amountPeopleAircraftCrew = (int) AirPlaneInitParameterConvector
                    .convertParameter(amountPeopleAircraftCrewParams[i], ReadedParameters.AMOUNT_PEOPLE_AIRCRAFT_CREW);
            int carryingCapacity = (int) AirPlaneInitParameterConvector
                    .convertParameter(carryingCapacityParams[i], ReadedParameters.CARRYING_CAPACITY);
            int passengerCapacity = (int) AirPlaneInitParameterConvector
                    .convertParameter(passengerCapacityParams[i], ReadedParameters.PASSENGER_CAPACITY);
            int flightRange = (int) AirPlaneInitParameterConvector
                    .convertParameter(flightRangeParams[i], ReadedParameters.FLIGHT_RANGE);
            int fuelConsumption = (int) AirPlaneInitParameterConvector
                    .convertParameter(fuelConsumptionParams[i], ReadedParameters.FUEL_CONSUMPTION);
            int amountCargoHatch = (int) AirPlaneInitParameterConvector
                    .convertParameter(amountCargoHatchParams[i], ReadedParameters.AMOUNT_CARGO_HATCH);

            AirCraft craft = CargoAirPlaneCreator.createAirPlane(
                    amountPeopleAircraftCrew,
                    carryingCapacity,
                    passengerCapacity,
                    flightRange,
                    fuelConsumption,
                    amountCargoHatch);
            cargoAirCrafts[i] = craft;
        }

        return cargoAirCrafts;
    }

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
