package com.bwie.wymzhoukaoyi.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bwie.wymzhoukaoyi.R;
import com.bwie.wymzhoukaoyi.base.BaseActivity;
import com.bwie.wymzhoukaoyi.contract.IHomePresenter;
import com.bwie.wymzhoukaoyi.model.bean.ShopBean;
import com.bwie.wymzhoukaoyi.presenter.HomePresenter;
import com.bwie.wymzhoukaoyi.view.adapter.MyAdapter;

import java.util.List;

public class MainActivity extends BaseActivity<HomePresenter> implements IHomePresenter.IView {

    private RecyclerView recyclerView;

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mPresenter.getHomeData();
    }

    @Override
    protected HomePresenter provideprisenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recy);


    }

    @Override
    public void onHomeSuccess(ShopBean shopBean) {
        List<ShopBean.DataBean> data = shopBean.getData();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        MyAdapter myAdapter = new MyAdapter(data);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setOnTagClicklistner(new MyAdapter.onTagClicklistner() {
            @Override
            public void onTagClick(int position) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onHomeFailrse(Throwable throwable) {
        Toast.makeText(this, "123", Toast.LENGTH_SHORT).show();
    }
}
