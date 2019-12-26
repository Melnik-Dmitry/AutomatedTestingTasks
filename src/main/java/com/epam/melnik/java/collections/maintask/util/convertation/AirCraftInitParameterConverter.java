/*
 * version: 1.1
 * made by Dmitry Melnik
 * 25-Dec-2019
 */

package com.epam.melnik.java.collections.maintask.util.convertation;

import com.epam.melnik.java.collections.maintask.util.initialization.ReadParameters;

import java.util.regex.Pattern;

import static com.epam.melnik.java.collections.maintask.util.initialization.ReadParameters.*;

/**
 * Util class performing conversion from
 * String parameter to Object
 *
 * @author Dmitry Melnik
 * @see Object
 * @see ReadParameters
 */
public class AirCraftInitParameterConverter {

    public static final String INIT_PARAMETER_INTEGER_PATTERN = "[0-9]{1,5}";
    public static final String INIT_PARAMETER_BOOLEAN_PATTERN = "true";

    /**
     * Method converts a parameter from a string representation to an Object,
     * according to ENUM ReadParameters
     *
     * @param initParam
     * @param parameterName
     * @return Object
     */
    public static Object convertParameter(String initParam,
                                          ReadParameters parameterName) {

        Object convertedParameter = null;

        if (initParam != null) {
            if (parameterName == AMOUNT_PEOPLE_AIRCRAFT_CREW
                    || parameterName == CARRYING_CAPACITY
                    || parameterName == PASSENGER_CAPACITY
                    || parameterName == FLIGHT_RANGE
                    || parameterName == FUEL_CONSUMPTION
                    || parameterName == AMOUNT_CARGO_HATCH
                    || parameterName.equals(AMOUNT_PORTHOLE)) {
                if (Pattern.matches(INIT_PARAMETER_INTEGER_PATTERN, initParam)) {
                    convertedParameter = Integer.valueOf(initParam);
                } else {
                    convertedParameter = Integer.valueOf(0);
                }
            } else if (parameterName == IS_THERE_BUSINESS_CLASS) {
                initParam = initParam.toLowerCase();
                if (Pattern.matches(INIT_PARAMETER_BOOLEAN_PATTERN, initParam)) {
                    convertedParameter = Boolean.TRUE;
                } else {
                    convertedParameter = Boolean.FALSE;
                }
            }
        }

        return convertedParameter;
    }
}
