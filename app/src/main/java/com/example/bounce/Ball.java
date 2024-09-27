package com.example.bounce;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import java.util.Random;

public class Ball {

    float radius;
    float x;
    float y;
    float speedX;
    float speedY;
    private RectF bounds;
    private Paint paint;
    Random r = new Random();

    public Ball(float baseSize, boolean isSuperFast) {
        this.radius = baseSize + r.nextInt(20) - 10;

        bounds = new RectF();
        paint = new Paint();
        paint.setColor(getRandomColor());


        x = radius + r.nextInt(800);
        y = radius + r.nextInt(800);


        if (isSuperFast) {
            speedX = r.nextInt(10) + 10;
            speedY = r.nextInt(10) + 10;
        } else {
            speedX = r.nextInt(3) + 1;
            speedY = r.nextInt(3) + 1;
        }
    }

    // Method to generate a random color
    private int getRandomColor() {
        return 0xFF000000 | r.nextInt(0x00FFFFFF);
    }

    public void moveWithCollisionDetection(Box box) {

        x += speedX;
        y += speedY;

        if (x + radius > box.xMax) {
            speedX = -speedX;
            x = box.xMax - radius;
        } else if (x - radius < box.xMin) {
            speedX = -speedX;
            x = box.xMin + radius;
        }
        if (y + radius > box.yMax) {
            speedY = -speedY;
            y = box.yMax - radius;
        } else if (y - radius < box.yMin) {
            speedY = -speedY;
            y = box.yMin + radius;
        }
    }

    public void draw(Canvas canvas) {
        bounds.set(x - radius, y - radius, x + radius, y + radius);
        canvas.drawOval(bounds, paint);
    }
}
