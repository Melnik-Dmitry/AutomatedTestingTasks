package com.epam.melnik.java.collections.maintask.util.validation;

import com.epam.melnik.java.collections.maintask.model.entity.aircraft.AirCraftType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class AirCraftParameterValidatorImplTest {

    private int amountPeopleAircraftCrew;
    private int cargoAirCraftCarryingCapacity;
    private int cargoAirCraftPassengerCapacity;
    private int passengerAirCraftCarryingCapacity;
    private int passengerAirCraftPassengerCapacity;
    private int flightRange;
    private int fuelConsumption;
    private boolean checkParameterResult;

    private AirCraftParameterValidator validator = new AirCraftParameterValidatorImpl();

    public AirCraftParameterValidatorImplTest(int amountPeopleAircraftCrew,
                                              int cargoAirCraftCarryingCapacity,
                                              int cargoAirCraftPassengerCapacity,
                                              int passengerAirCraftCarryingCapacity,
                                              int passengerAirCraftPassengerCapacity,
                                              int flightRange,
                                              int fuelConsumption,
                                              boolean checkParameterResult) {

        this.amountPeopleAircraftCrew = amountPeopleAircraftCrew;
        this.cargoAirCraftCarryingCapacity = cargoAirCraftCarryingCapacity;
        this.cargoAirCraftPassengerCapacity = cargoAirCraftPassengerCapacity;
        this.passengerAirCraftCarryingCapacity = passengerAirCraftCarryingCapacity;
        this.passengerAirCraftPassengerCapacity = passengerAirCraftPassengerCapacity;
//        this.airCraftType = airCraftType;
        this.flightRange = flightRange;
        this.fuelConsumption = fuelConsumption;
        this.checkParameterResult = checkParameterResult;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {

        return new Object[][]{
                {4, 5_000, 10, 1_000, 50, 1_000, 300, true},
                {6, 50_000, 25, 20_000, 300, 6_500, 2_500, true},
                {-5, -5_000, -10, -1_000, -50, -1_000, -300, false},
                {150, 150_000, 200, 200_000, 3_000, 65_000, 25_000, false},
        };
    }

    @Test
    public void checkAmountPeopleAircraftCrew() {

        assertEquals(checkParameterResult, validator.checkAmountPeopleAircraftCrew(amountPeopleAircraftCrew));
    }

    @Test
    public void checkCargoAirCraftCarryingCapacity() {

        assertEquals(checkParameterResult,
                validator.checkCarryingCapacity(cargoAirCraftCarryingCapacity, AirCraftType.CARGO));
    }

    @Test
    public void checkPassengerAirCraftCarryingCapacity() {

        assertEquals(checkParameterResult,
                validator.checkPassengerCapacity(cargoAirCraftPassengerCapacity, AirCraftType.CARGO));
    }

    @Test
    public void checkCargoAirCraftPassengerCapacity() {

        assertEquals(checkParameterResult,
                validator.checkCarryingCapacity(passengerAirCraftCarryingCapacity, AirCraftType.PASSENGER));
    }

    @Test
    public void checkPassengerAirCraftPassengerCapacity() {

        assertEquals(checkParameterResult,
                validator.checkPassengerCapacity(passengerAirCraftPassengerCapacity, AirCraftType.PASSENGER));
    }

    @Test
    public void checkCarryingCapacityWitnNullAirCraftType() {

        assertEquals(false,
                validator.checkCarryingCapacity(10_000, null));
    }

    @Test
    public void checkPassengerCapacityWitnNullAirCraftType() {

        assertEquals(false,
                validator.checkPassengerCapacity(50, null));
    }

    @Test
    public void checkFlightRange() {

        assertEquals(checkParameterResult, validator.checkFlightRange(flightRange));
    }

    @Test
    public void checkFuelConsumption() {

        assertEquals(checkParameterResult, validator.checkFuelConsumption(fuelConsumption));
    }
}