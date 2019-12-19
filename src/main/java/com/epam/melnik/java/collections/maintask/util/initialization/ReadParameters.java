/*
 * version: 1.1
 * made by Dmitry Melnik
 * 25-Dec-2019
 */

package com.epam.melnik.java.collections.maintask.util.initialization;

/**
 * ENUM for parameter's names were readed from file
 *
 * @author Dmitry Melnik
 * @see Enum
 */
public enum ReadParameters {

    AMOUNT_PEOPLE_AIRCRAFT_CREW("amountPeopleAircraftCrew"),
    CARRYING_CAPACITY("carryingCapacity"),
    PASSENGER_CAPACITY("passengerCapacity"),
    FLIGHT_RANGE("flightRange"),
    FUEL_CONSUMPTION("fuelConsumption"),
    AMOUNT_CARGO_HATCH("amountCargoHatch"),
    AMOUNT_PORTHOLE("amountPorthole"),
    IS_THERE_BUSINESS_CLASS("isThereBusinessCLass");

    private String parameterName;

    ReadParameters(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterName() {
        return parameterName;
    }
}
