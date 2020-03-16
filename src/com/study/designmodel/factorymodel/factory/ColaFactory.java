package com.study.designmodel.factorymodel.factory;

/**
 * 具体工厂
 * 负责生产Cocola的工厂
 */
public class ColaFactory extends Factory {
    @Override
    public Product getProduct() {
        return new ColaProduct();
    }
}
