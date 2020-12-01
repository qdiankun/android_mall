package com.me.slone.mall.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.hjq.widget.layout.SettingBar;
import com.me.slone.mall.R;
import com.me.slone.mall.common.MyFragment;
import com.me.slone.mall.http.glide.GlideApp;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.UserInfoApi;
import com.me.slone.mall.http.response.me.UserInfo;
import com.me.slone.mall.ui.activity.AddressListActivity;
import com.me.slone.mall.ui.activity.CouponListActivity;
import com.me.slone.mall.ui.activity.HomeActivity;

/**
 * Author：diankun
 * Time：20-10-30 下午2:52
 * Description:
 */
public class MeFragment extends MyFragment<HomeActivity> {

    private ImageView mAvatarIv;
    private TextView mNickTv;
    private SettingBar mAddressSb,mCouponSb;

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
        mAddressSb = findViewById(R.id.sb_setting_address);
        mCouponSb = findViewById(R.id.sb_setting_coupon);
        mNickTv.setText("昵称");
        GlideApp.with(getContext())
                .load(R.drawable.ic_shop)
                .circleCrop()
                .into(mAvatarIv);
        setOnClickListener(mAddressSb,mCouponSb);
    }

    @Override
    protected void initData() {
        getUserInfo();
    }

    private void getUserInfo() {
        EasyHttp.get(this)
                .api(new UserInfoApi())
                .request(new HttpCallback<HttpData<UserInfo>>(this) {
                    @Override
                    public void onSucceed(HttpData<UserInfo> result) {
                        super.onSucceed(result);
                        refreshUserInfo(result.getData());
                    }
                });
    }

    private void refreshUserInfo(UserInfo userInfo) {
        mNickTv.setText(userInfo.getNickName());
        GlideApp.with(getContext())
                .load(userInfo.getAvatar())
                .circleCrop()
                .into(mAvatarIv);
    }

    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }

    @Override
    public void onClick(View v) {
        if (v == mAddressSb) {
            startActivity(AddressListActivity.class);
        } else if(v == mCouponSb){
            startActivity(CouponListActivity.class);
        }
    }
}
