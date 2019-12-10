package com.epam.melnik.java.fundamentals.optionaltask1.util;

import java.util.Comparator;

public class NumberLengthComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        int result = 0;

        if (o1 instanceof Double && o2 instanceof Double) {
            int lengthFirstNumber = NumberLengthSearcher.getNumLength((Double) o1);
            int lengthSecondNumber = NumberLengthSearcher.getNumLength((Double) o2);

            if (lengthFirstNumber < lengthSecondNumber) {
                result = -1;
            } else if (lengthFirstNumber > lengthSecondNumber) {
                result = 1;
            }
        }
        return result;
    }
}
