package com.study.designmodel.factorymodel.abstractfactory;

/**
 * 具体工厂
 * 大益工厂，负责生产大益的所有产品
 */
public class AbstractDaYiFactory extends AbstractFactory {
    @Override
    public AbstractProductFamily getProductBlackTea() {
        return new AbstractProductDaYiBlackTea();
    }

    @Override
    public AbstractProductFamily getProductGreenTea() {
        return new AbstractProductDaYiGreenTea();
    }

    @Override
    public AbstractProductFamily getProductMilkTea() {
        return new AbstractProductDaYiMilkTea();
    }
}
