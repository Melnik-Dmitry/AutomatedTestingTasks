package com.epam.melnik.java;

import com.epam.melnik.java.classes.maintask.entity.car.Car;
import com.epam.melnik.java.classes.maintask.entity.car.CarBrand;
import com.epam.melnik.java.classes.maintask.util.carcreator.CarCreator;
import com.epam.melnik.java.classes.maintask.util.carsearcher.SearchCarWithParameters;
import com.epam.melnik.java.collections.maintask.model.entity.airline.Airline;
import com.epam.melnik.java.collections.optionaltask.task1.TextConvertor;
import com.epam.melnik.java.collections.optionaltask.task2.NumberSpliterator;
import com.epam.melnik.java.collections.optionaltask.task4.TextSorter;
import com.epam.melnik.java.collections.optionaltask.util.Spliterator;
import com.epam.melnik.java.collections.optionaltask.util.TaskFileReader;
import com.epam.melnik.java.collections.optionaltask.util.TaskFileWriter;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ApplicationRunner {

    public static final String START_JAVA_FUNDAMENTALS_MAIN_TASK_MESSAGE =
            "Start Java.Fudamentals MainTask";
    public static final String START_JAVA_FUNDAMENTALS_OPTIONAL_TASK1_MESSAGE =
            "Start Java.Fudamentals OptionalTask1";
    public static final String START_JAVA_CLASSES_TASK_MESSAGE =
            "Start Java.Classes Task";
    public static final String START_JAVA_COLLECTIONS_MAIN_TASK_MESSAGE =
            "Start Java.Collections MainTask";
    public static final String NUMBER_WITH_MIN_LENGTH_MESSAGE = "Number with min length -";
    public static final String NUMBER_WITH_MAX_LENGTH_MESSAGE = "Number with max length -";
    public static final String NUMBER_WITH_MIN_DIFFERENT_NUMERALS_MESSAGE =
            "Number in which the number of different digits is minimal -";
    public static final String AMOUNT_NUMBERS_ONLY_FROM_EVEN_DIGITS =
            "Amount numbers containing only even digits - ";
    public static final String AMOUNT_NUMBERS_WITH_EQUALS_AMOUNT_EVEN_AND_ADD_DIGITS =
            "amount numbers with an equal number of even and odd digits - ";
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

    public static final String TOTAL_CARRYING_CAPACITY_MESSAGE = "Total carrying capacity - ";
    public static final String TOTAL_PASSENGER_CAPACITY_MESSAGE = "Total passenger capacity - ";
    public static final String AIRCRAFTS_SORTED_BY_FUEL_CONSUMPTION = "Aircrafts sorted by fuel consumption:";
    public static final String AIRCRAFTS_AFTER_SORT_BY_FLIGHT_RANGE_MESSAGE = "Aircrafts sorted by flight range:";
    public static int MIN_FUEL_CONSUMPTION = 600;
    public static int MAX_FUEL_CONSUMPTION = 1000;
    public static final String AIRCRAFTS_WITH_FUEL_CONSUMPTION_FROM_MIN_AND_MAX_MESSAGE =
            "Aircrafts with fuel consumption from " + MIN_FUEL_CONSUMPTION
                    + " to " + MAX_FUEL_CONSUMPTION + ":";

    public static final String DATA_FILE_FOR_JAVA_COLLECTIONS_OPTIONAL_TASK1 =
            "javaCollectionsOptionalTask1File.txt";
    public static final String JAVA_COLLECTIONS_OPTIONAL_TASK1_FILE_FOR_WRITING =
            "javaCollectionsOptionalTask1FileForWriting";
    public static final int JAVA_COLLECTIONS_OPTIONAL_TASK2_NUMBER_FOR_REVERSE = 15601;
    public static final String DATA_FILE_FOR_JAVA_COLLECTIONS_OPTIONAL_TASK4 =
            "javaCollectionsOptionalTask4File.txt";

    public static final Logger APP_LOGGER = LogManager.getLogger(ApplicationRunner.class);

    public static void main(String[] args) {

//        javaFundamentalsMainTask(args);
//        javaFundamentalsOptionalTask1();
//        javaClassesMainTask();
        javaCollectionsMainTask();
//        javaCollectionsOptionalTask1();
//        javaCollectionsOptionalTask2();
//        javaCollectionsOptionalTask4();
    }

    public static void javaFundamentalsMainTask(String[] args) {

        System.out.println(START_JAVA_FUNDAMENTALS_MAIN_TASK_MESSAGE);
        HelloUser.saidUserHello();
        CommandLineArgs.printCommandLineArgs(args);
        RandomNumbers.printNumbers();
        RandomNumbers.printNumbersWithNewLine();
        System.out.println(CommandLineArgsAsNumber.argsSum(args));
        System.out.println(CommandLineArgsAsNumber.argsMultiplication(args));
        MonthEqualsNumber.getMonth();
        System.out.println("-----------------------------------------------");
    }

    public static void javaFundamentalsOptionalTask1() {

        System.out.println(START_JAVA_FUNDAMENTALS_OPTIONAL_TASK1_MESSAGE);
        System.out.println(NUMBER_WITH_MIN_LENGTH_MESSAGE
                + SearchNumByLength.searchNumWithMinLength());
        System.out.println(NUMBER_WITH_MAX_LENGTH_MESSAGE
                + SearchNumByLength.searchNumWithMaxLength());
        RangingNums.printIncreasingNumbers();
        RangingNums.printDecreasingNumbers();
        NumsAroundMiddleLength.printNumsLessMiddleLength();
        NumsAroundMiddleLength.printNumsMoreMiddleLength();
        System.out.println(NUMBER_WITH_MIN_DIFFERENT_NUMERALS_MESSAGE
                + AmountNumerals.numberWithMinDifferentNumerals());
        System.out.println(AMOUNT_NUMBERS_ONLY_FROM_EVEN_DIGITS
                + NumbersWithEvenNumerals.getAmountNumsWithEvenNumerals());
        System.out.println(AMOUNT_NUMBERS_WITH_EQUALS_AMOUNT_EVEN_AND_ADD_DIGITS
                + NumbersWithEvenNumerals.getAmountNumbersWithEqualNumberEvenAndOddDigits());
        System.out.println("-----------------------------------------------");
    }

    public static void javaClassesMainTask() {

        System.out.println(START_JAVA_CLASSES_TASK_MESSAGE);
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
        System.out.println("-----------------------------------------------");
    }

    public static void javaCollectionsMainTask() {

        System.out.println(START_JAVA_COLLECTIONS_MAIN_TASK_MESSAGE);
        Airline airline = new Airline();
        System.out.println(airline);

        airline.setAirCrafts(airline.getOffice()
                .sortAirParkByFuelConsumption(airline.getAirCrafts()));
        System.out.println
                (AIRCRAFTS_SORTED_BY_FUEL_CONSUMPTION + "\r\n" + airline);

        airline.setAirCrafts(airline.getOffice()
                .sortAirParkByFlightRange(airline.getAirCrafts()));
        System.out.println
                (AIRCRAFTS_AFTER_SORT_BY_FLIGHT_RANGE_MESSAGE + "\r\n" + airline);

        System.out.println(TOTAL_CARRYING_CAPACITY_MESSAGE +
                airline.getOffice().getTotalAirParkCarryingCapacity(airline.getAirCrafts()));

        System.out.println(TOTAL_PASSENGER_CAPACITY_MESSAGE +
                airline.getOffice().getTotalAirParkPassengerCapacity(airline.getAirCrafts()));

        Airline airlineWithAircraftsWithFuelConsumptionFromMinAndMax = new Airline();
        airlineWithAircraftsWithFuelConsumptionFromMinAndMax.setAirCrafts(
                airline.getOffice()
                        .getAirCraftFuelConsumptionRange(
                                MIN_FUEL_CONSUMPTION,
                                MAX_FUEL_CONSUMPTION,
                                airline.getAirCrafts()));
        System.out.println(AIRCRAFTS_WITH_FUEL_CONSUMPTION_FROM_MIN_AND_MAX_MESSAGE
                + airlineWithAircraftsWithFuelConsumptionFromMinAndMax);
        System.out.println("-----------------------------------------------");
    }

    public static void javaCollectionsOptionalTask1() {

        String textFromFile = TaskFileReader
                .readAllTextInFile(DATA_FILE_FOR_JAVA_COLLECTIONS_OPTIONAL_TASK1);
        String[] linesToReverse = Spliterator
                .splitReadTextForReverse(textFromFile,
                        Spliterator.END_LINE_SPLITERATOR);
        String[] linesAfterReverse = TextConvertor.reverseText(linesToReverse);
        boolean readTextReverseAndWriteStatus =
                TaskFileWriter.writeText
                        (JAVA_COLLECTIONS_OPTIONAL_TASK1_FILE_FOR_WRITING,
                                linesAfterReverse);
        System.out.println(readTextReverseAndWriteStatus);
    }

    public static void javaCollectionsOptionalTask2() {

        System.out.println(NumberSpliterator.getNumberWithReverseDigits
                (JAVA_COLLECTIONS_OPTIONAL_TASK2_NUMBER_FOR_REVERSE));
    }

    public static void javaCollectionsOptionalTask4() {

        String readText = TaskFileReader.readAllTextInFile
                (DATA_FILE_FOR_JAVA_COLLECTIONS_OPTIONAL_TASK4);
        String[] splitText = Spliterator.
                splitReadText(readText, Spliterator.END_LINE_SPLITERATOR);

        List list = TextSorter.increaseSortByLengthLine(splitText);
        System.out.println(list);
    }
}