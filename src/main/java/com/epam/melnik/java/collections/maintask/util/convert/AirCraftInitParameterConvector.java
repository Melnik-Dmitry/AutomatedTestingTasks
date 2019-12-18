package com.epam.melnik.java.collections.maintask.util.convert;

import com.epam.melnik.java.collections.maintask.util.parameterinit.ReadParameters;

import java.util.regex.Pattern;

import static com.epam.melnik.java.collections.maintask.util.parameterinit.ReadParameters.*;

public class AirCraftInitParameterConvector {

    public static final String INIT_PARAMETER_INTEGER_PATTERN = "[0-9]{1,5}";
    public static final String INIT_PARAMETER_BOOLEAN_PATTERN = "true";

    public static Object convertParameter(String initParam, ReadParameters parameterName) {

        Object convertedParam = null;

        if (initParam != null) {
            if (parameterName.equals(AMOUNT_PEOPLE_AIRCRAFT_CREW)
                    || parameterName.equals(CARRYING_CAPACITY)
                    || parameterName.equals(PASSENGER_CAPACITY)
                    || parameterName.equals(FLIGHT_RANGE)
                    || parameterName.equals(FUEL_CONSUMPTION)
                    || parameterName.equals(AMOUNT_CARGO_HATCH)
                    || parameterName.equals(AMOUNT_PORTHOLE)) {
                if (Pattern.matches(INIT_PARAMETER_INTEGER_PATTERN, initParam)) {
                    convertedParam = Integer.valueOf(initParam);
                } else {
                    convertedParam = Integer.valueOf(0);
                }
            } else if (parameterName.equals(IS_THERE_BUSINESS_CLASS)) {
                if (Pattern.matches(INIT_PARAMETER_BOOLEAN_PATTERN, initParam)) {
                    convertedParam = Boolean.TRUE;
                } else {
                    convertedParam = Boolean.FALSE;
                }
            }
        }

        return convertedParam;
    }
}
