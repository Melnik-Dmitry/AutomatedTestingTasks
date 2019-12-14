/*
 * version: 1.1.1
 * made by Dmitry Melnik
 * 20-Dec-2019
 */

package com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane;

import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.planetype.MilitaryType;

import java.util.Objects;

/**
 * The class extends the class com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane.Plane;
 * Represents a description of a military aircraft.
 *
 * @author Dmitry Melnik
 * @see Object
 * @see Plane
 */
public class MilitaryPlane extends Plane {

    private MilitaryType type;

    public MilitaryPlane() {
    }

    public MilitaryPlane(String model,
                         int maxSpeed,
                         int maxFlightDistance,
                         int maxLoadCapacity,
                         MilitaryType type) {

        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
    }

    public MilitaryType getType() {

        return type;
    }

    public void setType(MilitaryType type) {

        this.type = type;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof MilitaryPlane)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        MilitaryPlane that = (MilitaryPlane) o;
        return getType() == that.getType();
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), type);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + type +
                        '}');
    }
}
