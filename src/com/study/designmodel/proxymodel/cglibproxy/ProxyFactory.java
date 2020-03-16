package com.study.designmodel.proxymodel.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib子类代理工厂
 */
public class ProxyFactory implements MethodInterceptor {
    //目标对象
    private Object target;

    public ProxyFactory(Object target){
        this.target=target;
    }

    //给目标对象创建一个代理对象
    public Object getProxyInstance(){
        //工具类
        Enhancer enhancer=new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //创建子类(代理对象)
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib代理对象：开始事务...");

        //执行目标对象的方法
        Object returnValue = method.invoke(target, objects);

        System.out.println("Cglib代理对象：提交事务...");

        return returnValue;
    }
}
