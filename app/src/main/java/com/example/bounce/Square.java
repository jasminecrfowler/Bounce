package com.example.bounce;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import java.util.Random;

public class Square {
    float sideLength = 50;
    float x;
    float y;
    private RectF bounds;
    private Paint paint;
    Random r = new Random();

    public Square() {
        bounds = new RectF();
        paint = new Paint();
        paint.setColor(getRandomColor());

        x = sideLength + r.nextInt(800);
        y = sideLength + r.nextInt(800);
    }

    private int getRandomColor() {
        return 0xFF000000 | r.nextInt(0x00FFFFFF);
    }

    public void draw(Canvas canvas) {
        bounds.set(x - sideLength / 2, y - sideLength / 2,
                x + sideLength / 2, y + sideLength / 2);
        canvas.drawRect(bounds, paint);
    }
}
