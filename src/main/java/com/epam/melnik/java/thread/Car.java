/*
 * version: 1.1
 * made by Dmitry Melnik
 * 26-Jan-2020
 */

package com.epam.melnik.java.thread;

import java.util.Random;

/**
 * Class for entity Car representing a thread of execution
 */
public class Car implements Runnable {

    private static int amountCars;
    private CarPark park;
    private final int carNumber;

    private static final int START_TIME_BEFORE_GET_PARKING_PLACE = 1_000;
    private static final int TIME_CAR_ON_PARKING_PLACE = 2_000;
    private static final int TIME_WHEN_CAR_GET_PARKING_PLACE_AGAIN = 3_000;
    private static final int TIME_TO_GET_PARKING_PLACE_ON_OTHER_CARPARK = 4_000;

    {
        amountCars++;
    }

    public Car(CarPark park) {

        this.park = park;
        carNumber = amountCars;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(new Random().nextInt(carNumber * START_TIME_BEFORE_GET_PARKING_PLACE));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (park.getAmountAvailablePLaces() > 0) {
                System.out.println("Car with number " + carNumber + " try to get parking place");
                for (int i = 0; i < park.getPlaces().size(); i++) {
                    ParkingPlace currentPlace = park.getPlaces().get(i);
                    if (currentPlace.isCarOnPlace().tryLock()) {
                        currentPlace.setIsAvailableWhenCarOnPlace();
                        System.out.println("Car with number " + carNumber
                                + " get parking place with number " + currentPlace.getNumber());
                        try {
                            Thread.sleep(TIME_CAR_ON_PARKING_PLACE);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        continue;
                    }
                    System.out.println("Car with number " + carNumber
                            + " left parking place with number " + currentPlace.getNumber());
                    currentPlace.isCarOnPlace().unlock();
                    currentPlace.setIsAvailableWhenCarNoOnPlace();
                    break;
                }
                try {
                    Thread.sleep(TIME_WHEN_CAR_GET_PARKING_PLACE_AGAIN);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    System.out.println("Car with number " + carNumber + " went to other carPark");
                    Thread.sleep(TIME_TO_GET_PARKING_PLACE_ON_OTHER_CARPARK);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
