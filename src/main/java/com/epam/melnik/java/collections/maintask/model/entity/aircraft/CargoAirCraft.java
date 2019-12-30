/*
 * version: 1.1
 * made by Dmitry Melnik
 * 30-Dec-2019
 */

package com.epam.melnik.java.collections.maintask.model.entity.aircraft;

import java.util.Objects;

/**
 * Class describes entity CargoAirCraft
 *
 * @author Dmitry Melnik
 * @see Object
 */
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

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof CargoAirCraft)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        CargoAirCraft that = (CargoAirCraft) o;
        return getAmountCargoHatch() == that.getAmountCargoHatch();
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getAmountCargoHatch());
    }

    @Override
    public String toString() {

        return "CargoAirCraft{" +
                "amountCargoHatch=" + amountCargoHatch
                + ", " + super.toString();
    }
}
