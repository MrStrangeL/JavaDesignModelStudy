package com.study.designmodel.factorymodel.abstractfactory;

/**
 * 具体产品
 * 凤庆红茶
 */
public class AbstractProductFenQinBlackTea extends AbstractProductBlackTea {
    @Override
    public void introduce() {
        System.out.println("抽象工厂模式：我是凤庆红茶");
    }
}
