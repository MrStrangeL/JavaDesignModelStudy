package com.study.designmodel.factorymodel.factory;

/**
 * 具体产品
 * 描述生成的具体产品
 */
public class ColaProduct extends Product {
    @Override
    public void introduce() {
        System.out.println("工厂模式：我是可口可乐");
    }
}