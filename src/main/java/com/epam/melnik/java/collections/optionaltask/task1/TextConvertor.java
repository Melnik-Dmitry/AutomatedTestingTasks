package com.epam.melnik.java.collections.optionaltask.task1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TextConvertor {

    public static String[] reverseText(String[] text) {

        List<String> reverseText = new ArrayList<>();
        if (text != null && text.length > 0) {
            Deque<String> deque = putStartText(text);
            String currentSentence = deque.pollLast();
            while (currentSentence != null) {
                reverseText.add(currentSentence);
                currentSentence = deque.pollLast();
            }
        }

        return reverseText.toArray(new String[0]);
    }

    private static Deque<String> putStartText(String[] text) {

        Deque<String> stringQueue = new ArrayDeque<>();
        for (int i = 0; i < text.length; i++) {
            stringQueue.add(text[i]);
        }

        return stringQueue;
    }
}
