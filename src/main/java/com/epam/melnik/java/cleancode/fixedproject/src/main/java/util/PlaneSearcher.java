/*
 * version: 1.1.1
 * made by Dmitry Melnik
 * 20-Dec-2019
 */

package com.epam.melnik.java.cleancode.fixedproject.src.main.java.util;

import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane.ExperimentalPlane;
import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane.MilitaryPlane;
import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane.PassengerPlane;
import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane.Plane;
import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.planetype.MilitaryType;

import java.util.ArrayList;
import java.util.List;

/**
 * The class is designed to search by airplane type
 *
 * @param <T extends Plane>
 *
 * @author Dmitry Melnik
 * @see Plane
 */
public class PlaneSearcher<T extends Plane> {

    /**
     * search all passenger planes
     *
     * @return List<PassengerPlane>
     */
    public List<PassengerPlane> getPassengerPlanes(List<T> planes) {

        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) plane);
            }
        }
        return passengerPlanes;
    }

    /**
     * search all military planes
     *
     * @return List<MilitaryPlane>
     */
    public List<MilitaryPlane> getMilitaryPlanes(List<T> planes) {

        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    /**
     * search all military planes with type TRANSPORT
     *
     * @return List<MilitaryPlane>
     */
    public List<MilitaryPlane> getTransportMilitaryPlanes(List<T> planes) {

        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes(planes);

        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            MilitaryPlane plane = militaryPlanes.get(i);
            if (plane.getType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(plane);
            }
        }
        return transportMilitaryPlanes;
    }

    /**
     * search all military planes with type BOMBER
     *
     * @return List<MilitaryPlane>
     */
    public List<MilitaryPlane> getBomberMilitaryPlanes(List<T> planes) {

        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes(planes);

        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            MilitaryPlane plane = militaryPlanes.get(i);
            if (plane.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;

    }

    /**
     * search all experimental planes
     *
     * @return List<ExperimentalPlane>
     */
    public List<ExperimentalPlane> getExperimentalPlanes(List<T> planes) {

        List<ExperimentalPlane> ExperimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                ExperimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return ExperimentalPlanes;
    }

    /**
     * search passenger plane with max passenger capacity
     *
     * @return PassengerPlane
     */
    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity(List<T> planes) {

        List<PassengerPlane> passengerPlanes = getPassengerPlanes(planes);

        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity()
                    > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }
        return planeWithMaxCapacity;
    }
}
