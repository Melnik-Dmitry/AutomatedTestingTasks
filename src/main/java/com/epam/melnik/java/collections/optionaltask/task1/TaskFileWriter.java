package com.epam.melnik.java.collections.optionaltask.task1;

import java.io.*;

public class TaskFileWriter {

    public static boolean writeText(String filePath,
                                    String... text) {

        boolean writeResult = false;
        if (filePath != null) {
            if (text != null && text.length > 0) {

                try (FileWriter writer =
                             new FileWriter(filePath)) {
                    for (int i = 0; i < text.length; i++) {
                        writer.append(text[i]);
                    }
                    writer.flush();
                    writeResult = true;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return writeResult;
    }
}
