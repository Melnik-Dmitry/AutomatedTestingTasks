/*
 * version: 1.1.1
 * made by Dmitry Melnik
 * 20-Dec-2019
 */

package com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane;

import java.util.Objects;

/**
 * An abstract class describing an aircraft is intended to be extended.
 *
 * @author Dmitry Melnik
 * @see Object
 */
abstract public class Plane {

    private String model;
    private int maxSpeed;
    private int maxFlightDistance;
    private int maxLoadCapacity;

    public Plane() {
    }

    public Plane(String model,
                 int maxSpeed,
                 int maxFlightDistance,
                 int maxLoadCapacity) {

        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getModel() {

        return model;
    }

    public int getMaxSpeed() {

        return maxSpeed;
    }

    public int getMaxFlightDistance() {

        return maxFlightDistance;
    }

    public int getMaxLoadCapacity() {

        return maxLoadCapacity;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {return true;}
        if (!(o instanceof Plane)) {return false;}
        Plane plane = (Plane) o;
        return getMaxSpeed() == plane.getMaxSpeed() &&
                getMaxFlightDistance() == plane.getMaxFlightDistance() &&
                getMaxLoadCapacity() == plane.getMaxLoadCapacity() &&
                getModel().equals(plane.getModel());
    }

    @Override
    public int hashCode() {

        return Objects.hash(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
    }
}
