package com.example.bounce;

import android.graphics.Canvas;

public abstract class Shape {
    public abstract void moveWithCollisionDetection(Box box);
    public abstract void draw(Canvas canvas);
}
