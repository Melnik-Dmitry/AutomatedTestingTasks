package com.epam.melnik.java;

import com.epam.melnik.java.classes.maintask.entity.car.Car;
import com.epam.melnik.java.classes.maintask.entity.car.CarBrand;
import com.epam.melnik.java.classes.maintask.util.carcreator.CarCreator;
import com.epam.melnik.java.classes.maintask.util.carsearcher.SearchCarWithParameters;
import com.epam.melnik.java.fundamentals.maintask.task1.HelloUser;
import com.epam.melnik.java.fundamentals.maintask.task2.CommandLineArgs;
import com.epam.melnik.java.fundamentals.maintask.task3.RandomNumbers;
import com.epam.melnik.java.fundamentals.maintask.task4.CommandLineArgsAsNumber;
import com.epam.melnik.java.fundamentals.maintask.task5.MonthEqualsNumber;
import com.epam.melnik.java.fundamentals.optionaltask1.task1.SearchNumByLength;
import com.epam.melnik.java.fundamentals.optionaltask1.task2.RangingNums;
import com.epam.melnik.java.fundamentals.optionaltask1.task3.NumsAroundMiddleLength;
import com.epam.melnik.java.fundamentals.optionaltask1.task4.AmountNumerals;
import com.epam.melnik.java.fundamentals.optionaltask1.task5.NumbersWithEvenNumerals;
import com.epam.melnik.java.util.TaskScanner;

import java.util.List;

public class ApplicationRunner {

    public static final CarBrand PARAMETER_BRAND = CarBrand.BMW;
    public static final int PARAMETER_MANUFACTURED_YEAR = 2010;
    public static final double PARAMETER_PRICE_MORE = 15000;
    public static final int PARAMETER_AMOUNT_SERVICE_YEAR = 5;
    public static final String PARAMETER_MODEL = "X6";

    public static final String AMOUNT_CREATED_CARS = "Enter amount created cars - ";
    public static final String AMOUNT_CARS_WITH_BRAND = "Amount cars with brand " + PARAMETER_BRAND + " - ";
    public static final String AMOUNT_CARS_WITH_MANUFACTURED_YEAR_AND_PRICE_MORE =
            "Amount cars with manufacture year " + PARAMETER_MANUFACTURED_YEAR
                    + " and price more " + PARAMETER_PRICE_MORE + " - ";
    public static final String AMOUNT_CARS_WITH_MODEL_AND_SERVICE_YEAR =
            "Amount cars with model " + PARAMETER_MODEL
                    + " and amount service years more " + PARAMETER_AMOUNT_SERVICE_YEAR + " - ";

    public static void main(String[] args) {

//        javaFundamentalsMainTask(args);
//        javaFundamentalsOptionalTask1();
        javaClassesMainTask();
    }

    public static void javaFundamentalsMainTask(String[] args) {
        HelloUser.saidUserHello();
        CommandLineArgs.printCommandLineArgs(args);
        RandomNumbers.printNumbers();
        RandomNumbers.printNumbersWithNewLine();
        System.out.println(CommandLineArgsAsNumber.argsSum(args));
        System.out.println(CommandLineArgsAsNumber.argsMultiplication(args));
        MonthEqualsNumber.getMonth();
    }

    public static void javaFundamentalsOptionalTask1() {
        System.out.println(SearchNumByLength.searchNumWithMinLength());
        System.out.println(SearchNumByLength.searchNumWithMaxLength());
        RangingNums.printIncreasingNumbers();
        RangingNums.printDecreasingNumbers();
        NumsAroundMiddleLength.printNumsLessMiddleLength();
        NumsAroundMiddleLength.printNumsMoreMiddleLength();
        System.out.println(AmountNumerals.numberWithMinDifferentNumerals());
        System.out.println(NumbersWithEvenNumerals.getAmountNumsWithEvenNumerals());
        System.out.println(NumbersWithEvenNumerals.getAmountNumbersWithEqualNumberEvenAndOddDigits());
    }

    public static void javaClassesMainTask() {

        System.out.print(AMOUNT_CREATED_CARS);
        int amountCars = TaskScanner.getInteger();
        Car[] cars = CarCreator.createCars(amountCars);
        System.out.println("Create " + cars.length + " cars.");

        List<Car> carsWithBrand = SearchCarWithParameters.searchCarByBrand(PARAMETER_BRAND, cars);
        System.out.println(AMOUNT_CARS_WITH_BRAND + carsWithBrand.size());
        for (Car car : carsWithBrand) {
            System.out.println(car.getId() + " " + car);
        }

        List<Car> carsWithManufacturedYearAndMorePrice =
                SearchCarWithParameters.searchCarByManufactureYearAndMorePrice
                        (PARAMETER_MANUFACTURED_YEAR, PARAMETER_PRICE_MORE, cars);
        System.out.println
                (AMOUNT_CARS_WITH_MANUFACTURED_YEAR_AND_PRICE_MORE + carsWithManufacturedYearAndMorePrice.size());
        for (Car car : carsWithManufacturedYearAndMorePrice) {
            System.out.println(car.getId() + " " + car);
        }

        List<Car> carsWithModelAndServiceYear = SearchCarWithParameters.searchCarByModelAndAmountServiceYears
                (PARAMETER_MODEL, PARAMETER_AMOUNT_SERVICE_YEAR, cars);
        System.out.println
                (AMOUNT_CARS_WITH_MODEL_AND_SERVICE_YEAR + carsWithModelAndServiceYear.size());
        for (Car car : carsWithModelAndServiceYear) {
            System.out.println(car.getId() + " " + car);
        }
    }
}
