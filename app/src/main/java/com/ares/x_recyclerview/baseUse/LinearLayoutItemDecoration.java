package com.ares.x_recyclerview.baseUse;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 线性布局(ListView样式)分割线
 * Created by Ares on 2017/9/24.
 */

public class LinearLayoutItemDecoration extends RecyclerView.ItemDecoration{

    private Drawable mDivide;

    public LinearLayoutItemDecoration(Context mContext, int resId) {
        mDivide = ContextCompat.getDrawable(mContext,resId);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        if (position != 0){
            outRect.top = mDivide.getIntrinsicHeight();
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int count = parent.getChildCount();
        Rect rect = new Rect();
        rect.left = parent.getPaddingLeft();
        rect.right = parent.getWidth() - parent.getPaddingRight();
        for (int i = 1;i < count;i++){
            View childView = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childView.getLayoutParams();
            rect.bottom = parent.getChildAt(i).getTop() - params.topMargin;
            rect.top = rect.bottom - mDivide.getIntrinsicHeight();
            mDivide.setBounds(rect);
            mDivide.draw(c);
        }
    }
}
