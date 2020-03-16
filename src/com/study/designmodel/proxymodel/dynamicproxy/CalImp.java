package com.study.designmodel.proxymodel.dynamicproxy;

public class CalImp implements ICal {
    @Override
    public int jia(int a, int b) {
        return a+b;
    }

    @Override
    public int jian(int a, int b) {
        return a-b;
    }

    @Override
    public int chen(int a, int b) {
        return a*b;
    }

    @Override
    public int chu(int a, int b) {
        return a/b;
    }
}
