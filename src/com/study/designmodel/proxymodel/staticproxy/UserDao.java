package com.study.designmodel.proxymodel.staticproxy;

/**
 * 接口实现
 * 目标对象
 */
public class UserDao implements IUserDao{
    @Override
    public void save() {
        System.out.println("----静态代理目标对象：已经保存数据!----");
    }

    @Override
    public String say(String value) {
        return "静态代理目标对象："+value;
    }
}
