package com.ares.x_recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ares.x_recyclerview.baseUse.BaseUseActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //基本使用
    public void baseUseClick(View view){
        Intent intent = new Intent(MainActivity.this, BaseUseActivity.class);
        startActivity(intent);
    }
}
