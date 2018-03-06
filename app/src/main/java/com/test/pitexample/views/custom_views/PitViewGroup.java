package com.test.pitexample.views.custom_views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.test.pitexample.entities.PitPoint;
import com.test.pitexample.managers.PointManager;
import com.test.pitexample.utils_properties.L;
import com.test.pitexample.utils_properties.Paints;

import java.util.ArrayList;

/**
 * Created by Vitalii Kravchuk on 06/03/18.
 * Skype - vitaly.kravchuk
 * Gmail - vitaly.kravchyk@gmail.com
 */

public class PitViewGroup extends ViewGroup{

    private int viewWidth;
    private int viewHeight;

    private int currentPoint =-1;

    private PointManager pointManager;
    private boolean showAxeLines = false;

    private Paint paintPointLine;
    private Paint paintDirectLine;
    private Paint paintAxisLine;
    //---------------------------------------------------------------------------------onTouch-event

    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            float x = event.getX();
            float y = event.getY();
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    currentPoint = pointManager.getPointIdByCoord(x,y);
                    if (currentPoint!= -1){
                        showAxeLines = true;
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (currentPoint!=-1){
                        L.print(this,"Move to x - "+x+" y - "+y+"");
                        reloadPoints((int) x,(int) y,false);
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    if (currentPoint!=-1){
                        L.print(this,"Save point - "+x+" y - "+y);
                        showAxeLines = false;
                        reloadPoints((int) x,(int) y,true);
                    }
                    break;
            }
            return true;
        }
    };

    private void reloadPoints(int x, int y, boolean isNeedSort) {
        if (currentPoint>=0){
            PitPoint currentPitPoint = pointManager.getPointsMath().get(currentPoint);
            currentPitPoint.setX(x);
            currentPitPoint.setY(y);
        }
        if (isNeedSort) pointManager.sortByX();
        setPointsView(pointManager.initPoints(getContext()));
    }

    private void setPointsView(ArrayList<PitPointView> points) {
        this.detachAllViewsFromParent();
        for (View pointView:points) {
            this.addView(pointView);
        }
        invalidate();
    }

    //----------------------------------------------------------------constructors-and-init-function

    public PitViewGroup(Context context) {
        this(context, null, 0);
    }

    public PitViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PitViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayoutParams();
    }

    private void initLayoutParams() {
        setBackgroundColor(Color.WHITE);
        pointManager = new PointManager();

        paintPointLine = Paints.getPaint(Paints.PAINT_POINT_LINE);
        paintAxisLine = Paints.getPaint(Paints.PAINT_AXIS_LINE);
        paintDirectLine = Paints.getPaint(Paints.PAINT_DIRECT_LINE);

        L.print(this,"width - "+ viewWidth +" height "+ viewHeight);
        setOnTouchListener(onTouchListener);
    }

    //--------------------------------------------------------------------------view-cicle-functions

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        viewWidth = MeasureSpec.getSize(widthMeasureSpec);
        viewHeight = MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension(viewWidth, viewHeight);
        L.print(this, "Measured: x - "+ viewWidth +" y - "+ viewHeight);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            layoutChild((PitPointView) getChildAt(i),this.getMeasuredWidth(),this.getMeasuredHeight());
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawLines(canvas);
        drawAxisLines(canvas);
        if (showAxeLines) drawDirectLines(canvas);
        super.onDraw(canvas);
    }

    //-----------------------------------------------------------view-cicle-business-logic-functions

    private void layoutChild(PitPointView child, int childWidth, int childHeight)
    {
        child.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.AT_MOST),
                MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.AT_MOST));
        child.layout(child.getCoordX(),child.getCoordY(),
                child.getCoordX()+child.getMeasuredWidth(),
                child.getCoordY()+child.getMeasuredHeight());
    }

    private void drawDirectLines(Canvas canvas) {
        PitPoint clickedPoint = pointManager.getPointsMath().get(currentPoint);
        canvas.drawLine(viewWidth /2,clickedPoint.getY()+PitPoint.RADIUS/2,clickedPoint.getX(),clickedPoint.getY()+PitPoint.RADIUS/2,paintDirectLine);
        canvas.drawLine(clickedPoint.getX()+PitPoint.RADIUS/2, viewHeight /2,clickedPoint.getX()+PitPoint.RADIUS/2,clickedPoint.getY(),paintDirectLine);
    }

    private void drawAxisLines(Canvas canvas) {
        canvas.drawLine(0, viewHeight /2, viewWidth, viewHeight /2,paintAxisLine);
        canvas.drawLine(viewWidth /2,0, viewWidth /2, viewHeight,paintAxisLine);
    }

    private void drawLines(Canvas canvas) {
        for (int i = 0; i < getChildCount()-1; i++) {
            PitPoint start = ((PitPointView) getChildAt(i)).getPitPoint();
            PitPoint finish = ((PitPointView) getChildAt(i+1)).getPitPoint();
            canvas.drawLine(start.getX()+PitPoint.RADIUS/2,start.getY()+PitPoint.RADIUS/2,finish.getX()+PitPoint.RADIUS/2,finish.getY()+PitPoint.RADIUS/2,paintPointLine);
        }
    }

    //------------------------------------------------------------------------------public-functions

    /**
     * <p>Set new ArrayList of points and reload view. Use it if you want to set some predefined
     * list of points.</p>
     *
     * <p><strong>Note:</strong> items of have to be {@link ( PitPoint )}.</p>
     *
     * @param points the ArrayList of PitPoints which you want to show
     */
    public void setPoints(ArrayList<PitPoint> points) {
        pointManager.setPointsMath(points);
        setPointsView(pointManager.initPoints(getContext()));
    }

    /**
     * <p>Clear all points and init one point in the center.</p>
     */
    public void initFirstPoint() {
        L.print(this, "Want to create first point: x - "+ viewWidth +" y - "+ viewHeight);
        ArrayList<PitPoint> pointsNew = new ArrayList<>();
        pointsNew.add(new PitPoint(viewWidth /2-PitPoint.RADIUS/2, viewHeight /2-PitPoint.RADIUS/2));
        pointManager.setPointsMath(pointsNew);
        setPointsView(pointManager.initPoints(getContext()));
    }

    /**
     * <p>Adds a new point in list of points. Resorting and redrawing of all points
     * will start automatically.</p>
     */
    public void addNewPoint() {
        if (pointManager.getPointsMath()==null){
            initFirstPoint();
        } else {
            pointManager.getPointsMath().add(
                    new PitPoint(viewWidth /2-PitPoint.RADIUS/2, viewHeight /2-PitPoint.RADIUS/2)
            );
            setPointsView(pointManager.initPoints(getContext()));
        }
    }
}