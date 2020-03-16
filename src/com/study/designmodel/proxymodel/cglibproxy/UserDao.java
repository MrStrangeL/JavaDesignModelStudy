package com.study.designmodel.proxymodel.cglibproxy;

/**
 * 目标对象
 */
public class UserDao {
    public void save() {
        System.out.println("----Cglib目标对象：已经保存数据!----");
    }

    public String say(String value){
        return "Cglib目标对象："+value;
    }
}
