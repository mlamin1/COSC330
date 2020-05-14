package com.hw1.c_curve;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Fractal {

    public void drawCCurve(Canvas canvas, float x1, float y1, float x2, float y2, int level) {

        //PAINT COLOR IS SET TO RED
        //LINE STROKE IS SET TO 1
        Paint paint = new Paint();
        paint.setColor(Color.rgb(255, 0, 0));
        paint.setStrokeWidth(1);

        if (level == 0)
            canvas.drawLine(x1, y1, x2, y2, paint);
        else {
            float xn = (x1 + x2) / 2 + (y1 - y2) / 2;
            float yn = (x2 - x1) / 2 + (y1 + y2) / 2;
            drawCCurve(canvas, x1, y1, xn, yn, level - 1);
            drawCCurve(canvas, xn, yn, x2, y2, level - 1);
        }
    }
}
