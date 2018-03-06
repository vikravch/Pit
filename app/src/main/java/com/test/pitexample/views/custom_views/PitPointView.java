package com.test.pitexample.views.custom_views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.test.pitexample.entities.PitPoint;
import com.test.pitexample.utils_properties.Paints;

/**
 * Created by Vitalii Kravchuk on 06/03/18.
 * Skype - vitaly.kravchuk
 * Gmail - vitaly.kravchyk@gmail.com
 */
public class PitPointView extends View {

    private PitPoint pitPoint = new PitPoint(10,10);
    private Paint pointPaint;

    public PitPointView(Context context) {
        this(context,null,0);
    }

    public PitPointView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PitPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        pointPaint = Paints.getPaint(Paints.PAINT_POINT);
    }

    public int getCoordX() {
        return pitPoint.getX();
    }

    public int getCoordY() {
        return pitPoint.getY();
    }

    public PitPoint getPitPoint() {
        return pitPoint;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(PitPoint.RADIUS/2,PitPoint.RADIUS/2,PitPoint.RADIUS/4,pointPaint);
    }

    /**
     * <p>Set position for point. If it not called, position will be (10px,10px)</p>
     * @param x - x position of point
     * @param y - y position of point
     */
    public void setCoord(int x,int y){
        pitPoint = new PitPoint(x,y);
    }
}