package com.ares.x_recyclerview.baseUse;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
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
//        outRect.right = mDivide.getIntrinsicWidth();
//        outRect.bottom = mDivide.getIntrinsicHeight();
        int right = mDivide.getIntrinsicWidth();
        int bottom = mDivide.getIntrinsicHeight();
        //最后一列右边无需分割线
        if (isLastColumn(view,parent)){
            right = 0;
        }
        //最后一行底部无需分割线
        if (isLastRow(view,parent)){
            bottom = 0;
        }
        outRect.right = right;
        outRect.bottom = bottom;
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

    //是否是最后一行
    private boolean isLastRow(View view, RecyclerView parent) {
        // ( position - 1 ) > ( 行数 - 1 ) * 列数
        return (getPosition(view) + 1) > (行数 - 1) * getSpanCount(parent);
    }

    //是否是最后一列
    private boolean isLastColumn(View view, RecyclerView parent) {
        // ( position + 1 ) % 列数 == 0
        return (getPosition(view) + 1) % getSpanCount(parent) == 0;
    }

    //获取列数
    private int getSpanCount(RecyclerView parent){
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager){
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            return gridLayoutManager.getSpanCount();
        }
        return 1;
    }
    //获取当前View的项数
    private int getPosition(View view){
        return ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
    }
}
