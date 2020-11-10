package com.me.slone.mall.ui.activity;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallback;
import com.me.slone.mall.R;
import com.me.slone.mall.common.MyActivity;
import com.me.slone.mall.http.model.HttpData;
import com.me.slone.mall.http.request.GoodDetailApi;
import com.me.slone.mall.http.response.goodsdetail.GoodsDetailBean;
import com.me.slone.mall.http.response.goodsdetail.GoodsDetailInfoBean;
import com.me.slone.mall.ui.adapter.GoodsDetailViewHolder;
import com.ms.banner.Banner;
import com.ms.banner.BannerConfig;

import okhttp3.Call;

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
        mWebView.setWebContentsDebuggingEnabled(true);
        //监听WebView是否加载完成网页
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url){
                super.onPageFinished(view, url);
                loadJS();
            }

        });

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
        mWebView.loadUrl("javascript:( "+updateView+" )()");
        //mWebView.loadUrl(js);
        hideDialog();

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

    @Override
    public void onEnd(Call call) {
        //super.onEnd(call);
    }
}
