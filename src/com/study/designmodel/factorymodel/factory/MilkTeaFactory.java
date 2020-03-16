package com.study.designmodel.factorymodel.factory;

/**
 * 具体工厂
 * 负责生产MilkTea的工厂
 */
public class MilkTeaFactory extends Factory{
    @Override
    public Product getProduct() {
        return new MilkTeaProduct();
    }
}
