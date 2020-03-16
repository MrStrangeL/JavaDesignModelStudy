package com.study.designmodel.factorymodel.abstractfactory;

/**
 * 具体产品
 * 凤庆绿茶
 */
public class AbstractProductFenQinGreenTea extends AbstractProductGreenTea{
    @Override
    public void introduce() {
        System.out.println("抽象工厂模式：我是凤庆绿茶");
    }
}
