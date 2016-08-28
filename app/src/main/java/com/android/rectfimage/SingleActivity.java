package com.android.rectfimage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.rectfimage.view.XfermodeView;

public class SingleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_single);
        setContentView(new XfermodeView(this));
        System.out.println("你好");
    }
}
