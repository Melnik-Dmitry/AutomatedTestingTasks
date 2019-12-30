package com.epam.melnik.java.collections.optionaltask.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class TaskFileWriterTest {

    private String filePath;
    private String[] textForWriting;
    private boolean writeTextResult;

    @Parameterized.Parameters
    public static Object[][] testData() {

        return new Object[][]{
                {null, new String[]{"Text For Writing"}, false},
                {"", new String[]{"Text For Writing"}, false},
                {"testFileWriting.txt", null, false}
        };
    }

    public TaskFileWriterTest(String filePath,
                              String[] textForWriting,
                              boolean writeTextResult) {

        this.filePath = filePath;
        this.textForWriting = textForWriting;
        this.writeTextResult = writeTextResult;
    }

    @Test
    public void writeText() {

        assertEquals(writeTextResult, TaskFileWriter.writeText(filePath, textForWriting));
    }
}