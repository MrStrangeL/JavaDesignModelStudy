package com.study.designmodel.factorymodel.factory;

/**
 * 抽象工厂
 * 描述具体工厂的公共接口
 */
public abstract class Factory {
    /**
     * 供外界调用的方法，具体生产什么样的产品
     * @return
     */
    public abstract Product getProduct();
}
