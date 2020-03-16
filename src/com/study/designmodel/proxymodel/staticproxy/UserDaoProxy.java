package com.study.designmodel.proxymodel.staticproxy;


/**
 * 接口实现
 * 代理对象
 * 静态代理
 */
public class UserDaoProxy implements IUserDao{
    //接收保存目标对象
    private IUserDao target;

    public UserDaoProxy(IUserDao target){
        this.target=target;
    }

    @Override
    public String say(String value) {
        return target.say(value);
    }

    @Override
    public void save() {
        System.out.println("静态代理代理对象：开始事务...");
        //执行目标对象的方法
        target.save();
        System.out.println("静态代理代理对象：提交事务...");
    }
}
