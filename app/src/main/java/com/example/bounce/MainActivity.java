package com.example.bounce;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Box box;
    private ArrayList<Ball> balls;
    private ArrayList<Square> squares;
    private long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        box = new Box(Color.RED);
        balls = new ArrayList<>();
        squares = new ArrayList<>();


        View contentView = new View(this) {
            @Override
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                box.set(0, 0, getWidth(), getHeight());
                box.draw(canvas);


                for (Ball ball : balls) {
                    ball.moveWithCollisionDetection(box);
                    ball.draw(canvas);
                }


                for (Square square : squares) {
                    square.draw(canvas);
                }


                invalidate();
            }

            @Override
            public boolean onTouchEvent(MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startTime = System.currentTimeMillis();
                        break;
                    case MotionEvent.ACTION_UP:
                        long swipeDuration = System.currentTimeMillis() - startTime;
                        boolean isSuperFast = swipeDuration < 300;

                        if (isSuperFast) {
                            squares.add(new Square());
                            invalidate();
                        } else {
                            balls.add(new Ball(50, false));
                            invalidate();
                        }
                        break;
                }
                return true;
            }
        };


        setContentView(contentView);
    }
}
