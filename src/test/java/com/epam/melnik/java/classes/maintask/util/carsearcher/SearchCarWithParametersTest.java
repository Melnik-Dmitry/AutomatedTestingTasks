package com.epam.melnik.java.classes.maintask.util.carsearcher;

import com.epam.melnik.java.classes.maintask.entity.car.Car;
import com.epam.melnik.java.classes.maintask.entity.car.CarBrand;
import com.epam.melnik.java.classes.maintask.entity.car.CarColor;
import com.epam.melnik.java.classes.maintask.entity.car.CarModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(value = Parameterized.class)
public class SearchCarWithParametersTest {

    private Car[] cars;
    private CarBrand brand;
    private int searchCarsByBrandResult;
    private String model;
    private int amountServiceYears;
    private int searchCarsByModelAndYearsResult;
    private int manufactureYear;
    private double price;
    private int searchCarsByYearAndPriceResult;

    @Parameterized.Parameters
    public static Object[][] tetData() {

        Car[] carsPark = new Car[]{
                new Car(0,
                        new CarModel(CarBrand.BMW, "X3"),
                        LocalDate.ofYearDay(2005, 266),
                        CarColor.BLUE,
                        15600,
                        "1025 - AA"),
                new Car(1,
                        new CarModel(CarBrand.BMW, "X5"),
                        LocalDate.ofYearDay(2010, 123),
                        CarColor.BLACK,
                        25800,
                        "1089 - AB"),
                new Car(2,
                        new CarModel(CarBrand.BMW, "X6"),
                        LocalDate.ofYearDay(2001, 320),
                        CarColor.WHITE,
                        25400,
                        "2210 - AC"),
                new Car(3,
                        new CarModel(CarBrand.MAZDA, "CX-4"),
                        LocalDate.ofYearDay(2002, 52),
                        CarColor.RED,
                        18600,
                        "3220 - AC"),
                new Car(4,
                        new CarModel(CarBrand.MAZDA, "CX-5"),
                        LocalDate.ofYearDay(2008, 94),
                        CarColor.RED,
                        26500,
                        "3214 - AC"),
                new Car(5,
                        new CarModel(CarBrand.MAZDA, "CX-7"),
                        LocalDate.ofYearDay(2011, 104),
                        CarColor.GREY,
                        16500,
                        "3214 - AA"),
                new Car(6,
                        new CarModel(CarBrand.TOYOTA, "Camry"),
                        LocalDate.ofYearDay(2013, 129),
                        CarColor.GREY,
                        35500,
                        "3784 - AC"),
                new Car(7,
                        new CarModel(CarBrand.TOYOTA, "Corolla"),
                        LocalDate.ofYearDay(2010, 290),
                        CarColor.BLUE,
                        30500,
                        "8956 - AB"),
                new Car(8,
                        new CarModel(CarBrand.TOYOTA, "Prius"),
                        LocalDate.ofYearDay(2005, 90),
                        CarColor.WHITE,
                        27900,
                        "5616 - AA")};


        return new Object[][]{
                {carsPark, CarBrand.BMW, 3, "X3", 13, 1, 2005, 15_000, 2},
                {null, CarBrand.BMW, 0, "X3", 5, 0, 2005, 15_000, 0},
                {new Car[0], CarBrand.TOYOTA, 0, "X3", 5, 0, 2005, 15_000, 0},
                {carsPark, null, 0, null, 5, 0, 1995, 15_000, 0},
                {carsPark, CarBrand.TOYOTA, 3, "X3", -5, 0, 2005, 5_000, 0},
                {carsPark, CarBrand.MAZDA, 3, "", 5, 0, 2013, 35_000, 1},
        };
    }

    public SearchCarWithParametersTest(Car[] cars,
                                       CarBrand brand,
                                       int searchCarsByBrandResult,
                                       String model,
                                       int amountServiceYears,
                                       int searchCarsByModelAndYearsResult,
                                       int manufactureYear,
                                       double price,
                                       int searchCarsByYearAndPriceResult) {

        this.cars = cars;
        this.brand = brand;
        this.searchCarsByBrandResult = searchCarsByBrandResult;
        this.model = model;
        this.amountServiceYears = amountServiceYears;
        this.searchCarsByModelAndYearsResult = searchCarsByModelAndYearsResult;
        this.manufactureYear = manufactureYear;
        this.price = price;
        this.searchCarsByYearAndPriceResult = searchCarsByYearAndPriceResult;
    }

    @Test
    public void searchCarByBrand() {

        List<Car> carsList = SearchCarWithParameters.searchCarByBrand(brand, cars);
        assertNotNull(carsList);
        assertEquals(searchCarsByBrandResult, carsList.size());
    }

    @Test
    public void searchCarByModelAndAmountServiceYears() {

        List<Car> carList = SearchCarWithParameters
                .searchCarByModelAndAmountServiceYears
                        (model, amountServiceYears, cars);
        assertNotNull(carList);
        assertEquals(searchCarsByModelAndYearsResult, carList.size());
    }

    @Test
    public void searchCarByManufactureYearAndMorePrice() {

        List<Car> carList = SearchCarWithParameters.
                searchCarByManufactureYearAndMorePrice(manufactureYear, price, cars);
        assertNotNull(carList);
        assertEquals(searchCarsByYearAndPriceResult, carList.size());
    }
}