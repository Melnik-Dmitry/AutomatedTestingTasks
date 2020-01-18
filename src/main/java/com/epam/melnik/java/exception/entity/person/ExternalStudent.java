/*
 * version: 1.1
 * made by Dmitry Melnik
 * 18-Jan-2020
 */

package com.epam.melnik.java.exception.entity.person;

import java.util.Objects;

/**
 * Class describes entity ExternalStudent
 *
 * @author Dmitry Melnik
 * @see Object
 */
public class ExternalStudent extends Student {

    private int sessionDuration;

    public int getSessionDuration() {

        return sessionDuration;
    }

    public void setSessionDuration(int sessionDuration) {

        this.sessionDuration = sessionDuration;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof ExternalStudent)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        ExternalStudent that = (ExternalStudent) o;
        return getSessionDuration() == that.getSessionDuration();
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getSessionDuration());
    }

    @Override
    public String toString() {
        return "ExternalStudent{" +
                "sessionDuration=" + sessionDuration + " " +
                super.toString() + "} ";
    }
}
