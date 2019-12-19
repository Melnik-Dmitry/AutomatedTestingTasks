/*
 * version: 1.1
 * made by Dmitry Melnik
 * 25-Dec-2019
 */

package com.epam.melnik.java.collections.maintask.entity.airline;

import com.epam.melnik.java.collections.maintask.entity.aircraft.AirCraft;
import com.epam.melnik.java.collections.maintask.entity.aircraft.AirCraftType;
import com.epam.melnik.java.collections.maintask.util.entitycreation.AirCraftCreator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Class describing entity Airline,
 * includes List<AirCraft> airCrafts and
 * AirlineOffice office.
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class Airline {

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

            AirCraft[] cargoAirCrafts = AirCraftCreator
                    .createAirPlanesFromFile
                            (FILE_PARAMETERS_CARGO_AIR_CRAFTS, AirCraftType.CARGO);
            AirCraft[] passengerAirCrafts = AirCraftCreator
                    .createAirPlanesFromFile
                            (FILE_PARAMETERS_PASSENGER_AIR_CRAFTS, AirCraftType.PASSENGER);

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

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Airline)) {
            return false;
        }
        Airline airline = (Airline) o;
        return getAirCrafts().equals(airline.getAirCrafts()) &&
                getOffice().equals(airline.getOffice());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getAirCrafts(), getOffice());
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("Airline contains:" + "\r\n");
        List<AirCraft> airCraftsForPrint = getAirCrafts();
        for (int i = 0; i < airCraftsForPrint.size(); i++) {
            builder.append(airCraftsForPrint.get(i) + "\r\n");
        }

        return builder.toString();
    }
}
