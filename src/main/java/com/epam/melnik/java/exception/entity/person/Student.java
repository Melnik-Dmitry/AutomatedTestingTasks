/*
 * version: 1.1
 * made by Dmitry Melnik
 * 18-Jan-2020
 */

package com.epam.melnik.java.exception.entity.person;

import java.util.Map;
import java.util.Objects;

/**
 * Abstract class describes abstract entity Student
 *
 * @author Dmitry Melnik
 * @see Object
 * @see ExternalStudent
 * @see FullTimeStudent
 */
public abstract class Student {

    private String secondName;
    private StudentStatus status;
    private Map<String, Double> educationSubjectAverageGrades;

    public String getSecondName() {

        return secondName;
    }

    public StudentStatus getStatus() {

        return status;
    }

    public Map<String, Double> getEducationSubjectAverageGrades() {

        return educationSubjectAverageGrades;
    }

    public void setSecondName(String secondName) {

        this.secondName = secondName;
    }

    public void setStatus(StudentStatus status) {

        this.status = status;
    }

    public void setEducationSubjectAverageGrades(Map<String, Double> educationSubjectAverageGrades) {

        this.educationSubjectAverageGrades = educationSubjectAverageGrades;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return getSecondName().equals(student.getSecondName()) &&
                getStatus() == student.getStatus() &&
                getEducationSubjectAverageGrades().equals(student.getEducationSubjectAverageGrades());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getSecondName(), getStatus(), getEducationSubjectAverageGrades());
    }

    @Override
    public String toString() {

        return "secondName=" + secondName +
                ", status=" + status +
                ", educationSubjectAverageGrades=" + educationSubjectAverageGrades;
    }
}
