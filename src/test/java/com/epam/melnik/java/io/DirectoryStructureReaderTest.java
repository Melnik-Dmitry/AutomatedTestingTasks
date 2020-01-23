package com.epam.melnik.java.io;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DirectoryStructureReaderTest {

    @Test(expected = IllegalArgumentException.class)
    public void getFileFullStructureWithFileNull() throws FileNotFoundException {

        new DirectoryStructureReader().getFileFullStructure(null);
    }

    @Test(expected = FileNotFoundException.class)
    public void getFileFullStructureWithEmptyFile() throws FileNotFoundException {

        new DirectoryStructureReader().getFileFullStructure(new File(""));
    }

    @Test
    public void getFileFullStructure() throws FileNotFoundException {

        List<File> expectedFileStructure = new ArrayList<>();
        expectedFileStructure.add(new File("D:\\AutomatedTestingTasks\\src\\test\\resources\\TestStructureDirectory\\FirstFile"));
        expectedFileStructure.add(new File("D:\\AutomatedTestingTasks\\src\\test\\resources\\TestStructureDirectory\\FirstTestDirectory"));
        expectedFileStructure.add(new File("D:\\AutomatedTestingTasks\\src\\test\\resources\\TestStructureDirectory\\FirstTestDirectory\\SecondFile"));

        assertEquals(expectedFileStructure,
                new DirectoryStructureReader()
                        .getFileFullStructure(new File("D:\\AutomatedTestingTasks\\src\\test\\resources\\TestStructureDirectory")));
    }
}