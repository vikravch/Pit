package com.test.pitexample.utils_properties;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Vitalii Kravchuk on 06/03/18.
 * Skype - vitaly.kravchuk
 * Gmail - vitaly.kravchyk@gmail.com
 */

public class Paints {

    public static final int PAINT_POINT_LINE = 0;
    private static final int POINT_LINE_COLOR = Color.BLACK;

    public static final int PAINT_AXIS_LINE = 1;
    private static final int AXIS_LINE_COLOR = Color.RED;

    public static final int PAINT_DIRECT_LINE = 2;
    private static final int DIRECT_LINE_COLOR = Color.BLUE;

    public static final int PAINT_POINT = 3;
    private static final int POINT_COLOR = Color.RED;

    private static final float LINE_STROKE = 5;


    public static Paint getPaint(int type){
        Paint res = new Paint();

        if (type!= PAINT_POINT) res.setStrokeWidth(LINE_STROKE);

        switch (type){
            case PAINT_POINT_LINE:
                res.setColor(POINT_LINE_COLOR);
                break;
            case PAINT_AXIS_LINE:
                res.setColor(AXIS_LINE_COLOR);
                break;
            case PAINT_DIRECT_LINE:
                res.setColor(DIRECT_LINE_COLOR);
                break;
            case PAINT_POINT:
                res.setColor(POINT_COLOR);
                break;
        }
        return res;
    }
}
