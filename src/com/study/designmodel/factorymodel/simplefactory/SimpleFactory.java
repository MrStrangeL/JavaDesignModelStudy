package com.study.designmodel.factorymodel.simplefactory;

/**
 * 工厂
 * 负责实现创建所有实例的内部逻辑，并提供一个外界调用的方法，创建所需的产品对象
 */
public class SimpleFactory {
    /**
     * 供外界调用的方法
     * （可以看成是对外提供的三种按钮）
     * @param type
     * @return 产品实例
     */
    public static SimpleProduct getSimpleProduct(String type){
        switch (type){
            case "BlackTea":
                return new SimpleBlackTeaProduct();
            case "Cola":
                return new SimpleColaProduct();
            case "GreenTea":
                return new SimpleGreenTeaProduct();
            case "MilkTea":
                return new SimpleMilkTeaProduct();
            default:
                return null;
        }
    }
}
