package com.me.slone.mall.ui.activity;

import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.view.View;

import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.me.slone.mall.R;
import com.me.slone.mall.common.MyActivity;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.GoodDetailApi;
import com.me.slone.mall.http.response.goodsdetail.GoodsDetailBean;
import com.me.slone.mall.http.response.goodsdetail.GoodsDetailInfoBean;
import com.me.slone.mall.ui.adapter.GoodsDetailViewHolder;
import com.me.slone.mall.ui.adapter.MallViewHolder;
import com.ms.banner.Banner;
import com.ms.banner.BannerConfig;

/**
 * Author：diankun
 * Time：20-11-5 下午3:18
 * Description:
 */
public class GoodDetailActivity extends MyActivity {

    private Banner mBanner;
    private TextView mTitleTv,mBriefTv,mPrice1Tv,mPrice2Tv,mBrandTv,mSpecificationTv;
    private WebView mWebView;

    private int mGoodId;

    @Override
    protected int getLayoutId() {
        return R.layout.gooddetail_activity;
    }

    @Override
    protected void initView() {
        mBanner = findViewById(R.id.banner);
        mTitleTv = findViewById(R.id.tv_title);
        mBriefTv = findViewById(R.id.tv_brief);
        mPrice1Tv = findViewById(R.id.tv_price1);
        mPrice2Tv = findViewById(R.id.tv_price2);
        mBrandTv = findViewById(R.id.tv_brand);
        mWebView = findViewById(R.id.webview);
        mSpecificationTv = findViewById(R.id.tv_specification);

        //设置不用系统浏览器打开,直接显示在当前Webview
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

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
        webSettings.setDefaultTextEncodingName("UTF -8");
        //支持自动加载图片
        webSettings.setLoadsImagesAutomatically(true);
        //监听WebView是否加载完成网页
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url){
                super.onPageFinished(view, url);
                loadJS();
            }

        });

    }

    private void loadJS() {
        mWebView.loadUrl("javascript:(function(){"
               //将DIV元素中的外边距和内边距设置为零，防止网页左右有空隙
                +" var divs = document.getElementsByTagName(\"div\");"
                +" for(var j=0;j"
                +"  divs[j].style.margin=\"0px\";"
                +"  divs[j].style.padding=\"0px\";"
                +"  divs[j].style.width=document.body.clientWidth-10;"
                +" }");

    }

    @Override
    protected void initData() {
        mGoodId = (int) getIntent().getExtras().get("goodId");
        getGoodDetail();
    }

    private void getGoodDetail() {
        EasyHttp.get(this)
                .api(new GoodDetailApi()
                        .setId(mGoodId))
                .request(new HttpCallback<HttpData<GoodsDetailBean>>(this) {
                    @Override
                    public void onSucceed(HttpData<GoodsDetailBean> result) {
                        super.onSucceed(result);
                        refreshBaner(result.getData().getInfo());
                    }
                });
    }

    private void refreshBaner(GoodsDetailInfoBean info) {
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
        mPrice1Tv.setText("原价：¥ "+info.getCategoryId());
        mPrice2Tv.setText("现价：¥ "+info.getRetailPrice());
        mSpecificationTv.setText("规格");
        mBrandTv.setVisibility(View.GONE);
        mWebView.loadData(info.getDetail(),"text/html; charset=UTF-8", null);
    }
}
