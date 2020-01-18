/*
 * version: 1.1
 * made by Dmitry Melnik
 * 18-Jan-2020
 */

package com.epam.melnik.java.exception.entity.subject;

import java.util.List;
import java.util.Objects;

/**
 * Class describes entity Biology
 *
 * @author Dmitry Melnik
 * @see Object
 * @see EducationSubject
 */
public class Biology extends EducationSubject {

    List<BiologyStudyDirection> studyDirections;

    public List<BiologyStudyDirection> getStudyDirections() {

        return studyDirections;
    }

    public void setStudyDirections(List<BiologyStudyDirection> studyDirections) {

        this.studyDirections = studyDirections;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Biology)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Biology biology = (Biology) o;
        return getStudyDirections().equals(biology.getStudyDirections());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getStudyDirections());
    }

    @Override
    public String toString() {
        return "Biology{" + super.toString() + " " +
                "studyDirections=" + studyDirections + "}";
    }
}
