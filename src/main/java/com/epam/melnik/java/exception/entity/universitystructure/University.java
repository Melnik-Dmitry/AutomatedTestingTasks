/*
 * version: 1.1
 * made by Dmitry Melnik
 * 18-Jan-2020
 */

package com.epam.melnik.java.exception.entity.universitystructure;

import java.util.List;
import java.util.Objects;

/**
 * Class describes entity University, which contains List of Faculty
 *
 * @author Dmitry Melnik
 * @see Object
 * @see Faculty
 */
public class University {

    private List<Faculty> faculties;

    public List<Faculty> getFaculties() {

        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {

        this.faculties = faculties;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof University)) {
            return false;
        }
        University that = (University) o;
        return getFaculties().equals(that.getFaculties());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFaculties());
    }

    @Override
    public String toString() {
        return "University{" +
                "faculties=" + faculties +
                '}';
    }
}
