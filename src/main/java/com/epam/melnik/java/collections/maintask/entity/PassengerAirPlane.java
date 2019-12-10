package com.epam.melnik.java.collections.maintask.entity;

public class PassengerAirPlane extends AirCraft {

    private int amountPorthole;
    boolean isThereBusinessCLass;

    public PassengerAirPlane() {
    }

    public PassengerAirPlane(int amountPeopleAircraftCrew,
                             int carryingCapacity,
                             int passengerCapacity,
                             int flightRange,
                             int fuelConsumption,
                             int amountPorthole,
                             boolean isThereBusinessCLass) {
        super(amountPeopleAircraftCrew, carryingCapacity, passengerCapacity, flightRange, fuelConsumption);
        this.amountPorthole = amountPorthole;
        this.isThereBusinessCLass = isThereBusinessCLass;
    }

    public int getAmountPorthole() {
        return amountPorthole;
    }

    public boolean isThereBusinessCLass() {
        return isThereBusinessCLass;
    }

    public void setAmountPorthole(int amountPorthole) {
        this.amountPorthole = amountPorthole;
    }

    public void setThereBusinessCLass(boolean thereBusinessCLass) {
        isThereBusinessCLass = thereBusinessCLass;
    }
}
