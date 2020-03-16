package com.study.designmodel.factorymodel.factory;

/**
 * 具体工厂
 * 负责生产BlackTea的工厂
 */
public class BlackTeaFactory extends Factory {
    @Override
    public Product getProduct() {
        return new BlackTeaProduct();
    }
}
