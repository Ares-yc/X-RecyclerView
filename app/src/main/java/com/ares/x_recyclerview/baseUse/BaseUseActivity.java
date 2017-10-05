package com.ares.x_recyclerview.baseUse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.ares.x_recyclerview.R;
import com.ares.x_recyclerview.common.CommonItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class BaseUseActivity extends AppCompatActivity {

    private RecyclerView contentRv;
    private BaseUseAdapter mAdapter;
    private CommonItemDecoration commonItemDecoration;
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
        commonItemDecoration = new CommonItemDecoration(this,R.drawable.item_drawable01);

        initData();
        mAdapter = new BaseUseAdapter(this,mDatas,R.layout.item_home);
        contentRv.setLayoutManager(new LinearLayoutManager(this));
        contentRv.setAdapter(mAdapter);
        contentRv.addItemDecoration(commonItemDecoration);
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
                contentRv.removeItemDecoration(commonItemDecoration);
                contentRv.setLayoutManager(new GridLayoutManager(BaseUseActivity.this,3));
                contentRv.addItemDecoration(commonItemDecoration);
                break;
            case R.id.id_action_listview:
                contentRv.removeItemDecoration(commonItemDecoration);
                contentRv.setLayoutManager(new LinearLayoutManager(this));
                contentRv.addItemDecoration(commonItemDecoration);
                break;
        }
        return true;
    }
}
