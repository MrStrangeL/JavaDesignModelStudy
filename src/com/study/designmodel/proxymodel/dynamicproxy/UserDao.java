package com.study.designmodel.proxymodel.dynamicproxy;


/**
 * 接口实现
 * 目标对象
 */
public class UserDao implements IUserDao {
    @Override
    public String say(String value) {
        return "动态代理目标对象："+value;
    }

    @Override
    public void save() {
        System.out.println("----动态代理目标对象：已经保存数据!----");
    }
}
