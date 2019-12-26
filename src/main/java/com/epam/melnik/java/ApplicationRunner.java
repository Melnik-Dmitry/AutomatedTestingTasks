package com.epam.melnik.java;

import com.epam.melnik.java.collections.maintask.model.entity.airline.Airline;
import com.epam.melnik.java.collections.optionaltask.task4.TextSorter;
import com.epam.melnik.java.collections.optionaltask.util.Spliterator;
import com.epam.melnik.java.collections.optionaltask.task2.NumberSpliterator;
import com.epam.melnik.java.collections.optionaltask.util.TaskFileReader;
import com.epam.melnik.java.collections.optionaltask.util.TaskFileWriter;
import com.epam.melnik.java.collections.optionaltask.task1.TextConvertor;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ApplicationRunner {

    public static final Logger APP_LOGGER = LogManager.getLogger(ApplicationRunner.class);

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

    public static void main(String[] args) {

//        javaFundamentalsMainTask(args);
//        javaFundamentalsOptionalTask1();
//        javaCollectionsMainTask();
//        javaCollectionsOptionalTask1();
//        javaCollectionsOptionalTask2();
        javaCollectionsOptionalTask4();
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

    public static void javaCollectionsMainTask() {

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
