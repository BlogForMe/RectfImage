package com.android.rectfimage.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.android.rectfimage.R;

/**
 * Created by Administrator on 2016/12/19.
 */

/**
 * 使用BitmapShader绘制圆角矩形
 */
public class RoundShaderView extends ImageView {


    private Bitmap bm;

    public RoundShaderView(Context context) {
        this(context, null);
    }

    public RoundShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        bm = BitmapFactory.decodeResource(getResources(), R.mipmap.beaty2);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        BitmapShader mBitmapShader = new BitmapShader(bm, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Bitmap targetBm = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), bm.getConfig());
        RectF rectF = new RectF(0, 0, targetBm.getWidth(), targetBm.getHeight());
        Paint paint = new Paint();
        paint.setShader(mBitmapShader);
        canvas.drawRoundRect(rectF, 40, 40, paint);
    }


    /**
     * 加了这个就不起作用
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int w = bm.getWidth(),
                h = bm.getHeight();
        setMeasuredDimension(w, h);
    }

//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
//    }
}
