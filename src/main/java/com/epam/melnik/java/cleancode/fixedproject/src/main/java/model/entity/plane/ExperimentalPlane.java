package com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane;

import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.modelEnums.ClassificationLevel;
import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.modelEnums.ExperimentalType;

import java.util.Objects;

public class ExperimentalPlane extends Plane {

    private ExperimentalType experimentalType;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane() {
    }

    public ExperimentalPlane(String model,
                             int maxSpeed,
                             int maxFlightDistance,
                             int maxLoadCapacity,
                             ExperimentalType experimentalType,
                             ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = experimentalType;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    public ExperimentalType getExperimentalType() {
        return experimentalType;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel) {
        this.classificationLevel = classificationLevel;
    }

    public void setExperimentalType(ExperimentalType experimentalType) {
        this.experimentalType = experimentalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperimentalPlane)) return false;
        if (!super.equals(o)) return false;
        ExperimentalPlane that = (ExperimentalPlane) o;
        return getExperimentalType() == that.getExperimentalType() &&
                getClassificationLevel() == that.getClassificationLevel();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getExperimentalType(), getClassificationLevel());
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", experimentalType=" + experimentalType
                        + ", classificationLevel=" + classificationLevel
                        + '}');
    }
}
