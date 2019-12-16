/*
 * version: 1.1
 * made by Dmitry Melnik
 * 25-Dec-2019
 */

package com.epam.melnik.java.classes.maintask.util.carsearcher;

import com.epam.melnik.java.classes.maintask.entity.car.Car;
import com.epam.melnik.java.classes.maintask.entity.car.CarBrand;
import com.epam.melnik.java.classes.maintask.entity.car.CarColor;
import com.epam.melnik.java.classes.maintask.util.carcreator.CarCreator;
import com.epam.melnik.java.classes.maintask.util.carcreator.ManufactureYearCreator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Utility class designed to search cars according to the specified parameters.
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class SearchCarWithParameters {

    /**
     * search cars by CarBrand
     *
     * @return List<Car>
     */
    public static List<Car> searchCarByBrand(CarBrand brand, Car... cars) {

        List<Car> result = null;
        if (brand != null && cars.length > 0) {

            result = Arrays.stream(cars)
                    .filter(getPredicateByBrand(brand))
                    .collect(Collectors.toList());
        } else {
            result = new ArrayList<>();
        }

        return result;
    }

    /**
     * search cars by model and amount service years
     *
     * @return List<Car>
     */
    public static List<Car> searchCarByModelAndAmountServiceYears
    (String model, int amountServiceYears, Car... cars) {

        List<Car> result = null;
        if (model != null && amountServiceYears > 0 && cars.length > 0) {

            Predicate<Car> predicateByModelAndAmountServiceYears =
                    getPredicateByModel(model)
                            .and(getPredicateByAmountServiceYears(amountServiceYears));

            result = Arrays.stream(cars)
                    .filter(predicateByModelAndAmountServiceYears)
                    .collect(Collectors.toList());
        } else {
            result = new ArrayList<>();
        }

        return result;
    }

    /**
     * search cars by manufactured year and price above specified
     *
     * @return List<Car>
     */
    public static List<Car> searchCarByManufactureYearAndMorePrice
    (int manufactureYear, double price, Car... cars) {

        List<Car> result = null;
        if (manufactureYear > ManufactureYearCreator.startYear && price
                > CarCreator.minPrice && cars.length > 0) {

            Predicate<Car> predicateByManufactureYearAndMorePrice =
                    getPredicateByYearManufacture(manufactureYear)
                            .and(getPredicateByMorePrice(price));

            result = Arrays.stream(cars)
                    .filter(predicateByManufactureYearAndMorePrice)
                    .collect(Collectors.toList());
        } else {
            result = new ArrayList<>();
        }

        return result;
    }

    private static Predicate<Car> getPredicateByBrand(CarBrand brand) {

        Predicate<Car> predicateByBrand =
                car -> car.getModel().getBrand()
                        .equals(brand);
//        Predicate<Car> predicateByBrandWithString =
//                car -> car.getModel().getBrand().name()
//                        .equals(finalValidParameters.get(SearcherParametersName.CAR_BRAND));
//        Predicate<Car> predicateByBrand = predicateByBrandWithEnum.or(predicateByBrandWithString);
        return predicateByBrand;
    }

    private static Predicate<Car> getPredicateByModel(String model) {

        Predicate<Car> predicateByModel = car -> car.getModel().getModel()
                .equals(model);
        return predicateByModel;
    }

    private static Predicate<Car> getPredicateByAmountServiceYears(int amountServiceYears) {

        LocalDate timeNow = LocalDate.now().minusYears(amountServiceYears);
        Predicate<Car> predicateByAmountServiceYears = car -> car.getManufactureYear().getYear() <= timeNow.getYear();
        return predicateByAmountServiceYears;
    }

    private static Predicate<Car> getPredicateByYearManufacture(int year) {

        Predicate<Car> predicateByYear = car -> car.getManufactureYear().getYear()
                == year;
        return predicateByYear;
    }

    private static Predicate<Car> getPredicateByColor(CarColor color) {
        Predicate<Car> predicateByColor = car -> car.getColor().equals(color);
        return predicateByColor;
    }

    private static Predicate<Car> getPredicateByLessPrice(double price) {
        Predicate<Car> predicateByLessPrice = car -> car.getPrice() < price;
        return predicateByLessPrice;
    }

    private static Predicate<Car> getPredicateByMorePrice(double price) {
        Predicate<Car> predicateByMorePrice = car -> car.getPrice() > price;
        return predicateByMorePrice;
    }

    private static Predicate<Car> getPredicateByRegistrationNumber(String registrationNumber) {
        Predicate<Car> predicateByRegistrationNumber = car -> car.getRegistrationNumber().equals(registrationNumber);
        return predicateByRegistrationNumber;
    }
}