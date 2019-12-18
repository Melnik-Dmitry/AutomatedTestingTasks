package com.epam.melnik.java.collections.maintask.util.parameterinit;

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
