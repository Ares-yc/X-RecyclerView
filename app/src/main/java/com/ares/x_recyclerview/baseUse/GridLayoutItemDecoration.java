package com.ares.x_recyclerview.baseUse;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 网格布局(GridView样式)分割线
 * Created by Ares on 2017/9/24.
 */

public class GridLayoutItemDecoration extends RecyclerView.ItemDecoration{

    private Drawable mDivide;

    public GridLayoutItemDecoration(Context mCotnext, int resId){
        mDivide = ContextCompat.getDrawable(mCotnext,resId);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.right = mDivide.getIntrinsicWidth();
        outRect.bottom = mDivide.getIntrinsicHeight();
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        drawHorizontal(c,parent);
        drawVertical(c,parent);
    }

    //画竖直方向的分割线
    private void drawVertical(Canvas c, RecyclerView parent) {
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            View childView = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childView.getLayoutParams();
            int left = childView.getRight() + params.leftMargin;
            int right = left + mDivide.getIntrinsicWidth();
            int top = childView.getTop() - params.topMargin;
            int bottom = childView.getBottom() + params.bottomMargin;
            mDivide.setBounds(left,top,right,bottom);
            mDivide.draw(c);
        }
    }

    //画水平方向的分割线
    private void drawHorizontal(Canvas c, RecyclerView parent) {
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            View childView = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childView.getLayoutParams();
            int left = childView.getLeft() - params.leftMargin;
            int right = left + childView.getWidth() + mDivide.getIntrinsicWidth() + params.rightMargin + params.leftMargin;
            int top = childView.getBottom() + params.bottomMargin;
            int bottom = top + mDivide.getIntrinsicHeight();
            mDivide.setBounds(left,top,right,bottom);
            mDivide.draw(c);
        }
    }
}
