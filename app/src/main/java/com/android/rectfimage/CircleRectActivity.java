package com.android.rectfimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.rectfimage.view.RoundImageViewByXfermode;

public class CircleRectActivity extends AppCompatActivity {

    private LinearLayout llIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_rect);
//        llIv = (LinearLayout) findViewById(R.id.ll_iv);

//         = getLayoutInflater()

//        initView();

        initImg();
    }

    private void initImg() {
        ImageView ivIMG = (ImageView) findViewById(R.id.iv_img);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.beaty1, null);
        Bitmap target = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());

        RectF rectF = new RectF(0, 0, target.getWidth(), target.getHeight());
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(shader);

        Canvas canvas = new Canvas(target);
        canvas.drawOval(rectF, paint);
        ivIMG.setImageBitmap(target);

    }

    private void initView() {
        RoundImageViewByXfermode rivbx = new RoundImageViewByXfermode(this);
        Bitmap bitMap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.beaty1);
        rivbx.setImageBitmap(bitMap);
        llIv.addView(rivbx);
    }
}
