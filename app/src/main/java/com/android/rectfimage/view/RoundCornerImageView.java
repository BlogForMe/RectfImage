package com.android.rectfimage.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/12/6.
 */

public class RoundCornerImageView extends ImageView {
    public RoundCornerImageView(Context context) {
        super(context);
    }

    public RoundCornerImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Path path = new Path();
        Rect rect = new Rect(0, 0, getWidth(), getHeight());
        RectF rectF = new RectF(rect);
        path.addRoundRect(rectF, 100, 100, Path.Direction.CCW);
        canvas.clipPath(path, Region.Op.REPLACE);
        super.onDraw(canvas);
    }
}
