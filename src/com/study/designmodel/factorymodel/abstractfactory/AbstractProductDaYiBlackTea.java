package com.study.designmodel.factorymodel.abstractfactory;

/**
 * 具体产品
 * 大益红茶
 */
public class AbstractProductDaYiBlackTea extends AbstractProductBlackTea{
    @Override
    public void introduce() {
        System.out.println("抽象工厂模式：我是大益红茶");
    }
}
