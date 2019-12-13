/*
 * version: 1.1
 * made by Vitali Shulha
 * 4-Jan-2019
 */

package com.epam.melnik.java.cleancode.fixedproject.src.main.java;

import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane.Plane;

import java.util.*;

public class Airport {

    private List<? extends Plane> planes;

    public Airport() {
    }

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<? extends Plane> planes) {
        this.planes = planes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;
        Airport airport = (Airport) o;
        return getPlanes().equals(airport.getPlanes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlanes());
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    private void print(Collection<? extends Plane> collection) {
        Iterator<? extends Plane> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Plane plane = iterator.next();
            System.out.println(plane);
        }
    }
}
