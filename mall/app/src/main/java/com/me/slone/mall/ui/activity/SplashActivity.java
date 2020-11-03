package com.me.slone.mall.ui.activity;

import androidx.annotation.NonNull;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.me.slone.mall.R;
import com.me.slone.mall.common.MyActivity;
import com.me.slone.mall.other.AppConfig;

/**
 * Author：qiudiankun
 * Time：20-10-30 下午2:14
 * Description：闪屏界面
 */
public class SplashActivity extends MyActivity {


    private LottieAnimationView mLottieView;
    private View mDebugView;

    @Override
    protected int getLayoutId() {
        return R.layout.splash_activity;
    }

    @Override
    protected void initView() {
        mLottieView = findViewById(R.id.iv_splash_lottie);
        mDebugView = findViewById(R.id.iv_splash_debug);
//        mLottieView.addAnimatorListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                startActivity(HomeActivity.class);
//                finish();
//            }
//        });

        startActivity(HomeActivity.class);
        finish();
    }

    @Override
    protected void initData() {
        if(AppConfig.isDebug()){
            mDebugView.setVisibility(View.VISIBLE);
        } else {
            mDebugView.setVisibility(View.GONE);
        }

        //refresh userinfo
    }

    @NonNull
    @Override
    protected ImmersionBar createStatusBarConfig() {
        return super.createStatusBarConfig()
                .hideBar(BarHide.FLAG_HIDE_BAR);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}