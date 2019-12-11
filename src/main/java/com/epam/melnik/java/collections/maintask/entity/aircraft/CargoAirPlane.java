package com.epam.melnik.java.collections.maintask.entity.aircraft;

public class CargoAirPlane extends AirCraft {

    private int amountCargoHatch;

    public CargoAirPlane() {
    }

    public CargoAirPlane(int amountPeopleAircraftCrew,
                         int carryingCapacity,
                         int passengerCapacity,
                         int flightRange,
                         int fuelConsumption,
                         int amountCargoHatch) {
        super(amountPeopleAircraftCrew, carryingCapacity, passengerCapacity, flightRange, fuelConsumption);
        this.amountCargoHatch = amountCargoHatch;
    }

    public int getAmountCargoHatch() {
        return amountCargoHatch;
    }

    public void setAmountCargoHatch(int amountCargoHatch) {
        this.amountCargoHatch = amountCargoHatch;
    }
}
