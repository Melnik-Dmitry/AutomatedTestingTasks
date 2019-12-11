package com.epam.melnik.java.collections.maintask.entity.airline;

import com.epam.melnik.java.collections.maintask.entity.aircraft.AirCraft;
import com.epam.melnik.java.collections.maintask.util.entitycreate.CargoAirPlaneCreator;
import com.epam.melnik.java.collections.maintask.util.entitycreate.PassengerAirPlaneCreator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Airline {

    public static void main(String[] args) {
        Airline airline = new Airline();
        List<AirCraft> airCrafts = airline.getAirCrafts();
        System.out.println(airline.getOffice().getTotalAirParkCarryingCapacity(airCrafts));
        System.out.println(airline.getOffice().getTotalAirParkPassengerCapacity(airCrafts));

//        List<AirCraft> ad = new ArrayList<>(2);
//        AirCraft first = new CargoAirPlane();
//        AirCraft second = new PassengerAirPlane();
//        ad.add(first);
//        ad.add(second);
    }

    private List<AirCraft> airCrafts;
    private AirlineOffice office;

    public static final String FILE_PARAMETERS_CARGO_AIR_CRAFTS = "cargoAirPlaneInitParameters";
    public static final String FILE_PARAMETERS_PASSENGER_AIR_CRAFTS = "passengerAirPlaneInitParameters";

    public Airline() {
        office = new AirlineOffice();
    }

    public Airline(AirlineOffice office) {
        this.office = office;
    }

    public List<AirCraft> getAirCrafts() {

        if (airCrafts == null) {
            AirCraft[] cargoAirCrafts =
                    CargoAirPlaneCreator.createAirPlaneFromFile(FILE_PARAMETERS_CARGO_AIR_CRAFTS);
            AirCraft[] passengerAirCrafts =
                    PassengerAirPlaneCreator.createAirPlaneFromFile(FILE_PARAMETERS_PASSENGER_AIR_CRAFTS);

            airCrafts = new ArrayList<>(cargoAirCrafts.length + passengerAirCrafts.length);
            Collections.addAll(airCrafts, cargoAirCrafts);
            Collections.addAll(airCrafts, passengerAirCrafts);
        }

        return airCrafts;
    }

    public AirlineOffice getOffice() {
        return office;
    }

    public void setAirCrafts(List<AirCraft> airCrafts) {
        this.airCrafts = airCrafts;
    }

    public void setOffice(AirlineOffice office) {
        this.office = office;
    }
}
