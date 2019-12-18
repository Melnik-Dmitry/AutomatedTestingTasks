/*
 * version: 1.1
 * made by Dmitry Melnik
 * 25-Dec-2019
 */

package com.epam.melnik.java.collections.maintask.entity.aircraft;

import java.util.Objects;

/**
 * Abstract class describing abstract entity AirCraft
 *
 * @author Dmitry Melnik
 * @see Object
 */
abstract public class AirCraft {

    private int amountPeopleAircraftCrew;
    private int carryingCapacity;
    private int passengerCapacity;
    private int flightRange; // дальность полета
    private int fuelConsumption; //поребление топлива
    private AirCraftType airCraftType;

    public AirCraft() {
    }

    public AirCraft(int amountPeopleAircraftCrew,
                    int carryingCapacity,
                    int passengerCapacity,
                    int flightRange,
                    int fuelConsumption,
                    AirCraftType airCraftType) {

        this.amountPeopleAircraftCrew = amountPeopleAircraftCrew;
        this.carryingCapacity = carryingCapacity;
        this.passengerCapacity = passengerCapacity;
        this.flightRange = flightRange;
        this.fuelConsumption = fuelConsumption;
        this.airCraftType = airCraftType;
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

    public AirCraftType getAirCraftType() {

        return airCraftType;
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

    public void setAirCraftType(AirCraftType airCraftType) {

        this.airCraftType = airCraftType;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof AirCraft)) {
            return false;
        }
        AirCraft airCraft = (AirCraft) o;
        return getAmountPeopleAircraftCrew() == airCraft.getAmountPeopleAircraftCrew() &&
                getCarryingCapacity() == airCraft.getCarryingCapacity() &&
                getPassengerCapacity() == airCraft.getPassengerCapacity() &&
                getFlightRange() == airCraft.getFlightRange() &&
                getFuelConsumption() == airCraft.getFuelConsumption() &&
                getAirCraftType() == airCraft.getAirCraftType();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getAmountPeopleAircraftCrew(),
                getCarryingCapacity(), getPassengerCapacity(),
                getFlightRange(), getFuelConsumption(), getAirCraftType());
    }

    @Override
    public String toString() {

        return "AirCraft{" +
                "amountPeopleAircraftCrew=" + amountPeopleAircraftCrew +
                ", carryingCapacity=" + carryingCapacity +
                ", passengerCapacity=" + passengerCapacity +
                ", flightRange=" + flightRange +
                ", fuelConsumption=" + fuelConsumption +
                ", airCraftType=" + airCraftType +
                '}';
    }
}
