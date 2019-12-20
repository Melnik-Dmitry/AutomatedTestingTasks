package com.epam.melnik.java;

import com.epam.melnik.java.collections.maintask.model.entity.airline.Airline;
import com.epam.melnik.java.fundamentals.maintask.task1.HelloUser;
import com.epam.melnik.java.fundamentals.maintask.task2.CommandLineArgs;
import com.epam.melnik.java.fundamentals.maintask.task3.RandomNumbers;
import com.epam.melnik.java.fundamentals.maintask.task4.CommandLineArgsAsNumber;
import com.epam.melnik.java.fundamentals.maintask.task5.MonthEqualsNumber;
import com.epam.melnik.java.fundamentals.optionaltask1.task1.SearchNumByLength;
import com.epam.melnik.java.fundamentals.optionaltask1.task2.RangingNums;
import com.epam.melnik.java.fundamentals.optionaltask1.task3.NumsAroundMiddleLength;
import com.epam.melnik.java.fundamentals.optionaltask1.task4.AmountNumerals;
import com.epam.melnik.java.fundamentals.optionaltask1.task5.NumbersWithEvenNumerals;

public class ApplicationRunner {

    public static final String TOTAL_CARRYING_CAPACITY_MESSAGE = "Total carrying capacity - ";
    public static final String TOTAL_PASSENGER_CAPACITY_MESSAGE = "Total passenger capacity - ";
    public static final String AIRCRAFTS_SORTED_BY_FUEL_CONSUMPTION = "Aircrafts sorted by fuel consumption:";
    public static final String AIRCRAFTS_AFTER_SORT_BY_FLIGHT_RANGE_MESSAGE = "Aircrafts sorted by flight range:";
    public static int MIN_FUEL_CONSUMPTION = 600;
    public static int MAX_FUEL_CONSUMPTION = 1000;
    public static final String AIRCRAFTS_WITH_FUEL_CONSUMPTION_FROM_MIN_AND_MAX_MESSAGE =
            "Aircrafts with fuel consumption from " + MIN_FUEL_CONSUMPTION
                    + " to " + MAX_FUEL_CONSUMPTION + ":";

    public static void main(String[] args) {

//        javaFundamentalsMainTask(args);
//        javaFundamentalsOptionalTask1();
        javaCollectionsMainTask();
    }

    public static void javaFundamentalsMainTask(String[] args) {
        HelloUser.saidUserHello();
        CommandLineArgs.printCommandLineArgs(args);
        RandomNumbers.printNumbers();
        RandomNumbers.printNumbersWithNewLine();
        System.out.println(CommandLineArgsAsNumber.argsSum(args));
        System.out.println(CommandLineArgsAsNumber.argsMultiplication(args));
        MonthEqualsNumber.getMonth();
    }

    public static void javaFundamentalsOptionalTask1() {
        System.out.println(SearchNumByLength.searchNumWithMinLength());
        System.out.println(SearchNumByLength.searchNumWithMaxLength());
        RangingNums.printIncreasingNumbers();
        RangingNums.printDecreasingNumbers();
        NumsAroundMiddleLength.printNumsLessMiddleLength();
        NumsAroundMiddleLength.printNumsMoreMiddleLength();
        System.out.println(AmountNumerals.numberWithMinDifferentNumerals());
        System.out.println(NumbersWithEvenNumerals.getAmountNumsWithEvenNumerals());
        System.out.println(NumbersWithEvenNumerals.getAmountNumbersWithEqualNumberEvenAndOddDigits());
    }

    public static void javaCollectionsMainTask() {

        Airline airline = new Airline();
        System.out.println(airline);

        airline.setAirCrafts(airline.getOffice()
                .sortAirParkByFuelConsumption(airline.getAirCrafts()));
        System.out.println
                (AIRCRAFTS_SORTED_BY_FUEL_CONSUMPTION + "\r\n" + airline);

        airline.setAirCrafts(airline.getOffice()
                .sortAirParkByFlightRange(airline.getAirCrafts()));
        System.out.println
                (AIRCRAFTS_AFTER_SORT_BY_FLIGHT_RANGE_MESSAGE + "\r\n" + airline);

        System.out.println(TOTAL_CARRYING_CAPACITY_MESSAGE +
                airline.getOffice().getTotalAirParkCarryingCapacity(airline.getAirCrafts()));

        System.out.println(TOTAL_PASSENGER_CAPACITY_MESSAGE +
                airline.getOffice().getTotalAirParkPassengerCapacity(airline.getAirCrafts()));

        Airline airlineWithAircraftsWithFuelConsumptionFromMinAndMax = new Airline();
        airlineWithAircraftsWithFuelConsumptionFromMinAndMax.setAirCrafts(
                airline.getOffice()
                        .getAirCraftFuelConsumptionRange(
                                MIN_FUEL_CONSUMPTION,
                                MAX_FUEL_CONSUMPTION,
                                airline.getAirCrafts()));
        System.out.println(AIRCRAFTS_WITH_FUEL_CONSUMPTION_FROM_MIN_AND_MAX_MESSAGE
                + airlineWithAircraftsWithFuelConsumptionFromMinAndMax);
    }
}
