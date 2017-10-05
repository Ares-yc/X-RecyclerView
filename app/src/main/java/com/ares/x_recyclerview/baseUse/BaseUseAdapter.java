package com.ares.x_recyclerview.baseUse;

import android.content.Context;

import com.ares.x_recyclerview.R;
import com.ares.x_recyclerview.common.CommonRecyclerViewAdapter;
import com.ares.x_recyclerview.common.CommonViewHolder;

import java.util.List;

/**
 * Created by Ares on 2017/9/23.
 */

public class BaseUseAdapter extends CommonRecyclerViewAdapter<String>{


    public BaseUseAdapter(Context mContext, List<String> _mData, int _layoutId) {
        super(mContext, _mData, _layoutId);
    }

    @Override
    protected void onBindViewHolder(CommonViewHolder holder, String s, int position) {
        holder.setText(R.id.tv_item_num,s);
    }
}
