package com.epam.melnik.java.collections.maintask.model.entity.airline;

import com.epam.melnik.java.collections.maintask.model.entity.aircraft.AirCraft;
import com.epam.melnik.java.collections.maintask.model.entity.aircraft.AirCraftType;
import com.epam.melnik.java.collections.maintask.model.entity.aircraft.CargoAirCraft;
import com.epam.melnik.java.collections.maintask.model.entity.aircraft.PassengerAirCraft;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class AirlineOfficeTest {

    private AirlineOffice airlineOffice = new AirlineOffice();
    private List<AirCraft> airPark;
    private int totalAirParkCarryingCapacityResult;
    private int totalAirParkCarryingPassengerResult;
    private List<AirCraft> sortedAirCraftsByFuelConsumption;
    private List<AirCraft> sortedAirCraftsByFlightRange;
    private int minFuelConsumption;
    private int maxFuelConsumption;
    private List<AirCraft> airCraftFuelConsumptionRange;


    public AirlineOfficeTest(List<AirCraft> airPark,
                             int totalAirParkCarryingCapacityResult,
                             int totalAirParkCarryingPassengerResult,
                             List<AirCraft> sortedAirCraftsByFuelConsumption,
                             List<AirCraft> sortedAirCraftsByFlightRange,
                             int minFuelConsumption,
                             int maxFuelConsumption,
                             List<AirCraft> airCraftFuelConsumptionRange) {

        this.airPark = airPark;
        this.totalAirParkCarryingCapacityResult = totalAirParkCarryingCapacityResult;
        this.totalAirParkCarryingPassengerResult = totalAirParkCarryingPassengerResult;
        this.sortedAirCraftsByFuelConsumption = sortedAirCraftsByFuelConsumption;
        this.sortedAirCraftsByFlightRange = sortedAirCraftsByFlightRange;
        this.minFuelConsumption = minFuelConsumption;
        this.maxFuelConsumption = maxFuelConsumption;
        this.airCraftFuelConsumptionRange = airCraftFuelConsumptionRange;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {

        AirCraft firstAirCraft =
                new CargoAirCraft(4, 10_000, 10, 1_000, 650, 1, AirCraftType.CARGO);
        AirCraft secondAirCraft =
                new CargoAirCraft(5, 12_000, 12, 2_500, 420, 5, AirCraftType.CARGO);
        AirCraft thirdAirCraft =
                new CargoAirCraft(6, 30_000, 10, 1_200, 350, 4, AirCraftType.CARGO);
        AirCraft fourthAirCraft =
                new PassengerAirCraft(5, 1_000, 50, 3_000, 320, 10, AirCraftType.PASSENGER, true);
        AirCraft fifthAirCraft =
                new PassengerAirCraft(4, 12_000, 100, 4_500, 400, 25, AirCraftType.PASSENGER, false);
        AirCraft sixthAirCraft =
                new PassengerAirCraft(4, 8_000, 280, 3_200, 300, 50, AirCraftType.PASSENGER, false);

        List<AirCraft> firstAirPark = new ArrayList<>(6);
        firstAirPark.add(firstAirCraft);
        firstAirPark.add(secondAirCraft);
        firstAirPark.add(thirdAirCraft);
        firstAirPark.add(fourthAirCraft);
        firstAirPark.add(fifthAirCraft);
        firstAirPark.add(sixthAirCraft);

        List<AirCraft> secondAirPark = new ArrayList<>(3);
        secondAirPark.add(firstAirCraft);
        secondAirPark.add(secondAirCraft);
        secondAirPark.add(thirdAirCraft);

        List<AirCraft> thirdAirPark = new ArrayList<>(3);
        thirdAirPark.add(fourthAirCraft);
        thirdAirPark.add(fifthAirCraft);
        thirdAirPark.add(sixthAirCraft);

        List<AirCraft> firstSortedAirParkByFuelConsumption = new ArrayList<>(6);
        firstSortedAirParkByFuelConsumption.add(sixthAirCraft);
        firstSortedAirParkByFuelConsumption.add(fourthAirCraft);
        firstSortedAirParkByFuelConsumption.add(thirdAirCraft);
        firstSortedAirParkByFuelConsumption.add(fifthAirCraft);
        firstSortedAirParkByFuelConsumption.add(secondAirCraft);
        firstSortedAirParkByFuelConsumption.add(firstAirCraft);

        List<AirCraft> secondSortedAirParkByFuelConsumption = new ArrayList<>(3);
        secondSortedAirParkByFuelConsumption.add(thirdAirCraft);
        secondSortedAirParkByFuelConsumption.add(secondAirCraft);
        secondSortedAirParkByFuelConsumption.add(firstAirCraft);

        List<AirCraft> thirdSortedAirParkByFuelConsumption = new ArrayList<>(3);
        thirdSortedAirParkByFuelConsumption.add(sixthAirCraft);
        thirdSortedAirParkByFuelConsumption.add(fourthAirCraft);
        thirdSortedAirParkByFuelConsumption.add(fifthAirCraft);

        List<AirCraft> firstSortedAirParkByFlightRange = new ArrayList<>(6);
        firstSortedAirParkByFlightRange.add(firstAirCraft);
        firstSortedAirParkByFlightRange.add(thirdAirCraft);
        firstSortedAirParkByFlightRange.add(secondAirCraft);
        firstSortedAirParkByFlightRange.add(fourthAirCraft);
        firstSortedAirParkByFlightRange.add(sixthAirCraft);
        firstSortedAirParkByFlightRange.add(fifthAirCraft);

        List<AirCraft> secondSortedAirParkByFlightRange = new ArrayList<>(3);
        secondSortedAirParkByFlightRange.add(firstAirCraft);
        secondSortedAirParkByFlightRange.add(thirdAirCraft);
        secondSortedAirParkByFlightRange.add(secondAirCraft);

        List<AirCraft> thirdSortedAirParkByFlightRange = new ArrayList<>(3);
        thirdSortedAirParkByFlightRange.add(fourthAirCraft);
        thirdSortedAirParkByFlightRange.add(sixthAirCraft);
        thirdSortedAirParkByFlightRange.add(fifthAirCraft);

        List<AirCraft> firstAirCraftFuelConsumptionRange = new ArrayList<>(4);
        firstAirCraftFuelConsumptionRange.add(thirdAirCraft);
        firstAirCraftFuelConsumptionRange.add(fifthAirCraft);
        firstAirCraftFuelConsumptionRange.add(secondAirCraft);

        return new Object[][]{
                {firstAirPark, 73_000, 462,
                        firstSortedAirParkByFuelConsumption,
                        firstSortedAirParkByFlightRange,
                        350, 450, firstAirCraftFuelConsumptionRange},
                {secondAirPark, 52_000, 32,
                        secondSortedAirParkByFuelConsumption,
                        secondSortedAirParkByFlightRange,
                        450, 350, null},
                {thirdAirPark, 21_000, 430,
                        thirdSortedAirParkByFuelConsumption,
                        thirdSortedAirParkByFlightRange,
                        100, 150, new ArrayList<AirCraft>(0)},
                {null, 0, 0,
                        null,
                        null,
                        350, 450, new ArrayList<AirCraft>()},
                {new ArrayList<AirCraft>(), 0, 0,
                        new ArrayList<AirCraft>(),
                        new ArrayList<AirCraft>(),
                        350, 450, new ArrayList<AirCraft>()}
        };
    }

    @Test
    public void getTotalAirParkCarryingCapacity() {

        assertEquals(totalAirParkCarryingCapacityResult,
                airlineOffice.getTotalAirParkCarryingCapacity(airPark));
    }

    @Test
    public void getTotalAirParkPassengerCapacity() {

        assertEquals(totalAirParkCarryingPassengerResult,
                airlineOffice.getTotalAirParkPassengerCapacity(airPark));
    }

    @Test
    public void sortAirParkByFuelConsumption() {

        assertEquals(sortedAirCraftsByFuelConsumption,
                airlineOffice.sortAirParkByFuelConsumption(airPark));
    }

    @Test
    public void sortAirParkByFlightRange() {

        assertEquals(sortedAirCraftsByFlightRange,
                airlineOffice.sortAirParkByFlightRange(airPark));
    }

    @Test
    public void getAirCraftFuelConsumptionRange() {

        assertEquals(airCraftFuelConsumptionRange,
                airlineOffice.getAirCraftFuelConsumptionRange
                        (minFuelConsumption, maxFuelConsumption, airPark));
    }
}