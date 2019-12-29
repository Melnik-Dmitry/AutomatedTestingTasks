/*
 * version: 1.1
 * made by Dmitry Melnik
 * 30-Dec-2019
 */

package com.epam.melnik.java.classes.maintask.entity.car;

import com.epam.melnik.java.classes.maintask.util.carcreator.CarCreator;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class describing entity Car, includes CarModel, car's manufacture year, CarColor,
 * car's price, car's registration number.
 *
 * @author Dmitry Melnik
 * @see Object
 * @see LocalDate
 * @see CarModel
 * @see CarColor
 */
public class Car {

    private static final String MESSAGE_FOR_NULL_LINK = "Link can not be null";
    private static final String MESSAGE_FOR_LESS_PRICE = "Price can not be less " + CarCreator.minPrice;
    private static final String MESSAGE_FOR_WRONG_ID = "Id can not be less 0";

    private int id;
    private CarModel model;
    private LocalDate manufactureYear;
    private CarColor color;
    private double price;
    private String registrationNumber;

    public Car() {
    }

    public Car(int id,
               CarModel model,
               LocalDate manufactureYear,
               CarColor color,
               double price,
               String registrationNumber) {

        this.id = id;
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public int getId() {

        return id;
    }

    public CarModel getModel() {

        return model;
    }

    public LocalDate getManufactureYear() {

        return manufactureYear;
    }

    public CarColor getColor() {

        return color;
    }

    public double getPrice() {

        return price;
    }

    public String getRegistrationNumber() {

        return registrationNumber;
    }

    public void setId(int id) throws IllegalArgumentException {

        if (id >= 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException(MESSAGE_FOR_WRONG_ID);
        }
    }

    public void setModel(CarModel model) throws IllegalArgumentException {

        if (model != null) {
            this.model = model;
        } else {
            throw new IllegalArgumentException(MESSAGE_FOR_NULL_LINK);
        }
    }

    public void setManufactureYear(LocalDate manufactureYear)
            throws IllegalArgumentException {

        if (manufactureYear != null) {
            this.manufactureYear = manufactureYear;
        } else {
            throw new IllegalArgumentException(MESSAGE_FOR_NULL_LINK);
        }
    }

    public void setColor(CarColor color) throws IllegalArgumentException {

        if (color != null) {
            this.color = color;
        } else {
            throw new IllegalArgumentException(MESSAGE_FOR_NULL_LINK);
        }
    }

    public void setPrice(double price) throws IllegalArgumentException {

        if (price >= CarCreator.minPrice) {
            this.price = price;
        } else {
            throw new IllegalArgumentException(MESSAGE_FOR_LESS_PRICE);
        }
    }

    public void setRegistrationNumber(String registrationNumber)
            throws IllegalArgumentException {

        if (registrationNumber != null && !registrationNumber.isEmpty()) {
            this.registrationNumber = registrationNumber;
        } else {
            throw new IllegalArgumentException(MESSAGE_FOR_NULL_LINK);
        }
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return getId() == car.getId() &&
                Double.compare(car.getPrice(), getPrice()) == 0 &&
                getModel().equals(car.getModel()) &&
                getManufactureYear().equals(car.getManufactureYear()) &&
                getColor() == car.getColor() &&
                getRegistrationNumber().equals(car.getRegistrationNumber());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(),
                getModel(),
                getManufactureYear(),
                getColor(),
                getPrice(),
                getRegistrationNumber());
    }

    @Override
    public String toString() {

        return "Car: " + model + ", manufactureYear -" + manufactureYear + ", color - " + color +
                ", price - " + price + ", registrationNumber - " + registrationNumber;
    }
}
