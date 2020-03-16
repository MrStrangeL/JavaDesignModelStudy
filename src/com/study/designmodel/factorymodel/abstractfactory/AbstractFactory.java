package com.study.designmodel.factorymodel.abstractfactory;

/**
 * 抽象工厂
 * 描述具体工厂，创建产品的实例，供外界调用
 */
public abstract class AbstractFactory {
    //生产红茶
    public abstract AbstractProductFamily getProductBlackTea();
    //生产绿茶
    public abstract AbstractProductFamily getProductGreenTea();
    //生产奶茶
    public abstract AbstractProductFamily getProductMilkTea();
}
