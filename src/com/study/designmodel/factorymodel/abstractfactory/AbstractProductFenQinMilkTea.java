package com.study.designmodel.factorymodel.abstractfactory;

/**
 * 具体产品
 * 凤庆奶茶
 */
public class AbstractProductFenQinMilkTea extends AbstractProductMilkTea {
    @Override
    public void introduce() {
        System.out.println("抽象工厂模式：我是凤庆奶茶");
    }
}
