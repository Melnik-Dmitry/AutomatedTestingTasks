/*
 * version: 1.1.1
 * made by Dmitry Melnik
 * 20-Dec-2019
 */

package com.epam.melnik.java.cleancode.fixedproject.src.main.java.util;

import com.epam.melnik.java.cleancode.fixedproject.src.main.java.Airport;
import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane.Plane;

import java.util.Collections;
import java.util.Comparator;

/**
 * The class is designed to sort airport by parameters
 *
 * @author Dmitry Melnik
 */
public class AirportPlaneSorter {

    /**
     * Sorts by max flight distance
     *
     * @return Airport
     */
    public Airport sortByMaxFlightDistance(Airport airport) {

        Collections.sort(airport.getPlanes(), new Comparator<Plane>() {
            public int compare(Plane firstPlane, Plane secondPlane) {
                return firstPlane.getMaxFlightDistance() - secondPlane.getMaxFlightDistance();
            }
        });

        return airport;
    }

    /**
     * Sorts by max speed
     *
     * @return Airport
     */
    public Airport sortByMaxSpeed(Airport airport) {

        Collections.sort(airport.getPlanes(), new Comparator<Plane>() {
            public int compare(Plane firstPlane, Plane secondPlane) {
                return firstPlane.getMaxSpeed() - secondPlane.getMaxSpeed();
            }
        });

        return airport;
    }

    /**
     * Sorts by load capacity
     *
     * @return Airport
     */
    public Airport sortByMaxLoadCapacity(Airport airport) {

        Collections.sort(airport.getPlanes(), new Comparator<Plane>() {
            public int compare(Plane firstPlane, Plane secondPlane) {
                return firstPlane.getMaxLoadCapacity() - secondPlane.getMaxLoadCapacity();
            }
        });

        return airport;
    }
}
