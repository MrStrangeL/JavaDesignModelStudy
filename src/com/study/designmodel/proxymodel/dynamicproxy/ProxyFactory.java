package com.study.designmodel.proxymodel.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 创建动态代理对象
 * 动态代理不需要实现接口，但是需要指定接口类型
 */
public class ProxyFactory {
    //目标对象
    private Object target;

    public ProxyFactory(Object target){
        this.target=target;
    }

    //给目标对象生成代理对象
    public Object getProxyInstanceOne(){
        ClassLoader classLoader=target.getClass().getClassLoader();
        System.out.println(classLoader);
        Class [] classInterfaces=target.getClass().getInterfaces();
        for(Class temp:classInterfaces){
            System.out.println(temp);
        }
        InvocationHandler invocationHandler=new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("动态代理：开始事务2");
                //运用反射执行目标对象方法
                Object returnValue = method.invoke(target, args);
                System.out.println("动态代理：提交事务2");
                return returnValue;
            }
        };
        return Proxy.newProxyInstance(classLoader,classInterfaces,invocationHandler);
    }

    //给目标对象生成代理对象
    public Object getProxyInstanceTwo(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("动态代理：开始事务2");
                //运用反射执行目标对象方法
                Object returnValue = method.invoke(target, args);
                System.out.println("动态代理：提交事务2");
                return returnValue;
            }
        });
    }
}
