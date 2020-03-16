package com.ziniuxiaozhu.jiemi.secondTerm.convert;

/**
 * Copyright © 2020年 secondTerm. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * @date 2020/3/10 11:45
 */
public class MyINfo {

    private String name;

    private int age;

    @Override
    public String toString() {
        return "MyINfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
}
