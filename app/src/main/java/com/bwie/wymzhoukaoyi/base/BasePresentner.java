package com.bwie.wymzhoukaoyi.base;

/*
 *@auther:王彦敏
 *@Date: 2019/12/29
 *@Time:18:48
 *@Description:
 * */
public abstract class BasePresentner<V> {
    protected V view;

    public BasePresentner(){
        initModal();
    }

    protected abstract void initModal();

    public void attach(V view){
        this.view=view;
    }

    public void detach(){
        view=null;
    }

}
