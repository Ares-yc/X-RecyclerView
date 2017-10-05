package com.ares.x_recyclerview.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * ====================================
 * 作    者：Ares(颜崔)
 * 地    址：https://github.com/Ares-yc
 * 描    述：RecyclerView通用Adapter
 * 版    本：1.0.0
 * 创建时间：2017/9/27.
 * 修改时间：2017/9/27.
 * ====================================
 */

public abstract class CommonRecyclerViewAdapter<DATA> extends RecyclerView.Adapter<CommonViewHolder>{

    private int layoutId;
    private Context mContext;
    private List<DATA> mData;
    private LayoutInflater layoutInflater;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;

    public CommonRecyclerViewAdapter(Context mContext , List<DATA> _mData , int _layoutId){
        this.layoutInflater = LayoutInflater.from(mContext);
        this.layoutId = _layoutId;
        this.mContext = mContext;
        this.mData = _mData;
    }

    //更新数据
    public void updateData(List<DATA> mData){
        if (mData != null){
            this.mData.clear();
            this.mData.addAll(mData);
            notifyDataSetChanged();
        }
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(layoutId,parent,false);
        return new CommonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, final int position) {
        onBindViewHolder(holder,mData.get(position),position);
        if (onItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(position);
                }
            });
        }

        if (onItemLongClickListener != null){
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onItemLongClickListener.onItemLongClick(position);
                    return true;
                }
            });
        }
    }

    //设置单击监听
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    //设置长按监听
    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener){
        this.onItemLongClickListener = onItemLongClickListener;
    }

    protected abstract void onBindViewHolder(CommonViewHolder holder, DATA data, int position);

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }
}
