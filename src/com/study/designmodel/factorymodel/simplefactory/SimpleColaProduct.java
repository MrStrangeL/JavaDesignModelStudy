package com.study.designmodel.factorymodel.simplefactory;

/**
 * 具体产品
 * 描述生成的具体产品
 */
public class SimpleColaProduct extends SimpleProduct {
    @Override
    public void introduce() {
        System.out.println("简单工厂模式：我是可口可乐");
    }
}
