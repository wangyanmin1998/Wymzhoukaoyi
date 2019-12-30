package com.bwie.wymzhoukaoyi.model.bean;

/*
 *@auther:王彦敏
 *@Date: 2019/12/30
 *@Time:10:40
 *@Description:
 * */
public class Bean {
  protected  String name;
  protected  int age;

    public Bean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
