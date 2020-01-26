/*
 * version: 1.1
 * made by Dmitry Melnik
 * 26-Jan-2020
 */

package com.epam.melnik.java.thread;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class for entity ParkingPlace
 */
public class ParkingPlace {

    private static int amountCreated;
    private int number;
    private Lock carOnPlace;
    public AtomicBoolean isAvailable;

    {
        amountCreated++;
    }

    public ParkingPlace() {

        number = amountCreated;
        carOnPlace = new ReentrantLock(true);
        isAvailable = new AtomicBoolean(true);
    }

    public int getNumber() {

        return number;
    }

    public Lock isCarOnPlace() {

        return carOnPlace;
    }

    public AtomicBoolean getIsAvailable() {

        return isAvailable;
    }

    public void setIsAvailableWhenCarOnPlace() {

        isAvailable.set(false);
    }

    public void setIsAvailableWhenCarNoOnPlace(){

        isAvailable.set(true);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {return true;}
        if (!(o instanceof ParkingPlace)) {return false;}
        ParkingPlace parkingPlace = (ParkingPlace) o;
        return getNumber() == parkingPlace.getNumber();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getNumber());
    }

    @Override
    public String toString() {

        return "ParkingPlace{" +
                "number=" + number +
                '}';
    }
}
