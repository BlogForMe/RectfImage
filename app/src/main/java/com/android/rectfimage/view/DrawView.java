package com.android.rectfimage.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Jon on 2016/8/27.
 * <p>
 * The Canvas class holds the "draw" calls. To draw something, you need 4 basic components: A Bitmap to hold the pixels,
 * a Canvas to host the draw calls (writing into the bitmap), a drawing primitive (e.g. Rect, Path, text, Bitmap),
 * and a paint (to describe the colors and styles for the drawing).
 */

public class DrawView extends View {
    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //创建画笔
        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setTextSize(50); //设置字体大小
        /**
         * 画圆
         */
        canvas.drawText("画圆", 10, 100, p);
        canvas.drawCircle(200, 90, 15, p);
        /**
         * 画线
         */
        canvas.drawText("画线", 10, 200, p);
        p.setColor(Color.BLUE);
        canvas.drawLine(300, 200, 600, 200, p);  //只需要两个点的坐标
        /**
         * 画矩形
         */
        canvas.drawText("画矩形", 10, 400, p);
//        p.setStyle(Paint.Style.FILL);
        canvas.drawRect(200, 300, 500, 400, p);  //这个矩形是按边来画的   left:左边到X轴的距离（x坐标）,top:上边到Y轴的距离（y的纵"zong"坐标）,right:(右边到X的距离（X坐标)，bottom:底边到Y轴的距离(Y坐标)
        canvas.drawRect(600, 300, 1000, 500, p);

        /**
         * 画弧形
         */
        canvas.drawText("画弧形", 10, 700, p);
        canvas.drawRect(200, 600, 600, 800, p);
        p.setColor(Color.YELLOW);
        RectF rectF = new RectF(200, 600, 600, 800);  //这个弧形就是以矩形的重心为原点，对角线的的一半为半径，以顺时针画
        canvas.drawArc(rectF, 0, 160, true, p);   //useCenter 为true就覆盖所有画的区域

        /**
         * 三角形
         */
        p.setColor(Color.RED);
        canvas.drawText("画三角形", 10, 900, p);
        p.setStyle(Paint.Style.STROKE);//设置空心
        //绘制三角形，也可以绘制任意多边形
        Path path = new Path();
        path.moveTo(300, 900); //第一个点为起点
        path.lineTo(800, 100); //注意这里是lineto
        path.lineTo(300, 970);
        path.close();   //封闭
        canvas.drawPath(path, p);

        //画圆角矩形
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.LTGRAY);
        p.setAntiAlias(true); //设置画笔的锯齿效果
        canvas.drawText("画圆角矩形",10,1000,p);
        RectF rectF1= new RectF(200,1000,500,1100);
        canvas.drawRoundRect(rectF1,50,200,p);  //第二个参数和第三个x\y方向上的半径，不是很理解
    }
}
