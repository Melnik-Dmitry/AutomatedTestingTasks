package com.epam.melnik.java.collections.maintask.util.convertation;

import com.epam.melnik.java.collections.maintask.util.initialization.ReadParameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class AirCraftInitParameterConverterTest {

    private String initParam;
    private ReadParameters parameter;
    private Object convertResult;

    public AirCraftInitParameterConverterTest(String initParam,
                                              ReadParameters parameter,
                                              Object convertResult) {

        this.initParam = initParam;
        this.parameter = parameter;
        this.convertResult = convertResult;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {

        return new Object[][]{
                {null, ReadParameters.AMOUNT_PEOPLE_AIRCRAFT_CREW, null},
                {"", ReadParameters.AMOUNT_PEOPLE_AIRCRAFT_CREW, Integer.valueOf(0)},
                {"-156", ReadParameters.AMOUNT_PEOPLE_AIRCRAFT_CREW, Integer.valueOf(0)},
                {"15", ReadParameters.AMOUNT_PEOPLE_AIRCRAFT_CREW, Integer.valueOf(15)},
                {"test", ReadParameters.AMOUNT_PEOPLE_AIRCRAFT_CREW, Integer.valueOf(0)},
                {"", ReadParameters.IS_THERE_BUSINESS_CLASS, Boolean.FALSE},
                {"NotTrue", ReadParameters.IS_THERE_BUSINESS_CLASS, Boolean.FALSE},
                {"true", ReadParameters.IS_THERE_BUSINESS_CLASS, Boolean.TRUE},
                {"TRUE", ReadParameters.IS_THERE_BUSINESS_CLASS, Boolean.TRUE},
        };
    }

    @Test
    public void convertParameter() {

        assertEquals(convertResult, AirCraftInitParameterConverter.convertParameter(initParam, parameter));
    }
}