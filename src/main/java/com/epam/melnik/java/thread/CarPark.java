/*
 * version: 1.1
 * made by Dmitry Melnik
 * 26-Jan-2020
 */

package com.epam.melnik.java.thread;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class for entity CarPark includes into List<ParkingPlace>
 */
public class CarPark {

    private List<ParkingPlace> places;
    private AtomicInteger amountAvailablePLaces;

    public CarPark(List<ParkingPlace> places) {

        this.places = places;
    }

    public List<ParkingPlace> getPlaces() {

        return places;
    }

    public int getAmountAvailablePLaces() {

        amountAvailablePLaces = new AtomicInteger((int) places.stream()
                .filter(parkingPlace -> parkingPlace.getIsAvailable().get())
                .count());
        return amountAvailablePLaces.get();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof CarPark)) {
            return false;
        }
        CarPark park = (CarPark) o;
        return getPlaces().equals(park.getPlaces());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPlaces());
    }

    @Override
    public String toString() {

        return "CarPark{" +
                "places=" + places +
                '}';
    }
}
