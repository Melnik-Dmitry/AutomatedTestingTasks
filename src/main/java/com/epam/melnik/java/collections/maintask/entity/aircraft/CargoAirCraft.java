/*
 * version: 1.1
 * made by Dmitry Melnik
 * 25-Dec-2019
 */

package com.epam.melnik.java.collections.maintask.entity.aircraft;

public class CargoAirCraft extends AirCraft {

    private int amountCargoHatch;

    public CargoAirCraft() {
    }

    public CargoAirCraft(int amountPeopleAircraftCrew,
                         int carryingCapacity,
                         int passengerCapacity,
                         int flightRange,
                         int fuelConsumption,
                         int amountCargoHatch,
                         AirCraftType airCraftType) {

        super(amountPeopleAircraftCrew,
                carryingCapacity,
                passengerCapacity,
                flightRange,
                fuelConsumption,
                airCraftType);
        this.amountCargoHatch = amountCargoHatch;
    }

    public int getAmountCargoHatch() {

        return amountCargoHatch;
    }

    public void setAmountCargoHatch(int amountCargoHatch) {

        this.amountCargoHatch = amountCargoHatch;
    }
}
