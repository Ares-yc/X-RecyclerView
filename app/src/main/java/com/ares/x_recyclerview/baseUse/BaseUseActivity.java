package com.ares.x_recyclerview.baseUse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.ares.x_recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class BaseUseActivity extends AppCompatActivity {

    private RecyclerView contentRv;
    private BaseUseAdapter mAdapter;
    private LinearLayoutItemDecoration linearLayoutDecoration;
    private GridLayoutItemDecoration gridLayoutDecoration;
    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_use);
        initView();
        initListener();
    }

    private void initView() {
        contentRv = (RecyclerView) findViewById(R.id.rv_activity_base_use_content);

        mDatas = new ArrayList<>();
        linearLayoutDecoration = new LinearLayoutItemDecoration(this,R.drawable.item_drawable01);
        gridLayoutDecoration = new GridLayoutItemDecoration(this,R.drawable.item_drawable01);

        initData();
        mAdapter = new BaseUseAdapter(this,mDatas);
        contentRv.setLayoutManager(new LinearLayoutManager(this));
        contentRv.setAdapter(mAdapter);
        contentRv.addItemDecoration(gridLayoutDecoration);
    }

    private void initListener() {

    }

    private void initData() {
        for(int i = 'A';i<='z';i++){
            mDatas.add(""+(char)i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_action_gridview:
                contentRv.removeItemDecoration(linearLayoutDecoration);
                contentRv.removeItemDecoration(gridLayoutDecoration);
                contentRv.setLayoutManager(new GridLayoutManager(BaseUseActivity.this,3));
                contentRv.addItemDecoration(gridLayoutDecoration);
                break;
            case R.id.id_action_listview:
                contentRv.removeItemDecoration(linearLayoutDecoration);
                contentRv.removeItemDecoration(gridLayoutDecoration);
                contentRv.setLayoutManager(new LinearLayoutManager(this));
                contentRv.addItemDecoration(gridLayoutDecoration);
                break;
        }
        return true;
    }
}
