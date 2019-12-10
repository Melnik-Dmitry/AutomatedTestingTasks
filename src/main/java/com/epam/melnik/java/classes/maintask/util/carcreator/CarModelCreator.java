package com.epam.melnik.java.classes.maintask.util.carcreator;

import com.epam.melnik.java.classes.maintask.entity.car.CarBrand;
import com.epam.melnik.java.classes.maintask.entity.car.CarModel;

import java.util.Random;

public class CarModelCreator {

    private static final String[] bmwModels = {"X3", "X5", "X6"};
    private static final String[] toyotaModels = {"Camry", "Corolla", "Prius"};
    private static final String[] mazdaModels = {"CX-4", "CX-5", "CX-7"};

    public static CarModel modelCreate() {

        CarModel model = new CarModel();

        Random random = new Random();
        int modelIndex = random.nextInt(bmwModels.length + toyotaModels.length + mazdaModels.length);

        if (modelIndex < bmwModels.length){
            model.setBrand(CarBrand.BMW);
            model.setModel(bmwModels[modelIndex]);
        } else if (modelIndex < (bmwModels.length + toyotaModels.length)){
            model.setBrand(CarBrand.TOYOTA);
            model.setModel(toyotaModels[modelIndex - bmwModels.length]);
        } else {
            model.setBrand(CarBrand.MAZDA);
            model.setModel(mazdaModels[modelIndex-(bmwModels.length + toyotaModels.length)]);
        }

        return model;
    }
}