package com.bwie.wymzhoukaoyi.contract;

import com.bwie.wymzhoukaoyi.model.bean.ShopBean;

/*
 *@auther:王彦敏
 *@Date: 2019/12/29
 *@Time:19:05
 *@Description:
 * */
public interface IHomePresenter {
    interface  IView{
        void onHomeSuccess(ShopBean shopBean);
        void onHomeFailrse(Throwable throwable);
    }

    interface  IPresenter{
        void getHomeData();
    }

    interface  IModel{
        void getHomeData(IHomeCallback iHomeCallback);
        interface  IHomeCallback{
            void onHomeSuccess(ShopBean shopBean);
            void onHomeFailrse(Throwable throwable);
        }

    }
}
