package com.test.pitexample.entities;

/**
 * Created by Vitalii Kravchuk on 06/03/18.
 * Skype - vitaly.kravchuk
 * Gmail - vitaly.kravchyk@gmail.com
 */
public class PitPoint {

    public static final int RADIUS = 100;

    private int x;
    private int y;
    private int quarter = 0;

    public PitPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isClicked(float clickedX, float clickedY) {
        return (x-RADIUS<clickedX) && (x+RADIUS>clickedX) && (y-RADIUS<clickedY) && (y+RADIUS>clickedY);
    }

    public boolean lower(PitPoint pitPoint) {
        return x<pitPoint.getX();
    }

    @Override
    public boolean equals(Object obj) {
        PitPoint income = (PitPoint) obj;
        return income.x==this.x && income.y==this.y;
    }

    @Override
    public String toString() {
        return "PitPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
/*
    public int getQuarter() {
        return quarter;
    }

    private void calculateQuarter(PitPoint centerPoint) {
        if ((x>centerPoint.getX())&&(y<centerPoint.getY())){
            quarter = 1;
        } else if ((x>centerPoint.getX())&&(y>centerPoint.getY())){
            quarter = 2;
        } else if ((x<centerPoint.getX())&&(y>centerPoint.getY())){
            quarter = 3;
        } else if ((x<centerPoint.getX())&&(y<centerPoint.getY())){
            quarter = 4;
        } else {
            quarter = -1;
        }
    }*/
}
