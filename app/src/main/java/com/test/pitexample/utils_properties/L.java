package com.test.pitexample.utils_properties;

import android.util.Log;

/**
 * Created by Vitalii Kravchuk on 06/03/18.
 * Skype - vitaly.kravchuk
 * Gmail - vitaly.kravchyk@gmail.com
 */

public class L {
    private static final boolean ENABLE_LOGGING = true;
    private static final String LOG_TAG = "PitApp";

    public static void print(Object classL, String masssage){
        if (ENABLE_LOGGING) {
            Log.d(LOG_TAG,"Pit "+classL.getClass().getSimpleName()+": "+masssage);
        }
    }
}
