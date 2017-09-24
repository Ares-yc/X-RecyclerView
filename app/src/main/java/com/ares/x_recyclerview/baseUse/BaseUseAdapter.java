package com.ares.x_recyclerview.baseUse;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ares.x_recyclerview.R;

import java.util.List;

/**
 * Created by Ares on 2017/9/23.
 */

public class BaseUseAdapter extends RecyclerView.Adapter<BaseUseAdapter.VH>{

    private Context mContext;
    private List<String> mDatas;

    public BaseUseAdapter(Context mContext, List<String> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home,parent,false);
        VH vh = new VH(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.numTv.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public class VH extends RecyclerView.ViewHolder{

        private TextView numTv;

        public VH(View itemView) {
            super(itemView);
            numTv = itemView.findViewById(R.id.tv_item_num);
        }
    }
}
