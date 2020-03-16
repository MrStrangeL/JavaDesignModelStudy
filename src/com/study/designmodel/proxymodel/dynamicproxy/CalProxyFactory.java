package com.study.designmodel.proxymodel.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CalProxyFactory {
    private Object target;

    public CalProxyFactory(Object target){
        this.target=target;
    }

    public Object getCalProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName()+"方法的参数："+ Arrays.toString(args));
                Object resultObj=method.invoke(target,args);
                System.out.println(method.getName()+"的结果是："+ resultObj);
                return resultObj;
            }
        });
    }
}
