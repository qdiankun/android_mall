package com.me.slone.mall.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.me.slone.mall.R;

/**
 * Author：diankun
 * Time：20-11-12 下午3:30
 * Description:
 */
public class AmountView extends LinearLayout implements View.OnClickListener, TextWatcher {

    private static final String TAG = "AmountView";
    private int amount = 1; //购买数量
    private int goodsStorage = Integer.MAX_VALUE; //商品库存

    private OnAmountChangeListener mListener;

    private TextView etAmount;
    private Button btnDecrease;
    private Button btnIncrease;

    public AmountView(Context context) {
        this(context, null);
    }

    public AmountView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.view_amount, this);
        etAmount = (TextView) findViewById(R.id.etAmount);
        btnDecrease = (Button) findViewById(R.id.btnDecrease);
        btnIncrease = (Button) findViewById(R.id.btnIncrease);
        btnDecrease.setOnClickListener(this);
        btnIncrease.setOnClickListener(this);
        etAmount.addTextChangedListener(this);

        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.AmountView);
        int btnWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_btnWidth, LayoutParams.WRAP_CONTENT);
        int tvWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_tvWidth, 80);
        int tvTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_tvTextSize, 0);
        int btnTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_btnTextSize, 0);
        obtainStyledAttributes.recycle();

        LayoutParams btnParams = new LayoutParams(btnWidth, LayoutParams.MATCH_PARENT);
        btnDecrease.setLayoutParams(btnParams);
        btnIncrease.setLayoutParams(btnParams);
        if (btnTextSize != 0) {
            btnDecrease.setTextSize(TypedValue.COMPLEX_UNIT_PX, btnTextSize);
            btnIncrease.setTextSize(TypedValue.COMPLEX_UNIT_PX, btnTextSize);
        }

        LayoutParams textParams = new LayoutParams(tvWidth, LayoutParams.MATCH_PARENT);
        etAmount.setLayoutParams(textParams);
        if (tvTextSize != 0) {
            etAmount.setTextSize(tvTextSize);
        }
    }

    public void setOnAmountChangeListener(OnAmountChangeListener onAmountChangeListener) {
        this.mListener = onAmountChangeListener;
    }

    public void setGoodsStorage(int goods_storage) {
        this.goodsStorage = goods_storage;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        int oldAmount = Integer.valueOf(etAmount.getText().toString().trim());
        if (i == R.id.btnDecrease) {
            if (amount > 1) {
                amount--;
                etAmount.setText(amount + "");
            }
        } else if (i == R.id.btnIncrease) {
            if (amount < goodsStorage) {
                amount++;
                etAmount.setText(amount + "");
            }
        }

        etAmount.clearFocus();

        if (mListener != null && oldAmount != amount) {
            mListener.onAmountChange(this, amount);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.toString().isEmpty())
            return;
        amount = Integer.valueOf(s.toString());
//        if (amount > goodsStorage) {
//            etAmount.setText(goodsStorage + "");
//            return;
//        }

//        if (mListener != null) {
//            mListener.onAmountChange(this, amount);
//        }
    }


    public interface OnAmountChangeListener {
        void onAmountChange(View view, int amount);
    }

    public void setAmount(int number) {
        if (number < -1) {
            return;
        }
        amount = number;
        etAmount.setText(String.valueOf(number));
    }


    public int getAmout(){
        return Integer.valueOf(etAmount.getText().toString().trim());
    }
}