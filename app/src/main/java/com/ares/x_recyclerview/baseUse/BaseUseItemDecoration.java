package com.ares.x_recyclerview.baseUse;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by Ares on 2017/9/24.
 */

public class BaseUseItemDecoration extends RecyclerView.ItemDecoration {

    private Context mContext;
    private Paint mPaint;

    public BaseUseItemDecoration(Context _context) {
        this.mContext = _context;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        if (position != 0){
//            outRect.top = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,10,mContext.getResources().getDisplayMetrics());
            outRect.top = 10;
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        Rect rect = new Rect();
        rect.left = parent.getPaddingLeft();
        rect.right = parent.getWidth() - parent.getPaddingRight();
        for (int i=1;i<parent.getChildCount();i++){
            rect.bottom = parent.getChildAt(i).getTop();
            rect.top = rect.bottom - 10;
            c.drawRect(rect,mPaint);
        }
    }
}
