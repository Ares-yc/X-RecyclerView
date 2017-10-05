package com.ares.x_recyclerview.common;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import static android.support.v7.widget.RecyclerView.ViewHolder;

/**
 * ====================================
 * 作    者：Ares(颜崔)
 * 地    址：https://github.com/Ares-yc
 * 描    述：RecyclerView通用ViewHolder
 * 版    本：1.0.0
 * 创建时间：2017/9/27.
 * 修改时间：2017/9/27.
 * ====================================
 */

public class CommonViewHolder extends ViewHolder {

    private SparseArray<View> mViews;

    public CommonViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
    }

    public <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if (view == null){
            view = itemView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }

    public CommonViewHolder setText(int viewId , CharSequence text){
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }
}
