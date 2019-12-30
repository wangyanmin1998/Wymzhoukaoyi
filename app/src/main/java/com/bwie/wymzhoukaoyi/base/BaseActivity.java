package com.bwie.wymzhoukaoyi.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
 *@auther:王彦敏
 *@Date: 2019/12/29
 *@Time:18:47
 *@Description:
 * */
public abstract class BaseActivity<P extends BasePresentner> extends AppCompatActivity {
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        initView();
        mPresenter=provideprisenter();
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        initData();

    }

    protected abstract int layoutId();

    protected abstract void initData();

    protected abstract P provideprisenter();

    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detach();
        }
    }
}
