/*
 * version: 1.1
 * made by Dmitry Melnik
 * 25-Dec-2019
 */

package com.epam.melnik.java.collections.maintask.entity.airline;

import com.epam.melnik.java.collections.maintask.entity.aircraft.AirCraft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class makes some functional(as search, sorting) with List<AirCraft>.
 *
 * @see AirCraft
 * @see com.epam.melnik.java.collections.maintask.entity.aircraft.PassengerAirCraft
 * @see com.epam.melnik.java.collections.maintask.entity.aircraft.CargoAirCraft
 */
public class AirlineOffice {

    /**
     * Method counts total carrying capacity.
     *
     * @param airPark
     * @return int
     */
    public int getTotalAirParkCarryingCapacity(List<AirCraft> airPark) {

        int totalCapacity = 0;
        if (airPark != null && !airPark.isEmpty()) {
            totalCapacity += airPark.stream().mapToInt((AirCraft::getCarryingCapacity)).sum();
        }

        return totalCapacity;
    }

    /**
     * Method counts total passenger capacity.
     *
     * @param airPark
     * @return int
     */
    public int getTotalAirParkPassengerCapacity(List<AirCraft> airPark) {

        int totalCapacity = 0;
        if (airPark != null && !airPark.isEmpty()) {
            totalCapacity += airPark.stream().mapToInt((AirCraft::getPassengerCapacity)).sum();
        }

        return totalCapacity;
    }

    /**
     * Method sorts AirCrafts by fuel consumption.
     * Returns sorted List<AirCraft> airPark
     *
     * @param airPark
     * @return List<AirCraft>
     */
    public List<AirCraft> sortAirParkByFuelConsumption(List<AirCraft> airPark) {

        if (airPark != null) {
            airPark.sort(Comparator.comparingInt(AirCraft::getFuelConsumption));
        }

        return airPark;
    }

    /**
     * Method sorts AirCrafts by flight range.
     * Returns sorted List<AirCraft> airPark
     *
     * @param airPark
     * @return List<AirCraft>
     */
    public List<AirCraft> sortAirParkByFlightRange(List<AirCraft> airPark) {

        if (airPark != null) {
            airPark.sort(Comparator.comparingInt(AirCraft::getFlightRange));
        }

        return airPark;
    }

    /**
     * Method searches AirCrafts, which fuel consumption
     * more than minFuelConsumption and less then maxFuelConsumption.
     * Returns new List<AirCraft>, is airPark == null or empty
     * returns empty ArrayList.
     *
     * @param airPark
     * @return List<AirCraft>
     */
    public List<AirCraft> getAirCraftFuelConsumptionRange(int minFuelConsumption,
                                                          int maxFuelConsumption,
                                                          List<AirCraft> airPark) {

        List<AirCraft> airCraftsFuelConsumptionRange = null;
        if (airPark != null && !airPark.isEmpty()) {
            if (minFuelConsumption < maxFuelConsumption) {

                Predicate<AirCraft> minFuelConsumptionPredicate =
                        airCraft -> airCraft.getFuelConsumption() >= minFuelConsumption;
                Predicate<AirCraft> maxFuelConsumptionPredicate =
                        airCraft -> airCraft.getFuelConsumption() <= maxFuelConsumption;

                airCraftsFuelConsumptionRange = airPark.stream()
                        .filter(minFuelConsumptionPredicate.and(maxFuelConsumptionPredicate))
                        .collect(Collectors.toList());

                sortAirParkByFuelConsumption(airCraftsFuelConsumptionRange);
            }
        } else {
            airCraftsFuelConsumptionRange = new ArrayList<>();
        }

        return airCraftsFuelConsumptionRange;
    }
}
