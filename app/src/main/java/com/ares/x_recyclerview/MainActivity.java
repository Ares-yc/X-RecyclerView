package com.ares.x_recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ares.x_recyclerview.baseUse.BaseUseActivity;

public class MainActivity extends AppCompatActivity {

    private TextView baseUseClickTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseUseClickTv = (TextView) findViewById(R.id.baseUseClick);

//        baseUseClickTv.setText(Html.fromHtml("<p>填空<img class=\"question-blank-space edui-faked-music\" src=\"/moocs/ueditor/third-party/blank/1.png\" alt=\"1\" uuid=\"0c2404080d1f2d8124163b82dc209e66\"/>填空<img class=\"question-blank-space edui-faked-music\" src=\"/moocs/ueditor/third-party/blank/2.png\" alt=\"2\" uuid=\"87cf2d29c959fb2382e0080d20253b9e\"/>填空<img class=\"question-blank-space edui-faked-music\" src=\"/moocs/ueditor/third-party/blank/3.png\" alt=\"3\" uuid=\"92da87334bfc1f71b520283397e6d422\"/></p>"));
    }

    //基本使用
    public void baseUseClick(View view){
        Intent intent = new Intent(MainActivity.this, BaseUseActivity.class);
        startActivity(intent);
    }
}
