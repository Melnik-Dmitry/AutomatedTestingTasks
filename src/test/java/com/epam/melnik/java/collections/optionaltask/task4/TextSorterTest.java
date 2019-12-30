package com.epam.melnik.java.collections.optionaltask.task4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class TextSorterTest {

    private String[] startStrings;
    private List<String> increaseSortStringsResult;

    @Parameterized.Parameters
    public static Object[][] testData() {

        return new Object[][]{
                {new String[]{"first\r\n", "second\r\n", "third\r\n"},
                        Arrays.asList(new String[]{"first\r\n", "third\r\n", "second\r\n"})},
                {new String[0], new ArrayList<String>()},
                {null, new ArrayList<String>()}

        };
    }

    public TextSorterTest(String[] startStrings,
                          List<String> increaseSortStringsResult) {

        this.startStrings = startStrings;
        this.increaseSortStringsResult = increaseSortStringsResult;
    }

    @Test
    public void increaseSortByLengthLine() {

        assertEquals(increaseSortStringsResult, TextSorter.increaseSortByLengthLine(startStrings));
    }
}