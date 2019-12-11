package com.epam.melnik.java.collections.maintask.entity.airline;

import com.epam.melnik.java.collections.maintask.entity.aircraft.AirCraft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AirlineOffice {

    public int getTotalAirParkCarryingCapacity(List<AirCraft> airPark) {

        int totalCapacity = 0;
        if (airPark != null && !airPark.isEmpty()) {
            totalCapacity += airPark.stream().mapToInt((AirCraft::getCarryingCapacity)).sum();
        }

        return totalCapacity;
    }

    public int getTotalAirParkPassengerCapacity(List<AirCraft> airPark) {

        int totalCapacity = 0;
        if (airPark != null && !airPark.isEmpty()) {
            totalCapacity += airPark.stream().mapToInt((AirCraft::getPassengerCapacity)).sum();
        }

        return totalCapacity;
    }

    public List<AirCraft> sortAirParkByFuelConsumption(List<AirCraft> airPark) {

        if (airPark != null) {
            airPark.sort(Comparator.comparingInt(AirCraft::getFuelConsumption));
        }
        return airPark;
    }

    public List<AirCraft> sortAirParkByFlightRange(List<AirCraft> airPark) {

        if (airPark != null) {
            airPark.sort(Comparator.comparingInt(AirCraft::getFlightRange));
        }
        return airPark;
    }

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
            } else {

            }
        } else {
            airCraftsFuelConsumptionRange = new ArrayList<>();
        }

        return airCraftsFuelConsumptionRange;
    }
}
