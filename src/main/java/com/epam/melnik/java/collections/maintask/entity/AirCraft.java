package com.epam.melnik.java.collections.maintask.entity;

abstract public class AirCraft {

    private int amountPeopleAircraftCrew;
    private int carryingCapacity;
    private int passengerCapacity;
    private int flightRange; // дальность полета
    private int fuelConsumption; //поребление топлива

    public AirCraft() {
    }

    public AirCraft(int amountPeopleAircraftCrew,
                    int carryingCapacity,
                    int passengerCapacity,
                    int flightRange,
                    int fuelConsumption) {
        this.amountPeopleAircraftCrew = amountPeopleAircraftCrew;
        this.carryingCapacity = carryingCapacity;
        this.passengerCapacity = passengerCapacity;
        this.flightRange = flightRange;
        this.fuelConsumption = fuelConsumption;
    }

    public int getAmountPeopleAircraftCrew() {
        return amountPeopleAircraftCrew;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public int getFlightRange() {
        return flightRange;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setAmountPeopleAircraftCrew(int amountPeopleAircraftCrew) {
        this.amountPeopleAircraftCrew = amountPeopleAircraftCrew;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public void setFlightRange(int flightRange) {
        this.flightRange = flightRange;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
