package com.android.rectfimage.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

import com.android.rectfimage.Xfermodes;

/**
 * Created by Administrator on 2016/8/28.
 * 对每一个属性单个进行测试，  ！！！！！有一个问题   onDraw() 偶尔不执行 ！！！！！
 */
public class XfermodeView extends View {
    //源图和目标图宽高
    int width = 200, height = 200;
    Bitmap rectBitmap, cirBitmap;
    int screenW, screenH;

    public XfermodeView(Context context) {
        this(context, null);
    }


    public XfermodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        WindowManager windowManager = (WindowManager) context.getApplicationContext()
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        screenW = metrics.widthPixels;
        screenH = metrics.heightPixels;
    }


    // create a bitmap with a circle, used for the "dst" image  画一个圆
    static Bitmap makeDst(int w, int h) {
        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(0xFFFFCC44);
        c.drawOval(new RectF(0, 0, w * 3 / 4, h * 3 / 4), p);
        return bm;
    }

    // create a bitmap with a rect, used for the "src" image     画一个矩形
    static Bitmap makeSrc(int w, int h) {
        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

        p.setColor(0xFF66AAFF);
        c.drawRect(w / 3, h / 3, w * 19 / 20, h * 19 / 20, p);
        return bm;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        //创建原图和目标图
        rectBitmap = makeSrc(width, height);
        cirBitmap = makeDst(width, height);


        Paint paint = new Paint();
        paint.setFilterBitmap(false);
        paint.setStyle(Paint.Style.FILL);
        //绘制“src”蓝色矩形原图
        canvas.drawBitmap(rectBitmap, (screenW / 8 - width / 4), (screenH / 12 - height / 4), paint);
        //绘制“dst”黄色圆形原图
        canvas.drawBitmap(cirBitmap, screenW / 2, screenH / 12, paint);

//创建一个图层，在图层上演示图形混合后的效果
        int sc = canvas.saveLayer(0, 0, screenW, screenH, null, Canvas.MATRIX_SAVE_FLAG |
                Canvas.CLIP_SAVE_FLAG |
                Canvas.HAS_ALPHA_LAYER_SAVE_FLAG |
                Canvas.FULL_COLOR_LAYER_SAVE_FLAG |
                Canvas.CLIP_TO_LAYER_SAVE_FLAG);
//        先绘制圆形
        canvas.drawBitmap(cirBitmap, screenW / 4, screenH / 3, paint);
        //设置Paint的Xfermode
        paint.setXfermode(Xfermodes.sModes[4]);  //这里修改显示模式

        //绘制矩形
        canvas.drawBitmap(rectBitmap, screenW / 4, screenH / 3, paint);
        paint.setXfermode(null);
//         还原画布
        canvas.restoreToCount(sc);
    }
}
