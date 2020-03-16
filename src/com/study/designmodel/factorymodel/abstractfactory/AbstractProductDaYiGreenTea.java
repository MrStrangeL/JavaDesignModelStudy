package com.study.designmodel.factorymodel.abstractfactory;

/**
 * 具体产品
 * 大益绿茶
 */
public class AbstractProductDaYiGreenTea extends AbstractProductGreenTea{
    @Override
    public void introduce() {
        System.out.println("抽象工厂模式：我是大益绿茶");
    }
}
