/*
 * version: 1.1
 * made by Dmitry Melnik
 * 18-Jan-2020
 */

package com.epam.melnik.java.exception.entity.person;

import java.util.Objects;

/**
 * Class describes entity FullTimeStudent
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class FullTimeStudent extends Student {

    private boolean ifStudyCostFree;

    public boolean isIfStudyCostFree() {

        return ifStudyCostFree;
    }

    public void setIfStudyCostFree(boolean ifStudyCostFree) {

        this.ifStudyCostFree = ifStudyCostFree;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof FullTimeStudent)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        FullTimeStudent that = (FullTimeStudent) o;
        return isIfStudyCostFree() == that.isIfStudyCostFree();
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), isIfStudyCostFree());
    }

    @Override
    public String toString() {

        return "FullTimeStudent{" +
                "ifStudyCostFree=" + ifStudyCostFree + " " + super.toString() + "} ";
    }
}
