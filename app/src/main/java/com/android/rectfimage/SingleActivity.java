package com.android.rectfimage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.rectfimage.view.XfermodeView;

public class SingleActivity extends AppCompatActivity {

    private Paint paint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_single);
//        setContentView(new XfermodeView(this));

        setContentView(new PaintView(this));
    }

    private class PaintView extends View {
        public PaintView(Context context) {
            super(context);
            paint = new Paint();
            paint.setColor(Color.YELLOW);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setStrokeWidth(3);
        }

        @Override
        protected void onDraw(Canvas canvas) {
//            super.onDraw(canvas);
            canvas.drawCircle(300, 300, 90, paint);

        }
    }
}
