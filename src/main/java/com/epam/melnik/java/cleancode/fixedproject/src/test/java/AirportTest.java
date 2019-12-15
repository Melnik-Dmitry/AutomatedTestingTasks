package com.epam.melnik.java.cleancode.fixedproject.src.test.java;

import com.epam.melnik.java.cleancode.fixedproject.src.main.java.Airport;
import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane.ExperimentalPlane;
import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane.MilitaryPlane;
import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane.PassengerPlane;
import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.entity.plane.Plane;
import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.planetype.ClassificationLevel;
import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.planetype.ExperimentalType;
import com.epam.melnik.java.cleancode.fixedproject.src.main.java.model.planetype.MilitaryType;
import com.epam.melnik.java.cleancode.fixedproject.src.main.java.util.AirportPlaneSorter;
import com.epam.melnik.java.cleancode.fixedproject.src.main.java.util.PlaneSearcher;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AirportTest {

    private static Airport airport;
    private static PassengerPlane planeWithMaxPassengerCapacity;
    private static PlaneSearcher<Plane> planeSearcher;
    private static AirportPlaneSorter airportPlaneSorter;
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET)
    );

    @BeforeMethod
    public void setUp() {

        airport = new Airport(planes);
        planeWithMaxPassengerCapacity = new PassengerPlane
                ("Boeing-747", 980, 16100, 70500, 242);
        planeSearcher = new PlaneSearcher<>();
        airportPlaneSorter = new AirportPlaneSorter();
    }

    @Test
    public void testGetTransportMilitaryPlanes() {

        List<MilitaryPlane> transportMilitaryPlanes =
                planeSearcher.getTransportMilitaryPlanes((List<Plane>) airport.getPlanes());
        boolean flagIsTransportMilitaryPlanes = false;
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            if ((militaryPlane.getType() == MilitaryType.TRANSPORT)) {
                flagIsTransportMilitaryPlanes = true;
                break;
            }
        }
        Assert.assertEquals(flagIsTransportMilitaryPlanes, true);
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {

        PassengerPlane expectedPlaneWithMaxPassengersCapacity = planeSearcher
                .getPassengerPlaneWithMaxPassengersCapacity((List<Plane>) airport.getPlanes());
        Assert.assertTrue(expectedPlaneWithMaxPassengersCapacity.equals(planeWithMaxPassengerCapacity));
    }

    @Test
    public void testSortByMaxLoadCapacity() {

        airportPlaneSorter.sortByMaxLoadCapacity(airport);
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();

        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
//            if (currentPlane.getMinLoadCapacity() > nextPlane.getMinLoadCapacity()) {
            if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            }
        }
        Assert.assertTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {

        List<MilitaryPlane> bomberMilitaryPlanes =
                planeSearcher.getBomberMilitaryPlanes((List<Plane>) airport.getPlanes());
        boolean flagHasAtLeastOneBomberInMilitaryPlanes = false;
        for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) {
            if ((militaryPlane.getType() == MilitaryType.BOMBER)) {
                flagHasAtLeastOneBomberInMilitaryPlanes = true;
                break;
            } else {
                Assert.fail("Test failed!");
            }
        }
        Assert.assertEquals(flagHasAtLeastOneBomberInMilitaryPlanes, true);
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified() {

        List<ExperimentalPlane> ExperimentalPlanes =
                planeSearcher.getExperimentalPlanes((List<Plane>) airport.getPlanes());
        boolean hasUnclassifiedPlanes = false;
        for (ExperimentalPlane experimentalPlane : ExperimentalPlanes) {
            if (experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED) {
                hasUnclassifiedPlanes = true;
                break;
            }
        }
        Assert.assertFalse(hasUnclassifiedPlanes);
    }
}
