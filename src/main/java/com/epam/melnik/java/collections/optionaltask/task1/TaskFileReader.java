package com.epam.melnik.java.collections.optionaltask.task1;

import java.io.IOException;
import java.io.InputStream;

import static com.epam.melnik.java.ApplicationRunner.APP_LOGGER;

public class TaskFileReader {

    public static String readAllTextInFile(String filePath) {

        StringBuilder builder = new StringBuilder();

        if (filePath != null && !filePath.isEmpty()) {

            InputStream inputStream =
                    TaskFileReader.class.getClassLoader().getResourceAsStream(filePath);

            if (inputStream != null) {
                int currentSymbol = 0;
                try {
                    currentSymbol = inputStream.read();
                    while (currentSymbol != -1) {
                        builder.append((char) currentSymbol);
                        currentSymbol = inputStream.read();
                    }
                } catch (IOException e) {
                    APP_LOGGER.catching(e);
                }
            } else {
                APP_LOGGER.catching(new IOException());
            }
        }

        return builder.toString();
    }
}
