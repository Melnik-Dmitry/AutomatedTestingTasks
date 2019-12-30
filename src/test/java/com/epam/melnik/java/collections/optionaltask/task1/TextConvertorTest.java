package com.epam.melnik.java.collections.optionaltask.task1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class TextConvertorTest {

    private String[] starText;
    private String[] reverseTextResult;

    @Parameterized.Parameters
    public static Object[][] testData() {

        return new Object[][]{
                {null, new String[0]},
                {new String[0], new String[0]},
                {new String[]{"first", "second"}, new String[]{"second", "first"}},
                {new String[]{"-1", "-2"}, new String[]{"-2", "-1"}},
                {new String[]{1 + "", "second"}, new String[]{"second", "1"}}
        };
    }

    public TextConvertorTest(String[] starText, String[] reverseTextResult) {
        this.starText = starText;
        this.reverseTextResult = reverseTextResult;
    }

    @Test
    public void reverseText() {

        assertArrayEquals(reverseTextResult, TextConvertor.reverseText(starText));
    }
}