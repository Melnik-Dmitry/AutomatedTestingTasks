/*
 * version: 1.1
 * made by Dmitry Melnik
 * 18-Jan-2020
 */

package com.epam.melnik.java.exception.entity.subject;

import java.util.Objects;

/**
 * Abstract class describes abstract entity EducationSubject
 *
 * @author Dmitry Melnik
 * @see Object
 * @see Biology
 * @see Mathematics
 * @see Literature
 */
public abstract class EducationSubject {

    private String subjectName;

    public String getSubjectName() {

        return subjectName;
    }

    public void setSubjectName(String subjectName) {

        this.subjectName = subjectName;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof EducationSubject)) {
            return false;
        }
        EducationSubject that = (EducationSubject) o;
        return getSubjectName().equals(that.getSubjectName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getSubjectName());
    }

    @Override
    public String toString() {

        return "subjectName=" + subjectName;
    }
}
