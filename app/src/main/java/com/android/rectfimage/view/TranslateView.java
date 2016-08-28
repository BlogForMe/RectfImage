package com.android.rectfimage.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Jon on 2016/8/28.
 * 测试translate属性
 */

public class TranslateView extends TextView {
    public TranslateView(Context context) {
        super(context);
    }

    public TranslateView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.rotate(-90);  //让画布逆时针旋转90  // 这个属性貌似没用
        canvas.translate(-getHeight(),0); //向上移动 （100dp）
    }
}
