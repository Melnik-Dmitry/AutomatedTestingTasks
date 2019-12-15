/*
 * version: 1.1.1
 * made by Dmitry Melnik
 * 20-Dec-2019
 */

package com.epam.melnik.java.cleancode.fixedproject.src.main.java;

import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane.MilitaryPlane;
import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane.PassengerPlane;
import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane.Plane;
import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.planetype.MilitaryType;
import com.epam.melnik.java.cleancode.fixedproject.src.main.java.util.AirportPlaneSorter;
import com.epam.melnik.java.cleancode.fixedproject.src.main.java.util.PlaneSearcher;

import java.util.Arrays;
import java.util.List;

public class Runner {

    static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT)
    );

    public static final String PRINT_FOR_MILITARY_AIRPORT_SORTED_BY_MAX_DISTANCE =
            "Military airport sorted by max distance: ";
    public static final String PRINT_FOR_PASSENGER_AIRPORT_SORTED_BY_MAX_SPEED =
            "Passenger airport sorted by max speed: ";
    public static final String PRINT_PLANE_WITH_MAX_PASSENGER_CAPACITY =
            "Plane with max passenger capacity: ";

    public static void main(String[] args) {

        Airport airport = new Airport(planes);
        PlaneSearcher<Plane> planeSearcher = new PlaneSearcher();
        AirportPlaneSorter airportPlaneSorter = new AirportPlaneSorter();

        Airport militaryAirport =
                new Airport(planeSearcher.getMilitaryPlanes((List<Plane>) airport.getPlanes()));
        Airport passengerAirport =
                new Airport(planeSearcher.getPassengerPlanes((List<Plane>) airport.getPlanes()));

        System.out.println(PRINT_FOR_MILITARY_AIRPORT_SORTED_BY_MAX_DISTANCE
                + airportPlaneSorter.sortByMaxFlightDistance(militaryAirport).toString());

        System.out.println(PRINT_FOR_PASSENGER_AIRPORT_SORTED_BY_MAX_SPEED
                + airportPlaneSorter.sortByMaxSpeed(passengerAirport).toString());

        System.out.println(PRINT_PLANE_WITH_MAX_PASSENGER_CAPACITY
                + planeSearcher.getPassengerPlaneWithMaxPassengersCapacity
                ((List<Plane>) passengerAirport.getPlanes()));
    }
}
