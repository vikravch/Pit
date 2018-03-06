package com.test.pitexample.managers;

import android.content.Context;
import android.view.ViewGroup;

import com.test.pitexample.entities.PitPoint;
import com.test.pitexample.utils_properties.L;
import com.test.pitexample.views.custom_views.PitPointView;

import java.util.ArrayList;

/**
 * Created by Vitalii Kravchuk on 06/03/18.
 * Skype - vitaly.kravchuk
 * Gmail - vitaly.kravchyk@gmail.com
 */
public class PointManager {

    private ArrayList<PitPoint> pointsMath;

    public ArrayList<PitPoint> getPointsMath() {
        return pointsMath;
    }

    public void setPointsMath(ArrayList<PitPoint> pointsMath) {
        this.pointsMath = pointsMath;
    }

    public int getPointIdByCoord(float x, float y) {
        int result = -1;
        if (pointsMath==null) return -1;
        for (PitPoint pitPoint:pointsMath){
            if (pitPoint.isClicked(x,y)) {
                result=pointsMath.indexOf(pitPoint);
                L.print(this,"Click detected - "+result);
            }
        }
        return result;
    }

    public void sortByX(){
        if (pointsMath.size()<2) return;
        if ((pointsMath.size()==2)&&(!pointsMath.get(0).lower(pointsMath.get(1)))){
            swap(0,1);
        }
        for (int i = 0; i < pointsMath.size(); i++) {
            for (int j = 1; j < pointsMath.size(); j++) {
                if (!pointsMath.get(j - 1).lower(pointsMath.get(j))) {
                    swap(j-1,j);
                }
            }
        }
    }

    private void swap(int a, int b) {
        PitPoint pointA = pointsMath.get(a);
        PitPoint pointB = pointsMath.get(b);
        pointsMath.set(a, pointB);
        pointsMath.set(b, pointA);
        pointA = null;
        pointB = null;
    }

    public ArrayList<PitPointView> initPoints(Context context) {
        ArrayList<PitPointView> result = new ArrayList<>();
        for (PitPoint pitPoint:pointsMath){
            PitPointView pointView = new PitPointView(context);
            pointView.setLayoutParams(new ViewGroup.LayoutParams(PitPoint.RADIUS,PitPoint.RADIUS));
            pointView.setCoord(pitPoint.getX(),pitPoint.getY());
            result.add(pointView);
        }
        return result;
    }
}