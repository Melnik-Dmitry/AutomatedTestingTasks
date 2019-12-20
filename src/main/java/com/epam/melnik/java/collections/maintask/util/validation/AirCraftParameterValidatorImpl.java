/*
 * version: 1.1
 * made by Dmitry Melnik
 * 25-Dec-2019
 */

package com.epam.melnik.java.collections.maintask.util.validation;

import com.epam.melnik.java.collections.maintask.model.entity.aircraft.AirCraftType;

/**
 * Implementation interface AirCraftParameterValidator
 *
 * @see com.epam.melnik.java.collections.maintask.model.entity.aircraft.AirCraft
 * @see AirCraftType
 */
public class AirCraftParameterValidatorImpl implements AirCraftParameterValidator {

    public static final int MIN_AMOUNT_PEOPLE_AIRCRAFT_CREW = 4;
    public static final int MAX_AMOUNT_PEOPLE_AIRCRAFT_CREW = 6;
    public static final int MIN_FLIGHT_RANGE = 1_000; // км
    public static final int MAX_FLIGHT_RANGE = 6_500;
    public static final int MIN_FUEL_CONSUMPTION = 3_00; //л/100 км
    public static final int MAX_FUEL_CONSUMPTION = 2_500;
    public static final int MIN_CARRYING_CAPACITY_FOR_CARGO_AIR_PLANE = 5_000; //кг
    public static final int MAX_CARRYING_CAPACITY_FOR_CARGO_AIR_PLANE = 50_000;
    public static final int MIN_CARRYING_CAPACITY_FOR_PASSENGER_AIR_PLANE = 1_000; //кг
    public static final int MAX_CARRYING_CAPACITY_FOR_PASSENGER_AIR_PLANE = 20_000;
    public static final int MIN_PASSENGER_CAPACITY_FOR_CARGO_AIR_PLANE = 10;
    public static final int MAX_PASSENGER_CAPACITY_FOR_CARGO_AIR_PLANE = 25;
    public static final int MIN_PASSENGER_CAPACITY_FOR_PASSENGER_AIR_PLANE = 50;
    public static final int MAX_PASSENGER_CAPACITY_FOR_PASSENGER_AIR_PLANE = 300;

    private static final String CARRYING_CAPACITY_TYPE = "carryingCapacity";
    private static final String PASSENGER_CAPACITY_TYPE = "passengerCapacity";

    /**
     * Method checks parameter amountPeopleAircraftCrew.
     *
     * @param amountPeopleAircraftCrew
     * @return boolean
     */
    @Override
    public boolean checkAmountPeopleAircraftCrew(int amountPeopleAircraftCrew) {

        boolean isAmountPeopleaircraftCrewValid = false;
        if (amountPeopleAircraftCrew >= MIN_AMOUNT_PEOPLE_AIRCRAFT_CREW
                && amountPeopleAircraftCrew <= MAX_AMOUNT_PEOPLE_AIRCRAFT_CREW) {
            isAmountPeopleaircraftCrewValid = true;
        }

        return isAmountPeopleaircraftCrewValid;
    }

    /**
     * Method checks parameter carryingCapacity.
     *
     * @param carryingCapacity
     * @param airCraftType
     * @return boolean
     */
    @Override
    public boolean checkCarryingCapacity(int carryingCapacity,
                                         AirCraftType airCraftType) {

        boolean isCarryingCapacityValid =
                checkCapacity(carryingCapacity, CARRYING_CAPACITY_TYPE, airCraftType);
        return isCarryingCapacityValid;
    }

    /**
     * Method checks parameter passengerCapacity
     *
     * @param passengerCapacity
     * @param airCraftType
     * @return boolean
     */
    @Override
    public boolean checkPassengerCapacity(int passengerCapacity,
                                          AirCraftType airCraftType) {

        boolean isPassengerCapacityValid =
                checkCapacity(passengerCapacity, PASSENGER_CAPACITY_TYPE, airCraftType);
        return isPassengerCapacityValid;
    }

    private boolean checkCapacity(int checkedCapacity,
                                  String typeCapacity,
                                  AirCraftType airCraftType) {

        boolean isCapacityValid = false;

        if (airCraftType != null) {
            if (typeCapacity.equals(CARRYING_CAPACITY_TYPE)) {
                if ((airCraftType == AirCraftType.CARGO
                        && checkedCapacity >= MIN_CARRYING_CAPACITY_FOR_CARGO_AIR_PLANE
                        && checkedCapacity <= MAX_CARRYING_CAPACITY_FOR_CARGO_AIR_PLANE)
                        || (airCraftType == AirCraftType.PASSENGER
                        && checkedCapacity >= MIN_CARRYING_CAPACITY_FOR_PASSENGER_AIR_PLANE
                        && checkedCapacity <= MAX_CARRYING_CAPACITY_FOR_PASSENGER_AIR_PLANE)) {
                    isCapacityValid = true;
                }
            } else if (typeCapacity.equals(PASSENGER_CAPACITY_TYPE)) {
                if ((airCraftType == AirCraftType.CARGO
                        && checkedCapacity >= MIN_PASSENGER_CAPACITY_FOR_CARGO_AIR_PLANE
                        && checkedCapacity <= MAX_PASSENGER_CAPACITY_FOR_CARGO_AIR_PLANE)
                        || (airCraftType == AirCraftType.PASSENGER
                        && checkedCapacity >= MIN_PASSENGER_CAPACITY_FOR_PASSENGER_AIR_PLANE
                        && checkedCapacity <= MAX_PASSENGER_CAPACITY_FOR_PASSENGER_AIR_PLANE)) {
                    isCapacityValid = true;
                }
            }
        }

        return isCapacityValid;
    }

    /**
     * Method checks parameter flightRange
     *
     * @param flightRange
     * @return boolean
     */
    @Override
    public boolean checkFlightRange(int flightRange) {

        boolean isFlightRangeValid = false;
        if (flightRange >= MIN_FLIGHT_RANGE && flightRange <= MAX_FLIGHT_RANGE) {
            isFlightRangeValid = true;
        }
        return isFlightRangeValid;
    }

    /**
     * Method checks parameter fuelConsumption
     *
     * @param fuelConsumption
     * @return boolean
     */
    @Override
    public boolean checkFuelConsumption(int fuelConsumption) {

        boolean isFuelConsumptionValid = false;
        if (fuelConsumption >= MIN_FUEL_CONSUMPTION
                && fuelConsumption <= MAX_FUEL_CONSUMPTION) {
            isFuelConsumptionValid = true;
        }
        return isFuelConsumptionValid;
    }
}
