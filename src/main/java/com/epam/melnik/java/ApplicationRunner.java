package com.epam.melnik.java;

import com.epam.melnik.java.collections.maintask.entity.airline.Airline;
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

public class ApplicationRunner {

    public static void main(String[] args) {

//        javaFundamentalsMainTask(args);
//        javaFundamentalsOptionalTask1();
        javaCollectionsMainTask();
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

    public static void javaCollectionsMainTask (){

        Airline airline = new Airline();
        System.out.println(airline);
        System.out.println
                (airline.getOffice().sortAirParkByFuelConsumption(airline.getAirCrafts()));
    }
}
