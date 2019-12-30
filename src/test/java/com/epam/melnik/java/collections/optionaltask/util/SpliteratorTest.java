package com.epam.melnik.java.collections.optionaltask.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class SpliteratorTest {

    private String startText;
    private String spliterator;
    private String[] splitTextResult;
    private String[] splitTextForReverseResult;

    @Parameterized.Parameters
    public static Object[][] testData() {

        return new Object[][]{
                {null, "\r\n", new String[0], new String[0]},
                {"", "\r\n", new String[0], new String[0]},
                {"Test\r\nTest\r\n", null, new String[0], new String[0]},
                {"Test\r\nTest\r\n", "\r\n", new String[]{"Test", "Test"}, new String[]{"Test", "Test\r\n"}},
        };
    }

    public SpliteratorTest(String startText,
                           String spliterator,
                           String[] splitTextResult,
                           String[] splitTextForReverseResult) {

        this.startText = startText;
        this.spliterator = spliterator;
        this.splitTextResult = splitTextResult;
        this.splitTextForReverseResult = splitTextForReverseResult;
    }

    @Test
    public void splitReadText() {

        assertArrayEquals(splitTextResult, Spliterator.splitReadText(startText, spliterator));
    }

    @Test
    public void splitReadTextForReverse() {

        assertArrayEquals(splitTextForReverseResult, Spliterator.splitReadTextForReverse(startText, spliterator));
    }
}