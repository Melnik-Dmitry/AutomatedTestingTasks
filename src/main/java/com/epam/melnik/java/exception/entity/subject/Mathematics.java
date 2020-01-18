/*
 * version: 1.1
 * made by Dmitry Melnik
 * 18-Jan-2020
 */

package com.epam.melnik.java.exception.entity.subject;

import java.util.List;
import java.util.Objects;

/**
 * Class describes entity Mathematics
 *
 * @author Dmitry Melnik
 * @see Object
 * @see EducationSubject
 */
public class Mathematics extends EducationSubject {

    private List<MathConcept> basicConcept;

    public List<MathConcept> getBasicConcept() {

        return basicConcept;
    }

    public void setBasicConcept(List<MathConcept> basicConcept) {

        this.basicConcept = basicConcept;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Mathematics)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Mathematics that = (Mathematics) o;
        return getBasicConcept().equals(that.getBasicConcept());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getBasicConcept());
    }

    @Override
    public String toString() {

        return "Mathematics{" + super.toString() + " " +
                "basicConcept=" + basicConcept + "}";
    }
}
