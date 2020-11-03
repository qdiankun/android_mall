package com.me.slone.mall.other;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.me.slone.mall.R;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2019/07/25
 *    desc   : 图片选择列表分割线
 */
public final class GridSpaceDecoration extends RecyclerView.ItemDecoration {

    private int dividerHeight;

    public GridSpaceDecoration(Context context) {
        dividerHeight = context.getResources().getDimensionPixelSize(R.dimen.divider_height);
    }

    @SuppressWarnings("all")
    @Override
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        super.getItemOffsets(rect,view,recyclerView,state);
        rect.bottom = dividerHeight;
    }

}