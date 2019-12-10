package com.epam.melnik.java.classes.maintask.entity.car;

import java.util.Objects;

public class CarModel {

    private CarBrand brand;
    private String model;

    public CarModel() {
    }

    public CarModel(CarBrand brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarModel)) {
            return false;
        }
        CarModel carModel = (CarModel) o;
        return getBrand() == carModel.getBrand() &&
                getModel().equals(carModel.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getModel());
    }

    @Override
    public String toString() {
        return "CarModel - " + model + ", brand - " + brand;
    }
}
