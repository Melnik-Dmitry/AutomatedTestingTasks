package com.epam.melnik.java.io;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConverterTest {

    @Test(expected = IllegalArgumentException.class)
    public void getDirectoryStructureAsStringWithDirectoryPathNull() throws FileNotFoundException {

        Converter.getDirectoryStructureAsString(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getDirectoryStructureAsStringWithEmptyDirectoryPath() throws FileNotFoundException {

        Converter.getDirectoryStructureAsString("");
    }

    @Test(expected = FileNotFoundException.class)
    public void getDirectoryStructureAsStringWithAbsentDirectory() throws FileNotFoundException {

        Converter.getDirectoryStructureAsString("absentDirectory");
    }

    @Test
    public void getDirectoryStructureAsString() throws FileNotFoundException {

        List<String> expectedStructure = new ArrayList<>();
        expectedStructure.add("D:\\AutomatedTestingTasks\\src\\test\\resources\\TestStructureDirectory" + "\r\n");
        expectedStructure.add("               |--FirstFile" + "\r\n");
        expectedStructure.add("               |--FirstTestDirectory" + "\r\n");
        expectedStructure.add("                  |--SecondFile" + "\r\n");

        assertEquals(expectedStructure,
                Converter.getDirectoryStructureAsString("D:\\AutomatedTestingTasks\\src\\test\\resources\\TestStructureDirectory"));
    }
}