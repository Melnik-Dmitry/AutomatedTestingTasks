package com.epam.melnik.java.collections.maintask.util.initialization;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class FileParametersReaderTest {

    private String resourcePropertyFile;
    private ReadParameters parameter;
    private String[] initParamsResult;
    private FileParametersReader fileParametersReader = new FileParametersReader();

    public FileParametersReaderTest(String resourcePropertyFile,
                                    ReadParameters parameter,
                                    String[] initParamsResult) {

        this.resourcePropertyFile = resourcePropertyFile;
        this.parameter = parameter;
        this.initParamsResult = initParamsResult;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {

        return new Object[][]{
                {null, ReadParameters.AMOUNT_PEOPLE_AIRCRAFT_CREW, new String[]{""}},
                {"cargoAirPlaneInitParameters", null, new String[]{""}},
                {"cargoAirPlaneInitParameters", ReadParameters.AMOUNT_PEOPLE_AIRCRAFT_CREW,
                        new String[]{"4", "5", "6", "6", "4"}},
        };
    }

    @Test
    public void getInitParams() {

        assertArrayEquals(initParamsResult,
                fileParametersReader
                        .getInitParams(resourcePropertyFile, parameter));
    }
}