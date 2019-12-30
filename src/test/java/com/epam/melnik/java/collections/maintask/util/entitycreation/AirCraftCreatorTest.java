package com.epam.melnik.java.collections.maintask.util.entitycreation;

import com.epam.melnik.java.collections.maintask.model.entity.aircraft.AirCraft;
import com.epam.melnik.java.collections.maintask.model.entity.aircraft.AirCraftType;
import com.epam.melnik.java.collections.maintask.model.entity.aircraft.CargoAirCraft;
import com.epam.melnik.java.collections.maintask.model.entity.aircraft.PassengerAirCraft;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class AirCraftCreatorTest {

    private int amountPeopleAircraftCrew; // - 1
    private int cargoAircraftCarryingCapacity;// - 2
    private int cargoAircraftPassengerCapacity;// - 3
    private int passengerAircraftCarryingCapacity;// - 4
    private int passengerAircraftPassengerCapacity;// - 5
    private int flightRange;// - 6
    private int fuelConsumption;// - 7
    private int amountCargoHatch;// - 8
    private int amountPorthole;// - 9 current
    private boolean isThereBusinessCLass; // - 10
    private AirCraft checkedCargoAirCraftResult;// -11
    private AirCraft checkedPassengerAirCraftResult;

    @Parameterized.Parameters
    public static Object[][] testData() {

        return new Object[][]{
                {4, 5_000, 10, 1_000, 50, 1_000, 300, 1, 10, true,
                        new CargoAirCraft(4, 5_000, 10, 1_000, 300, 1, AirCraftType.CARGO),
                        new PassengerAirCraft(4, 1_000, 50, 1_000, 300, 10, AirCraftType.PASSENGER, true)},
                {6, 50_000, 25, 20_000, 300, 6_500, 2_500, 10, 50, true,
                        new CargoAirCraft(6, 50_000, 25, 6_500, 2_500, 10, AirCraftType.CARGO),
                        new PassengerAirCraft(6, 20_000, 300, 6_500, 2_500, 50, AirCraftType.PASSENGER, true)},
                {-4, 5_000, 10, 1_000, 50, 1_000, 300, 1, 10, true, new CargoAirCraft(), new PassengerAirCraft()},
                {4, -5_000, 10, 1_000, 50, 1_000, 300, 1, 10, true, new CargoAirCraft(),
                        new PassengerAirCraft(4, 1_000, 50, 1_000, 300, 10, AirCraftType.PASSENGER, true)},
                {4, 5_000, -10, 1_000, 50, 1_000, 300, 1, 10, true, new CargoAirCraft(),
                        new PassengerAirCraft(4, 1_000, 50, 1_000, 300, 10, AirCraftType.PASSENGER, true)},
                {4, 5_000, 10, -1_000, 50, 1_000, 300, 1, 10, true,
                        new CargoAirCraft(4, 5_000, 10, 1_000, 300, 1, AirCraftType.CARGO),
                        new PassengerAirCraft()},
                {4, 5_000, 10, 1_000, -50, 1_000, 300, 1, 10, true,
                        new CargoAirCraft(4, 5_000, 10, 1_000, 300, 1, AirCraftType.CARGO),
                        new PassengerAirCraft()},
                {4, 5_000, 10, 1_000, 50, -1_000, 300, 1, 10, true, new CargoAirCraft(), new PassengerAirCraft()},
                {4, 5_000, 10, 1_000, 50, 1_000, -300, 1, 10, true, new CargoAirCraft(), new PassengerAirCraft()},
                {4, 5_000, 10, 1_000, 50, 1_000, 300, -1, 10, true, new CargoAirCraft(),
                        new PassengerAirCraft(4, 1_000, 50, 1_000, 300, 10, AirCraftType.PASSENGER, true)},
                {4, 5_000, 10, 1_000, 50, 1_000, 300, 1, -10, true,
                        new CargoAirCraft(4, 5_000, 10, 1_000, 300, 1, AirCraftType.CARGO),
                        new PassengerAirCraft()},
        };
    }

    public AirCraftCreatorTest(int amountPeopleAircraftCrew,
                               int cargoAircraftCarryingCapacity,
                               int cargoAircraftPassengerCapacity,
                               int passengerAircraftCarryingCapacity,
                               int passengerAircraftPassengerCapacity,
                               int flightRange, int fuelConsumption,
                               int amountCargoHatch,
                               int amountPorthole,
                               boolean isThereBusinessCLass,
                               AirCraft checkedCargoAirCraftResult,
                               AirCraft checkedPassengerAirCraftResult) {

        this.amountPeopleAircraftCrew = amountPeopleAircraftCrew;
        this.cargoAircraftCarryingCapacity = cargoAircraftCarryingCapacity;
        this.cargoAircraftPassengerCapacity = cargoAircraftPassengerCapacity;
        this.passengerAircraftCarryingCapacity = passengerAircraftCarryingCapacity;
        this.passengerAircraftPassengerCapacity = passengerAircraftPassengerCapacity;
        this.flightRange = flightRange;
        this.fuelConsumption = fuelConsumption;
        this.amountCargoHatch = amountCargoHatch;
        this.amountPorthole = amountPorthole;
        this.isThereBusinessCLass = isThereBusinessCLass;
        this.checkedCargoAirCraftResult = checkedCargoAirCraftResult;
        this.checkedPassengerAirCraftResult = checkedPassengerAirCraftResult;
    }

    @Test
    public void createAirPlanesFromFile() {

        assertEquals(checkedCargoAirCraftResult, AirCraftCreator.createCargoAirCraft(
                amountPeopleAircraftCrew,
                cargoAircraftCarryingCapacity,
                cargoAircraftPassengerCapacity,
                flightRange,
                fuelConsumption,
                amountCargoHatch
        ));
    }

    @Test
    public void createCargoAirCraft() {

        assertEquals(checkedPassengerAirCraftResult, AirCraftCreator.createPassengerAirCraft(
                amountPeopleAircraftCrew,
                passengerAircraftCarryingCapacity,
                passengerAircraftPassengerCapacity,
                flightRange,
                fuelConsumption,
                amountPorthole,
                isThereBusinessCLass
        ));
    }

    @Test
    public void createPassengerAirCraft() {
    }
}