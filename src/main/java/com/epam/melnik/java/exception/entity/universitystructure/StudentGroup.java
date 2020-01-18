/*
 * version: 1.1
 * made by Dmitry Melnik
 * 18-Jan-2020
 */

package com.epam.melnik.java.exception.entity.universitystructure;

import com.epam.melnik.java.exception.entity.person.Student;

import java.util.List;
import java.util.Objects;

/**
 * Class describes entity Faculty, which contains List of Student
 *
 * @author Dmitry Melnik
 * @see Object
 * @see Student
 */
public class StudentGroup {

    private int groupNumber;
    private List<Student> groupStudents;

    public int getGroupNumber() {

        return groupNumber;
    }

    public List<Student> getGroupStudents() {

        return groupStudents;
    }

    public void setGroupNumber(int groupNumber) {

        this.groupNumber = groupNumber;
    }

    public void setGroupStudents(List<Student> groupStudents) {

        this.groupStudents = groupStudents;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof StudentGroup)) {
            return false;
        }
        StudentGroup that = (StudentGroup) o;
        return getGroupNumber() == that.getGroupNumber() &&
                getGroupStudents().equals(that.getGroupStudents());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getGroupNumber(), getGroupStudents());
    }

    @Override
    public String toString() {

        return "StudentGroup{" +
                "groupNumber=" + groupNumber +
                ", groupStudents=" + groupStudents +
                '}';
    }
}
