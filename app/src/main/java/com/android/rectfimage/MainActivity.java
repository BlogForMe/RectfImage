package com.android.rectfimage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 进入google apidemos示例
         */
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Xfermodes.class));
            }
        });

        /**
         * 测试tranlate(x,y)方法
         */
        findViewById(R.id.tv_translate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LearnTranslateActivity.class));
            }
        });
        /**
         * 画图
         */
        findViewById(R.id.tv_circleRect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CircleRectActivity.class));
            }
        });

        /**
         * 对Apidemos单个进行测试
         */
        findViewById(R.id.tv_single).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SingleActivity.class));
            }
        });

    }
}
