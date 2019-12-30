/*
 * version: 1.1
 * made by Dmitry Melnik
 * 30-Dec-2019
 */

package com.epam.melnik.java.collections.maintask.model.entity.aircraft;

import java.util.Objects;

/**
 * Class describes entity PassengerAirCraft
 *
 * @author Dmitry Melnik
 * @see Object
 */
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

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof PassengerAirCraft)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        PassengerAirCraft that = (PassengerAirCraft) o;
        return getAmountPorthole() == that.getAmountPorthole() &&
                isThereBusinessCLass() == that.isThereBusinessCLass();
    }

    @Override
    public int hashCode() {

        return Objects.hash
                (super.hashCode(), getAmountPorthole(), isThereBusinessCLass());
    }

    @Override
    public String toString() {

        return "PassengerAirCraft{" +
                "amountPorthole=" + amountPorthole +
                ", isThereBusinessCLass=" + isThereBusinessCLass +
                ", " + super.toString();
    }
}
