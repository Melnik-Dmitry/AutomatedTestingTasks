/*
 * version: 1.1
 * made by Dmitry Melnik
 * 18-Jan-2020
 */

package com.epam.melnik.java.exception.entity.universitystructure;

import java.util.List;
import java.util.Objects;

/**
 * Class describes entity Faculty, which contains List of StudentGroup
 *
 * @author Dmitry Melnik
 * @see Object
 * @see StudentGroup
 */
public class Faculty {

    private String name;
    private List<StudentGroup> studentGroups;

    public String getName() {

        return name;
    }

    public List<StudentGroup> getStudentGroups() {

        return studentGroups;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setStudentGroups(List<StudentGroup> studentGroups) {

        this.studentGroups = studentGroups;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Faculty)) {
            return false;
        }
        Faculty faculty = (Faculty) o;
        return getName().equals(faculty.getName()) &&
                getStudentGroups().equals(faculty.getStudentGroups());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getStudentGroups());
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name=" + name +
                " studentGroups=" + studentGroups + '}';
    }
}
