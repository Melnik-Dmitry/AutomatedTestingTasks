/*
 * version: 1.1
 * made by Dmitry Melnik
 * 25-Dec-2019
 */

package com.epam.melnik.java.collections.maintask.util.initialization;

import java.io.InputStream;
import java.util.Properties;

/**
 * Util class performing reading parameters in String format
 * for initialization Aircraft from file.
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class FileParametersReader {

    public static final String INIT_PARAMETERS_ARRAY_SPLITERATOR = ",";

    /**
     * Метод выполняет чтения заначений параметра,
     * указанного в ReadParameters parameterName.
     * Если файл параметров не существует по заданному пути
     * метод возвращает String [] with single empty argument.
     *
     * @param resourcePropertyFile
     * @param parameterName
     * @return
     */
    public String[] getInitParams(String resourcePropertyFile,
                                  ReadParameters parameterName) {

        String[] initParams = this.readInitParams(resourcePropertyFile, parameterName)
                .split(INIT_PARAMETERS_ARRAY_SPLITERATOR);
        for (int i = 0; i < initParams.length; i++) {
            initParams[i] = initParams[i].trim();
        }
        return initParams;
    }

    private String readInitParams(String resourcePropertyFile,
                                  ReadParameters parameterName) {

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
