package com.me.slone.mall.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.me.slone.mall.R;
import com.me.slone.mall.common.MyAdapter;
import com.me.slone.mall.http.response.goods.FloorGoodsBean;
import com.me.slone.mall.http.response.goods.NewGoodsBean;
import com.me.slone.mall.other.DividerGridItemDecoration;

import java.util.List;

/**
 * Author：diankun
 * Time：20-11-3 上午10:34
 * Description: 楼层
 */
public class OrderAdapter extends MyAdapter<FloorGoodsBean> {

    public OrderAdapter(@NonNull Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    private final class ViewHolder extends MyAdapter.ViewHolder{

        private RecyclerView floorRv;
        private TextView titleTv,moreTv;
        private LinearLayout floorLl;


        public ViewHolder() {
            super(R.layout.floor_item);
        }

        @Override
        public void onBindView(int position) {
            floorLl = (LinearLayout) findViewById(R.id.ll_floor);
            floorRv = (RecyclerView) findViewById(R.id.rv_floor);
            titleTv = (TextView) findViewById(R.id.tv_title);
            moreTv = (TextView) findViewById(R.id.tv_more);

            FloorGoodsBean floorGoodsBean = getItem(position);
            List<NewGoodsBean> goodsList = floorGoodsBean.getGoodsList();
            if(goodsList!=null && !goodsList.isEmpty()){
                floorLl.setVisibility(View.VISIBLE);
                FloorChildAdapter floorChildAdapter = new FloorChildAdapter(getContext());
                floorChildAdapter.setData(goodsList);
                GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
                floorRv.setLayoutManager(layoutManager);
                Drawable verticalLine = getResources().getDrawable(R.drawable.divider_grid_gray_bg);
                DividerGridItemDecoration dividerItemDecoration =  new DividerGridItemDecoration(verticalLine);
                floorRv.addItemDecoration(dividerItemDecoration);
                floorRv.setAdapter(floorChildAdapter);
                titleTv.setText(floorGoodsBean.getName());
                moreTv.setText("更多"+floorGoodsBean.getName()+"好物 >");
            }else {
                floorLl.setVisibility(View.GONE);
            }


        }
    }

}
