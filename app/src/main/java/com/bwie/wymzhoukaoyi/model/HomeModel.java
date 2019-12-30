package com.bwie.wymzhoukaoyi.model;

import com.bwie.wymzhoukaoyi.contract.IHomePresenter;
import com.bwie.wymzhoukaoyi.model.bean.ShopBean;
import com.bwie.wymzhoukaoyi.util.NetUtil;
import com.google.gson.Gson;

/*
 *@auther:王彦敏
 *@Date: 2019/12/29
 *@Time:19:09
 *@Description:
 * */
public class HomeModel implements IHomePresenter.IModel {

    @Override
    public void getHomeData(IHomeCallback iHomeCallback) {

        String httpUrl="http://blog.zhaoliang5156.cn/api/shop/fulishe1.json";
        NetUtil.getInstance().getJsonGet(httpUrl, new NetUtil.MyCallback() {
            @Override
            public void onGetJson(String json) {
                ShopBean shopBean = new Gson().fromJson(json, ShopBean.class);
                iHomeCallback.onHomeSuccess(shopBean);
            }

            @Override
            public void onError(Throwable throwable) {
                iHomeCallback.onHomeFailrse(throwable);
            }
        });

    }
}
