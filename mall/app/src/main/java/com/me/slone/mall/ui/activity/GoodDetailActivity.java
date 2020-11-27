package com.me.slone.mall.ui.activity;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.me.slone.mall.R;
import com.me.slone.mall.common.MyActivity;
import com.me.slone.mall.common.MyBottomSheetFragment;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.CartAddApi;
import com.me.slone.mall.http.request.GoodCountApi;
import com.me.slone.mall.http.request.GoodDetailApi;
import com.me.slone.mall.http.response.goodsdetail.AttibuteBean;
import com.me.slone.mall.http.response.goodsdetail.GoodsDetailBean;
import com.me.slone.mall.http.response.goodsdetail.GoodsDetailInfoBean;
import com.me.slone.mall.http.response.goodsdetail.ProductBean;
import com.me.slone.mall.ui.adapter.GoodsDetailViewHolder;
import com.me.slone.mall.utils.DisplayUtil;
import com.ms.banner.Banner;
import com.ms.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：diankun
 * Time：20-11-5 下午3:18
 * Description:
 */
public class GoodDetailActivity extends MyActivity {

    private Banner mBanner;
    private TextView mTitleTv, mBriefTv, mPrice1Tv, mPrice2Tv, mBrandTv, mSpecificationTv;
    private TextView mAddOrderTv, mTakeOrderTv, mBageTv;
    private WebView mWebView;
    private RelativeLayout mSpecificationRl;
    private LinearLayout mAttributeLl;
    private GoodsDetailBean mGoodsDetailBean;
    private int mGoodId;

    @Override
    protected int getLayoutId() {
        return R.layout.gooddetail_activity;
    }

    @Override
    protected void initView() {
        mTitleTv = findViewById(R.id.tv_title);
        mBriefTv = findViewById(R.id.tv_brief);
        mPrice1Tv = findViewById(R.id.tv_price1);
        mPrice2Tv = findViewById(R.id.tv_price2);
        mBrandTv = findViewById(R.id.tv_brand);
        mWebView = findViewById(R.id.webview);
        mSpecificationTv = findViewById(R.id.tv_specification);
        mAddOrderTv = findViewById(R.id.tv_add_order);
        mTakeOrderTv = findViewById(R.id.tv_take_order);
        mSpecificationRl = findViewById(R.id.rl_specification);
        mAttributeLl = findViewById(R.id.ll_attribute);
        mBageTv = findViewById(R.id.tv_badge);
        initBanner();
        initWebView();
        setOnClickListener(mAddOrderTv, mTakeOrderTv, mSpecificationRl);
    }

    private void initBanner() {
        mBanner = findViewById(R.id.banner);
        mBanner.post(() -> {
            int screenHeight = DisplayUtil.getScreenContentHeight(GoodDetailActivity.this);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mBanner.getLayoutParams();
            params.height = screenHeight * 1 / 3;
            mBanner.setLayoutParams(params);
            mBanner.invalidate();
        });
    }

    private void initWebView() {
        mWebView.clearCache(true);
        mWebView.clearHistory();
        mWebView.setVisibility(View.VISIBLE);
        mWebView.getSettings().setJavaScriptEnabled(true);//如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        mWebView.getSettings().setDomStorageEnabled(true);//开启DOM
        WebSettings webSettings = mWebView.getSettings();
        //自适应屏幕大小
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        //隐藏原生的缩放控件
        webSettings.setDisplayZoomControls(false);
        //设置默认为utf-8
        webSettings.setDefaultTextEncodingName("UTF-8");
        //支持自动加载图片
        webSettings.setLoadsImagesAutomatically(true);
        //监听WebView是否加载完成网页
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.i(TAG, "onPageFinished: ");
                loadJS();
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        mWebView.setWebContentsDebuggingEnabled(true);
    }

    /**
     * 更新图片显示样式
     */
    private void loadJS() {
        String updateView =
                "function updateView(){\n" +
                        "            var p = document.getElementsByTagName('p');\n" +
                        "            console.log('ps = '+p.length);\n" +
                        "            for(var i=0;i<p.length;i++){\n" +
                        "                console.log('p='+p );\n" +
                        "                p[i].style.margin = '0%';\n" +
                        "                p[i].style.display = 'flex';\n" +
                        "                p[i].style.width = \"100%\";\n" +
                        "            }\n" +
                        "            var img = document.getElementsByTagName('img');\n" +
                        "            for(var j=0;j<img.length;j++){\n" +
                        "                img[j].style.width='100%';\n" +
                        "            }\n" +
                        "        }";
        mWebView.loadUrl("javascript:( " + updateView + " )()");
    }

    @Override
    protected void initData() {
        mGoodId = (int) getIntent().getExtras().get("goodId");
        getGoodDetail();
        getGoodCount();
    }

    private void getGoodCount() {
        EasyHttp.get(this)
                .api(new GoodCountApi())
                .request(new HttpCallback<HttpData<Integer>>(this) {
                    @Override
                    public void onSucceed(HttpData<Integer> result) {
                        super.onSucceed(result);
                        updateGoodCount(result.getData());
                    }
                });
    }

    private void getGoodDetail() {
        EasyHttp.get(this)
                .api(new GoodDetailApi()
                        .setId(mGoodId))
                .request(new HttpCallback<HttpData<GoodsDetailBean>>(this) {
                    @Override
                    public void onSucceed(HttpData<GoodsDetailBean> result) {
                        super.onSucceed(result);
                        mGoodsDetailBean = result.getData();
                        if (mGoodsDetailBean == null) {
                            return;
                        }
                        refreshBaner();
                        refreshAttribute();
                    }
                });
    }

    private void refreshAttribute() {
        List<AttibuteBean> attribute = mGoodsDetailBean.getAttribute();
        if (attribute == null || attribute.isEmpty()) {
            mAttributeLl.setVisibility(View.GONE);
        } else {
            mAttributeLl.setVisibility(View.VISIBLE);
        }
    }

    private void refreshBaner() {
        GoodsDetailInfoBean info = mGoodsDetailBean.getInfo();
        if (info == null) {
            return;
        }

        if (info.getGallery() != null && !info.getGallery().isEmpty()) {
            mBanner.setAutoPlay(true)
                    .setPages(info.getGallery(), new GoodsDetailViewHolder())
                    .setDelayTime(2000)
                    .setIndicatorGravity(BannerConfig.CENTER)
                    .start();
        }
        mTitleTv.setText(info.getName());
        mBriefTv.setText(info.getBrief());
        mPrice1Tv.setText("原价：¥ " + info.getCategoryId());
        mPrice2Tv.setText("现价：¥ " + info.getRetailPrice());
        mSpecificationTv.setText("规格");
        mBrandTv.setVisibility(View.GONE);
        mWebView.loadData(info.getDetail(), "text/html; charset=UTF-8", null);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_add_order) {
            showAddCarDialog();
        } else if (id == R.id.rl_specification) {
            showAddCarDialog();
        }
    }

    private void showAddCarDialog() {
        ArrayList<ProductBean> productList = mGoodsDetailBean.getProductList();
        if (productList == null && productList.isEmpty()) {
            return;
        }
        MyBottomSheetFragment bottomSheetFragment = MyBottomSheetFragment.getInstance(productList);
        bottomSheetFragment.show(getSupportFragmentManager(), "bottomdialog");
        bottomSheetFragment.setOrderClickListener(mount -> {
            addOrderList(mount, bottomSheetFragment);
        });
    }

    private void addOrderList(int mount, MyBottomSheetFragment bottomSheetFragment) {
        EasyHttp.post(this)
                .api(new CartAddApi()
                        .setGoodsId(mGoodId)
                        .setNumber(mount)
                        .setProductId(mGoodsDetailBean.getProductList().get(0).getId()))
                .request(new HttpCallback<HttpData<Integer>>(this) {

                    @Override
                    public void onSucceed(HttpData<Integer> data) {
                        super.onSucceed(data);
                        updateGoodCount(data.getData());
                        bottomSheetFragment.dismiss();
                    }
                });
    }

    private void updateGoodCount(int count) {
        if (count <= 0) {
            mBageTv.setText(String.valueOf(count));
        } else {
            mBageTv.setText(String.valueOf(count));
        }
    }
}
