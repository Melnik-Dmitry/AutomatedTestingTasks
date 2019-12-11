package com.epam.melnik.java.collections.maintask.util.entitycreate;

import com.epam.melnik.java.collections.maintask.entity.aircraft.AirCraft;
import com.epam.melnik.java.collections.maintask.entity.aircraft.AirCraftType;

public class AirplaneFactory {

    public static AirCraft createAircraft(AirCraftType type) {

        AirCraft airCraft = null;
        if (type != null && type.equals(AirCraftType.CARGO)) {
//            airCraft = CargoAirPlaneCreat/r.createAirPlane();
        } else {

        }
        return airCraft;
    }
}
