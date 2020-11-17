package com.me.slone.mall.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.me.slone.mall.R;
import com.me.slone.mall.common.MyAdapter;
import com.me.slone.mall.http.glide.GlideApp;
import com.me.slone.mall.http.response.category.Category;

/**
 * Author：diankun
 * Time：20-11-17 上午10:49
 * Description:
 */
public class CategoryAdapter extends MyAdapter<Category> {

    public CategoryAdapter(@NonNull Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    private final class ViewHolder extends MyAdapter.ViewHolder{

        private ImageView goodsIv;
        private TextView titleIv;

        private ViewHolder() {
            super(R.layout.category_item);
        }


        @Override
        public void onBindView(int position) {
            goodsIv = (ImageView) findViewById(R.id.iv_goods);
            titleIv = (TextView) findViewById(R.id.tv_title);

            Category category = getItem(position);
            titleIv.setText(category.getName());
            GlideApp.with(getContext())
                    .load(category.getPicUrl())
                    .into(goodsIv);
        }
    }

}
