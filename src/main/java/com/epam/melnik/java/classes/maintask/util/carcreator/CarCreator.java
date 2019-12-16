/*
 * version: 1.1
 * made by Dmitry Melnik
 * 25-Dec-2019
 */

package com.epam.melnik.java.classes.maintask.util.carcreator;

import com.epam.melnik.java.classes.maintask.entity.car.Car;
import com.epam.melnik.java.classes.maintask.entity.car.CarColor;

import java.util.Random;

/**
 * Utility class designed to generate an array of entities.
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class CarCreator {

    public static final double minPrice = 10000;
    public static final double maxPrice = 50000;

    private static final int DEFAULT_AMOUNT_CREATED_CARS = 10;
    private static final Random random = new Random();

    /**
     * create array of cars
     *
     * @param amountCars
     * @return Car[]
     */
    public static Car[] createCars(int amountCars) {

        Car[] cars = null;

        if (amountCars > 0) {
            cars = new Car[amountCars];
        } else {
            cars = new Car[DEFAULT_AMOUNT_CREATED_CARS];
        }

        for (int i = 0; i < cars.length; i++) {
            Car car = new Car();
            car.setId(i);
            car.setModel(CarModelCreator.modelCreate());
            car.setManufactureYear(ManufactureYearCreator.createManufactureYear());
            car.setColor(createColor());
            car.setPrice(createPrice());
            car.setRegistrationNumber(RegistrationNumberCreator.createNumber());

            cars[i] = car;
        }

        return cars;
    }

    private static CarColor createColor() {

        int colorPosition = random.nextInt(CarColor.values().length);

        return CarColor.values()[colorPosition];
    }

    private static double createPrice() {

        double incrementMaxMinPrice = maxPrice - minPrice;
        double price = random.nextDouble() * incrementMaxMinPrice + minPrice;

        return price;
    }
}