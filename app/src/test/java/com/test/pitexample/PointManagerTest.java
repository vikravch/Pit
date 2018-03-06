package com.test.pitexample;

import com.test.pitexample.entities.PitPoint;
import com.test.pitexample.managers.PointManager;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by root on 05/03/18.
 */
public class PointManagerTest extends PointManager {

    @Test
    public void test_1() throws Exception {

        PitPoint point1 = new PitPoint(300,300);
        PitPoint point2 = new PitPoint(100,600);
        PitPoint point3 = new PitPoint(800,600);
        PitPoint point4 = new PitPoint(50,300);

        ArrayList<PitPoint> pointsBefore = new ArrayList<>();
        pointsBefore.add(point1);
        pointsBefore.add(point2);
        pointsBefore.add(point3);
        pointsBefore.add(point4);

        ArrayList<PitPoint> pointsAfter = new ArrayList<>();
        pointsAfter.add(point4);
        pointsAfter.add(point2);
        pointsAfter.add(point1);
        pointsAfter.add(point3);

        setPointsMath(pointsBefore);
        sortByX();
        ArrayList<PitPoint> result = getPointsMath();

        System.out.println("Before - "+pointsBefore.toString());
        System.out.println("Res - "+result.toString());
        assertArrayEquals(result.toArray(),pointsAfter.toArray());
    }

    @Test
    public void test_2() throws Exception {

        PitPoint point1 = new PitPoint(300,300);
        PitPoint point2 = new PitPoint(100,600);
        PitPoint point3 = new PitPoint(800,600);
        PitPoint point4 = new PitPoint(50,300);

        ArrayList<PitPoint> pointsBefore = new ArrayList<>();
        pointsBefore.add(point1);

        ArrayList<PitPoint> pointsAfter = new ArrayList<>();
        pointsAfter.add(point1);

        setPointsMath(pointsBefore);
        sortByX();
        ArrayList<PitPoint> result = getPointsMath();

        System.out.println("Before - "+pointsBefore.toString());
        System.out.println("Res - "+result.toString());
        assertArrayEquals(result.toArray(),pointsAfter.toArray());
    }

    @Test
    public void test_3() throws Exception {

        PitPoint point1 = new PitPoint(300,300);
        PitPoint point2 = new PitPoint(100,600);
        PitPoint point3 = new PitPoint(800,600);
        PitPoint point4 = new PitPoint(50,300);

        ArrayList<PitPoint> pointsBefore = new ArrayList<>();
        pointsBefore.add(point1);
        pointsBefore.add(point2);

        ArrayList<PitPoint> pointsAfter = new ArrayList<>();
        pointsAfter.add(point2);
        pointsAfter.add(point1);

        setPointsMath(pointsBefore);
        sortByX();
        ArrayList<PitPoint> result = getPointsMath();

        System.out.println("Before - "+pointsBefore.toString());
        System.out.println("Res - "+result.toString());
        assertArrayEquals(result.toArray(),pointsAfter.toArray());
    }

}