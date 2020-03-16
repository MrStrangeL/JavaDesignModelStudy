package com.study.designmodel.factorymodel.factory;

/**
 * 具体工厂
 * 负责生产GreenTea的工厂
 */
public class GreenTeaFactory extends Factory{
    @Override
    public Product getProduct() {
        return new GreenTeaProduct();
    }
}
