package com.test.pitexample.views.activities;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.pitexample.R;
import com.test.pitexample.entities.PitPoint;
import com.test.pitexample.views.custom_views.PitPointView;
import com.test.pitexample.views.custom_views.PitViewGroup;

import java.util.ArrayList;

/**
 * Created by Vitalii Kravchuk on 06/03/18.
 * Skype - vitaly.kravchuk
 * Gmail - vitaly.kravchyk@gmail.com
 */
public class PitInFragmentActivityFragment extends Fragment {

    private PitViewGroup pitViewGroup;
    private ArrayList<PitPoint> defaultPoints;

    public PitInFragmentActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pit_in_fragment, container, false);
        pitViewGroup = view.findViewById(R.id.pitInFragment);
        initDefaultPoints();
        pitViewGroup.setPoints(defaultPoints);
        return view;
    }

    private void initDefaultPoints() {
        defaultPoints = new ArrayList<>();
        defaultPoints.add(new PitPoint(200,100));
        defaultPoints.add(new PitPoint(400,800));
        defaultPoints.add(new PitPoint(500,130));
    }

    public void addPoint(){
        pitViewGroup.addNewPoint();
    }
}