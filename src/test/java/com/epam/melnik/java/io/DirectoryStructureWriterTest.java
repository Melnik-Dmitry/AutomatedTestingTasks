package com.epam.melnik.java.io;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class DirectoryStructureWriterTest {

    @Test(expected = IllegalArgumentException.class)
    public void writeDirectoryPathNull() throws FileNotFoundException {

        DirectoryStructureWriter.write("WriteDirectoryStructureTestFile", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void writeWithEmptyDirectoryPath() throws FileNotFoundException {

        DirectoryStructureWriter.write("WriteDirectoryStructureTestFile", "");
    }

    @Test(expected = FileNotFoundException.class)
    public void writeWithAbsentDirectoryPath() throws FileNotFoundException {

        DirectoryStructureWriter.write("WriteDirectoryStructureTestFile",
                "absentDirectory");
    }

    @Test
    public void write() throws FileNotFoundException {

        assertEquals(true,
                DirectoryStructureWriter.write("WriteDirectoryStructureTestFile",
                        "D:\\AutomatedTestingTasks\\src\\test\\resources\\TestStructureDirectory"));
    }
}