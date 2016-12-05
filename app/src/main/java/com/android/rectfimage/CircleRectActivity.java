package com.android.rectfimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.android.rectfimage.view.RoundImageViewByXfermode;

public class CircleRectActivity extends AppCompatActivity {

    private LinearLayout llIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_rect);
        llIv = (LinearLayout) findViewById(R.id.ll_iv);

        initView();
    }

    private void initView() {
        RoundImageViewByXfermode rivbx = new RoundImageViewByXfermode(this);
        Bitmap bitMap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.aa);
        rivbx.setImageBitmap(bitMap);
        llIv.addView(rivbx);
    }
}
