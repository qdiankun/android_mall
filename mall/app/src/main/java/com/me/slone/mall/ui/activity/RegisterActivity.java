package com.me.slone.mall.ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.blankj.utilcode.util.SPUtils;
import com.hjq.http.EasyConfig;
import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.hjq.widget.view.CountdownView;
import com.me.slone.mall.R;
import com.me.slone.mall.common.Constants;
import com.me.slone.mall.common.MyActivity;
import com.me.slone.mall.common.UserConstants;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.LoginApi;
import com.me.slone.mall.http.request.RegisterApi;
import com.me.slone.mall.http.response.account.LoginBean;

/**
 * Author：diankun
 * Time：20-11-16 上午10:52
 * Description:注册页面
 */
public class RegisterActivity extends MyActivity {


    private EditText mPhoneView;
    private CountdownView mCountdownView;
    private EditText mUserNameView, mPhone1View;

    private EditText mCodeView;

    private EditText mPasswordView1;
    private EditText mPasswordView2;

    private Button mCommitView;

    @Override
    protected int getLayoutId() {
        return R.layout.register_activity;
    }

    @Override
    protected void initView() {
        mPhoneView = findViewById(R.id.et_register_phone);
        mCountdownView = findViewById(R.id.cv_register_countdown);
        mCodeView = findViewById(R.id.et_register_code);
        mPasswordView1 = findViewById(R.id.et_register_password1);
        mPasswordView2 = findViewById(R.id.et_register_password2);
        mCommitView = findViewById(R.id.btn_register_commit);
        mUserNameView = findViewById(R.id.et_register_name);
        mPhone1View = findViewById(R.id.et_register_phone1);
        setOnClickListener(mCountdownView, mCommitView);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        if (v == mCommitView) {
            String mobile = mPhone1View.getText().toString().trim();
            String username = mUserNameView.getText().toString().trim();
            String password = mPasswordView1.getText().toString().trim();
            String password2 = mPasswordView2.getText().toString().trim();
            if (TextUtils.isEmpty(mobile)) {
                toast(R.string.common_phone_input_hint);
                return;
            }
            if (TextUtils.isEmpty(username)) {
                toast(R.string.common_username_input_hint);
                return;
            }
            if (TextUtils.isEmpty(password) || TextUtils.isEmpty(password2)) {
                toast(R.string.common_password_input_error);
                return;
            }
            if(!password.equals(password2)){
                toast(R.string.common_password_input_unlike);
                return;
            }
            EasyHttp.post(this)
                    .api(new RegisterApi()
                            .setUsername(username)
                            .setPassword(password)
                            .setMobile(mobile))
                    .request(new HttpCallback<HttpData<LoginBean>>(this) {

                        @Override
                        public void onSucceed(HttpData<LoginBean> data) {
                            // 更新 Token
                            EasyConfig.getInstance()
                                    .addHeader("X-Litemall-Token", data.getData().getToken());
                            UserConstants.token = data.getData().getToken();
                            SPUtils.getInstance().put(Constants.SP_KEY_TOKEN,data.getData().getToken());
                            // 跳转到主页
                            startActivity(HomeActivity.class);
                            finish();
                        }
                    });
        }
    }
}
