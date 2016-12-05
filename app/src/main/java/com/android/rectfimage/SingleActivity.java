package com.android.rectfimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.rectfimage.view.XFdrawMethod;
import com.android.rectfimage.view.XfermodeView;

public class SingleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_single);
//        setContentView(new XfermodeView(this));
        setContentView(new XFdrawMethod(this));

    }


}
