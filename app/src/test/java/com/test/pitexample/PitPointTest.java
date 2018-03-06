package com.test.pitexample;

import com.test.pitexample.entities.PitPoint;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by root on 05/03/18.
 */
public class PitPointTest extends PitPoint {

    public static final int TEST_X = 200;
    public static final int TEST_Y = 150;

    public PitPointTest() {
        super(TEST_X, TEST_Y);
    }

    @Test
    public void test_1() throws Exception {
        int inputX = 190;
        int inputY = 170;

        boolean res = isClicked(inputX,inputY);

        assertTrue(res);
    }

    @Test
    public void test_2() throws Exception {
        int inputX = 0;
        int inputY = 0;

        boolean res = isClicked(inputX,inputY);

        assertFalse(res);
    }

    @Test
    public void test_3() throws Exception {
        int inputX = 190;
        int inputY = 170;

        boolean res = isClicked(inputX,inputY);

        assertTrue(res);
    }

    @Test
    public void test_4() throws Exception {
        int inputX = 190;
        int inputY = 0;

        boolean res = isClicked(inputX,inputY);

        assertFalse(res);
    }

/*    @Test
    public void test_5() throws Exception {
        PitPoint center = new PitPoint(300,80);
        System.out.println("Point - "+this.toString());
        System.out.println("Point center - "+center.toString());

        calculateQuarter(center);
        assertEquals(3,getQuarter());
    }

    @Test
    public void test_6() throws Exception {
        PitPoint center = new PitPoint(30,800);
        System.out.println("Point - "+this.toString());
        System.out.println("Point center - "+center.toString());

        calculateQuarter(center);
        assertEquals(1,getQuarter());
    }

    @Test
    public void test_7() throws Exception {
        PitPoint center = new PitPoint(80,80);
        System.out.println("Point - "+this.toString());
        System.out.println("Point center - "+center.toString());

        calculateQuarter(center);
        assertEquals(2,getQuarter());
    }

    @Test
    public void test_8() throws Exception {
        PitPoint center = new PitPoint(300,800);
        System.out.println("Point - "+this.toString());
        System.out.println("Point center - "+center.toString());

        calculateQuarter(center);
        assertEquals(4,getQuarter());
    }*/
}