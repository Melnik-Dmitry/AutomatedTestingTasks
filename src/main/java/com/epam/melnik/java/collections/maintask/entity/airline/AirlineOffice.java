package com.epam.melnik.java.collections.maintask.entity.airline;

import com.epam.melnik.java.collections.maintask.entity.aircraft.AirCraft;

import java.util.List;

public class AirlineOffice {

    public int getTotalAirParkCarryingCapacity(List<AirCraft> airCrafts) {

        int totalCapacity = 0;
        if (airCrafts != null && !airCrafts.isEmpty()) {
            totalCapacity += airCrafts.stream().mapToInt((AirCraft::getCarryingCapacity)).sum();
        }

        return totalCapacity;
    }

    public int getTotalAirParkPassengerCapacity (List<AirCraft> airCrafts){

        int totalCapacity = 0;
        if (airCrafts != null && !airCrafts.isEmpty()) {
            totalCapacity += airCrafts.stream().mapToInt((AirCraft::getPassengerCapacity)).sum();
        }

        return totalCapacity;
    }
}

//            TotalSum<AirCraft> totalSum = (airCraft, sum) -> {
//                sum += airCraft.getCarryingCapacity();
//                return sum;
//            };


//    @FunctionalInterface
//    private interface TotalSum<AirCraft> {
//
//        int summation(AirCraft craft, int summ);
//    }
