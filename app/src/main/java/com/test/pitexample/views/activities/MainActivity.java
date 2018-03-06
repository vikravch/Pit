package com.test.pitexample.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.test.pitexample.R;
import com.test.pitexample.views.custom_views.PitViewGroup;

/**
 * Created by Vitalii Kravchuk on 06/03/18.
 * Skype - vitaly.kravchuk
 * Gmail - vitaly.kravchyk@gmail.com
 */
public class MainActivity extends AppCompatActivity {

    private PitViewGroup pitViewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickOnOpenPitView(View view) {
        startActivity(new Intent(this,PitViewActivity.class));
    }

    public void clickOnOpenPitInFragment(View view) {
        startActivity(new Intent(this, PitInFragmentActivity.class));
    }
}