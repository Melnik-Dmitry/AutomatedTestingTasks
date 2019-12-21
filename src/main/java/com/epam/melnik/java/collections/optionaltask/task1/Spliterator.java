package com.epam.melnik.java.collections.optionaltask.task1;

public class Spliterator {

    public static final String END_LINE_SPLITERATOR = "\\.\r\n"; //|\.\s|\.
//    public static final String END_SENTENCE_SPLITERATOR = "\\.\r\n|\\.\\s|\\.";

    public static String[] splitReadText(String text) {

        String[] splitedText = new String[0];

        if (text != null && !text.isEmpty()) {
            splitedText = text.split(END_LINE_SPLITERATOR);
            splitedText = fillLinesWithSplitedSymbols(splitedText);
        }

        return splitedText;
    }

    private static String[] fillLinesWithSplitedSymbols(String[] text) {

        text[text.length - 1] += "\r\n";
        for (int i = text.length - 2; i > 0; i--) {
            text[i] += ".\r\n";
        }
        text[0] += ".";

        return text;
    }
}
