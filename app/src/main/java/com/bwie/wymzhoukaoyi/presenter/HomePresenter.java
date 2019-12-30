package com.bwie.wymzhoukaoyi.presenter;

import com.bwie.wymzhoukaoyi.base.BasePresentner;
import com.bwie.wymzhoukaoyi.contract.IHomePresenter;
import com.bwie.wymzhoukaoyi.model.HomeModel;
import com.bwie.wymzhoukaoyi.model.bean.ShopBean;

/*
 *@auther:王彦敏
 *@Date: 2019/12/29
 *@Time:19:09
 *@Description:
 * */
public class HomePresenter extends BasePresentner<IHomePresenter.IView> implements IHomePresenter.IPresenter {

    private HomeModel homeModel;

    @Override
    protected void initModal() {
        homeModel = new HomeModel();
    }

    @Override
    public void getHomeData() {
        homeModel.getHomeData(new IHomePresenter.IModel.IHomeCallback() {
            @Override
            public void onHomeSuccess(ShopBean shopBean) {
                view.onHomeSuccess(shopBean);
            }

            @Override
            public void onHomeFailrse(Throwable throwable) {
                view.onHomeFailrse(throwable);
            }
        });
    }
}
