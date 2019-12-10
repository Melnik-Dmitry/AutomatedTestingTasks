package com.epam.melnik.java.collections.maintask.util.airplanefactory;

import com.epam.melnik.java.collections.maintask.entity.AirCraft;
import com.epam.melnik.java.collections.maintask.entity.AirCraftType;

public class AirplaneFactory {

    public static AirCraft createAircraft(AirCraftType type) {

        AirCraft airCraft = null;
        if (type != null && type.equals(AirCraftType.CARGO)) {
            airCraft = null;
        } else {

        }
        return null;
    }
}
