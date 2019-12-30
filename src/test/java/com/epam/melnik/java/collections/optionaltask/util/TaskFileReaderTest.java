package com.epam.melnik.java.collections.optionaltask.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class TaskFileReaderTest {

    private String filePath;
    private String readTextResult;

    @Parameterized.Parameters
    public static Object[][] testData() {

        return new Object[][]{
                {null, ""},
                {"", ""},
                {"javaCollectionsOptionalTask1File.txt",
                        "First Sentence.\r\nSecond Sentence.\r\nThird Sentence."}
        };
    }

    public TaskFileReaderTest(String filePath,
                              String readTextResult) {
        this.filePath = filePath;
        this.readTextResult = readTextResult;
    }

    @Test
    public void readAllTextInFile() {

        assertEquals(readTextResult, TaskFileReader.readAllTextInFile(filePath));
    }
}