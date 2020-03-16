package com.study.designmodel.factorymodel.abstractfactory;

/**
 * 具体产品
 * 大益奶茶
 */
public class AbstractProductDaYiMilkTea extends AbstractProductMilkTea {
    @Override
    public void introduce() {
        System.out.println("抽象工厂模式：我是大益奶茶");
    }
}
