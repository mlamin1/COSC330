package com.hw1.c_curve;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.NumberPicker;

public class FractalView extends View {

    private float x1;
    private float y1;
    private float x2;
    private float y2;
    public int level;

    NumberPicker ddd;

    private Fractal fractal;

    public FractalView (Context context) {
        super (context);

        //CREATE A FRACTAL OBJECT
        level = 2;
        fractal = new Fractal();
    }

    protected void onDraw (Canvas canvas){
        //TASK 1: GET THE DIMENSIONS OF THE CANVAS

        x1 = canvas.getWidth() / 3;
        y1 = canvas.getHeight() / 4;
        x2 = canvas.getWidth() - x1;
        y2 = y1;

        //TASK 2:  FILL THE CANVAS WITH WHITE PAINT
        canvas.drawRGB(255, 255, 255);

        //TASK 3: DRAW THE FRACTAL
        fractal.drawCCurve(canvas, x1, y1, x2, y2, level);
    }

}
