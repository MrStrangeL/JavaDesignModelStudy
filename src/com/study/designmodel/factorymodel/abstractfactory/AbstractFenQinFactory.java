package com.study.designmodel.factorymodel.abstractfactory;

/**
 * 具体工厂
 * 凤庆工厂，负责生产凤庆的所有产品
 */
public class AbstractFenQinFactory extends AbstractFactory {
    @Override
    public AbstractProductFamily getProductBlackTea() {
        return new AbstractProductFenQinBlackTea();
    }

    @Override
    public AbstractProductFamily getProductGreenTea() {
        return new AbstractProductFenQinGreenTea();
    }

    @Override
    public AbstractProductFamily getProductMilkTea() {
        return new AbstractProductFenQinMilkTea();
    }
}
