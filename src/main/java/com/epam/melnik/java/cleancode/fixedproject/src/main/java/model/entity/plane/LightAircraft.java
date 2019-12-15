/*
 * version: 1.1.1
 * made by Dmitry Melnik
 * 20-Dec-2019
 */

package com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane;

import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.planetype.LightAircraftType;

import java.util.Objects;

/**
 * The class extends the class com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane.Plane;
 * Represents a description of a light aircraft.
 *
 * @author Dmitry Melnik
 * @see Object
 * @see Plane
 */
public class LightAircraft extends Plane {

    private LightAircraftType lightAircraftType;

    public LightAircraft() {
    }

    public LightAircraft(String model,
                         int maxSpeed,
                         int maxFlightDistance,
                         int maxLoadCapacity,
                         LightAircraftType lightAircraftType) {

        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.lightAircraftType = lightAircraftType;
    }

    public LightAircraftType getLightAircraftType() {

        return lightAircraftType;
    }

    public void setLightAircraftType(LightAircraftType lightAircraftType) {

        this.lightAircraftType = lightAircraftType;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {return true;}
        if (!(o instanceof LightAircraft)) {return false;}
        if (!super.equals(o)) {return false;}
        LightAircraft that = (LightAircraft) o;
        return getLightAircraftType() == that.getLightAircraftType();
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getLightAircraftType());
    }

    @Override
    public String toString (){

        return super.toString().replace("}",
                ", lightAircraftType=" + lightAircraftType +
                        '}');
    }
}
