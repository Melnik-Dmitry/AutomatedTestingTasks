package com.epam.melnik.java.collections.maintask.util.validate;

import com.epam.melnik.java.collections.maintask.entity.AirCraftType;

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
    public static final int MAX_PASSENGER_CAPACITY_FOR_PASSENGER_AIR_PLANE = 500;

    private AirCraftType airCraftType;

    public AirCraftParameterValidatorImpl(AirCraftType airCraftType) {
        this.airCraftType = airCraftType;
    }

    @Override
    public boolean checkAmountPeopleAircraftCrew(int amountPeopleAircraftCrew) {
        boolean result = false;

        if (amountPeopleAircraftCrew >= MIN_AMOUNT_PEOPLE_AIRCRAFT_CREW
                && amountPeopleAircraftCrew <= MAX_AMOUNT_PEOPLE_AIRCRAFT_CREW) {
            result = true;
        }

        return result;
    }

    @Override
    public boolean checkCarryingCapacity(int carryingCapacity) {
        boolean result = false;
        if (airCraftType != null) {
            if ((airCraftType == AirCraftType.CARGO
                    && carryingCapacity >= MIN_CARRYING_CAPACITY_FOR_CARGO_AIR_PLANE
                    && carryingCapacity <= MAX_CARRYING_CAPACITY_FOR_CARGO_AIR_PLANE)
                    || (airCraftType == AirCraftType.PASSENGER
                    && carryingCapacity >= MIN_CARRYING_CAPACITY_FOR_PASSENGER_AIR_PLANE
                    && carryingCapacity <= MAX_CARRYING_CAPACITY_FOR_PASSENGER_AIR_PLANE)) {
                result = true;
            }
        }

        return result;
    }

    @Override
    public boolean checkPassengerCapacity(int passengerCapacity) {
        boolean result = false;
        if (airCraftType != null) {
            if ((airCraftType == AirCraftType.CARGO
                    && passengerCapacity >= MIN_PASSENGER_CAPACITY_FOR_CARGO_AIR_PLANE
                    && passengerCapacity <= MAX_PASSENGER_CAPACITY_FOR_CARGO_AIR_PLANE)
                    || (airCraftType == AirCraftType.PASSENGER
                    && passengerCapacity >= MIN_PASSENGER_CAPACITY_FOR_PASSENGER_AIR_PLANE
                    && passengerCapacity <= MAX_PASSENGER_CAPACITY_FOR_PASSENGER_AIR_PLANE)) {
                result = true;
            }
        }

        return result;
    }

    @Override
    public boolean checkFlightRange(int flightRange) {
        boolean result = false;
        if (flightRange >= MIN_FLIGHT_RANGE && flightRange <= MAX_FLIGHT_RANGE) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean checkFuelConsumption(int fuelConsumption) {
        boolean result = false;
        if (fuelConsumption >= MIN_FUEL_CONSUMPTION && fuelConsumption <= MAX_FUEL_CONSUMPTION) {
            result = true;
        }
        return result;
    }
}
