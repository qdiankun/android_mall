package com.me.slone.mall.ui.fragment;

import android.widget.ImageView;
import android.widget.TextView;

import com.me.slone.mall.R;
import com.me.slone.mall.common.MyFragment;
import com.me.slone.mall.http.glide.GlideApp;
import com.me.slone.mall.ui.activity.HomeActivity;

/**
 * Author：diankun
 * Time：20-10-30 下午2:52
 * Description:
 */
public class MeFragment extends MyFragment<HomeActivity> {

    private ImageView mAvatarIv;
    private TextView mNickTv;

    public static MeFragment newInstance() {
        return new MeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.me_fragment;
    }

    @Override
    protected void initView() {
        mAvatarIv = findViewById(R.id.iv_avatar);
        mNickTv = findViewById(R.id.tv_nickname);

        mNickTv.setText("昵称");
        GlideApp.with(getContext())
                .load(R.drawable.ic_shop)
                .circleCrop()
                .into(mAvatarIv);
    }

    @Override
    protected void initData() {

    }

    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }
}
