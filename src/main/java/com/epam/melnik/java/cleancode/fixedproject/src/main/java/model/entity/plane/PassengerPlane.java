/*
 * version: 1.1.1
 * made by Dmitry Melnik
 * 20-Dec-2019
 */

package com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane;

import java.util.Objects;

/**
 * The class extends the class com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane.Plane;
 * Represents a description of a passenger aircraft.
 *
 * @author Dmitry Melnik
 * @see Object
 * @see Plane
 */
public class PassengerPlane extends Plane {

    private int passengersCapacity;

    public PassengerPlane() {
    }

    public PassengerPlane(String model,
                          int maxSpeed,
                          int maxFlightDistance,
                          int maxLoadCapacity,
                          int passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    public void setPassengersCapacity(int passengersCapacity) {
        this.passengersCapacity = passengersCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerPlane)) return false;
        if (!super.equals(o)) return false;
        PassengerPlane plane = (PassengerPlane) o;
        return passengersCapacity == plane.passengersCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", passengersCapacity=" + passengersCapacity +
                        '}');
    }
}
