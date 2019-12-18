/*
 * version: 1.1
 * made by Dmitry Melnik
 * 25-Dec-2019
 */

package com.epam.melnik.java.collections.maintask.entity.aircraft;

public class PassengerAirCraft extends AirCraft {

    private int amountPorthole;
    boolean isThereBusinessCLass;

    public PassengerAirCraft() {
    }

    public PassengerAirCraft(int amountPeopleAircraftCrew,
                             int carryingCapacity,
                             int passengerCapacity,
                             int flightRange,
                             int fuelConsumption,
                             int amountPorthole,
                             AirCraftType airCraftType,
                             boolean isThereBusinessCLass) {

        super(amountPeopleAircraftCrew, carryingCapacity,
                passengerCapacity, flightRange,
                fuelConsumption, airCraftType);
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
