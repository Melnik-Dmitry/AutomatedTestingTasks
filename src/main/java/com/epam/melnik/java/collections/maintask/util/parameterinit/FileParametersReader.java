package com.epam.melnik.java.collections.maintask.util.parameterinit;

import java.io.InputStream;
import java.util.Properties;

public class FileParametersReader {

    public static final String INIT_PARAMETERS_ARRAY_SPLITERATOR = ",";

    public String[] getInitParams(String resourcePropertyFile, ReadParameters parameterName) {

        String[] initParams = readInitParams(resourcePropertyFile, parameterName)
                .split(INIT_PARAMETERS_ARRAY_SPLITERATOR);
        for (int i = 0; i < initParams.length; i++) {
            initParams[i] = initParams[i].trim();
        }
        return initParams;
    }

    private String readInitParams(String resourcePropertyFile, ReadParameters parameterName) {

        String initParams = "";

        if (resourcePropertyFile != null &&
                parameterName != null &&
                !resourcePropertyFile.isEmpty()) {
            try (InputStream input = this.getClass()
                    .getClassLoader().getResourceAsStream(resourcePropertyFile)) {
                if (input != null) {

                    Properties properties = new Properties();
                    properties.load(input);

                    initParams = properties.getProperty(parameterName.getParameterName());
                }
            } catch (Exception e) {
                System.out.println(e.getCause().getMessage());
//                TO DO logger
            }
        }
        return initParams;
    }
}
