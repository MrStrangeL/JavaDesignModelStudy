package com.study.main;

import com.study.designmodel.factorymodel.abstractfactory.AbstractDaYiFactory;
import com.study.designmodel.factorymodel.abstractfactory.AbstractFenQinFactory;
import com.study.designmodel.factorymodel.factory.BlackTeaFactory;
import com.study.designmodel.factorymodel.factory.ColaFactory;
import com.study.designmodel.factorymodel.factory.GreenTeaFactory;
import com.study.designmodel.factorymodel.factory.MilkTeaFactory;
import com.study.designmodel.factorymodel.simplefactory.SimpleFactory;
import com.study.designmodel.factorymodel.simplefactory.SimpleProduct;
import com.study.designmodel.proxymodel.dynamicproxy.*;
import com.study.designmodel.proxymodel.staticproxy.UserDao;
import com.study.designmodel.proxymodel.staticproxy.UserDaoProxy;
import com.study.reflect.People;
import com.study.reflect.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        System.out.println("-----------------------------------简单工厂模式-----------------------------------");
        //通过工厂去实例化具体的产品
        SimpleProduct blackTea= SimpleFactory.getSimpleProduct("BlackTea");
        blackTea.introduce();

        SimpleProduct cola=SimpleFactory.getSimpleProduct("Cola");
        cola.introduce();

        SimpleProduct greenTea=SimpleFactory.getSimpleProduct("GreenTea");
        greenTea.introduce();

        SimpleProduct milkTea=SimpleFactory.getSimpleProduct("MilkTea");
        milkTea.introduce();

        System.out.println("-----------------------------------工厂模式-----------------------------------");
        //创建具体工厂BlackTea
        BlackTeaFactory blackTeaFactory=new BlackTeaFactory();
        //生产具体产品BlackTea
        blackTeaFactory.getProduct().introduce();

        ColaFactory colaFactory =new ColaFactory();
        colaFactory.getProduct().introduce();

        GreenTeaFactory greenTeaFactory=new GreenTeaFactory();
        greenTeaFactory.getProduct().introduce();

        MilkTeaFactory milkTeaFactory=new MilkTeaFactory();
        milkTeaFactory.getProduct().introduce();

        System.out.println("-----------------------------------抽象工厂模式-----------------------------------");
        //创建具体的工厂
        AbstractDaYiFactory abstractDaYiFactory=new AbstractDaYiFactory();
        //生产产品
        abstractDaYiFactory.getProductBlackTea().introduce();
        abstractDaYiFactory.getProductGreenTea().introduce();
        abstractDaYiFactory.getProductMilkTea().introduce();

        AbstractFenQinFactory abstractFenQinFactory=new AbstractFenQinFactory();
        abstractFenQinFactory.getProductBlackTea().introduce();
        abstractFenQinFactory.getProductGreenTea().introduce();
        abstractFenQinFactory.getProductMilkTea().introduce();

        System.out.println("-----------------------------------反射-----------------------------------");
        //User的实例
        User userOne=new User();
        //获取User的类类型,方法一：本质是告诉我们任何一个类都有一个隐含的静态成员变量class
        Class<User> classOne=User.class;
        System.out.println("classOne:"+classOne.toString());

        //获取User的类类型,方法二：通过该类实例对象的 getClass() 方法获取
        Class<? extends User> classTwo=userOne.getClass();
        System.out.println("classTwo:"+classOne.toString());

        //获取User的类类型,根据全类名获取Class
        Class classThree = Class.forName("com.study.reflect.User");
        System.out.println("classThree:"+classOne.toString());

        //检验Class是否是唯一不变的
        System.out.println(classOne==classTwo&&classTwo==classThree);

        //通过类类型创建User的实例
        User userTwo=classOne.newInstance();
        userTwo.sayHello();

        User userThree=classTwo.newInstance();
        userThree.sayHello();

        User userFour= (User) classThree.newInstance();
        userFour.sayHello();

        //加载Class对象
        Class classPeople= People.class;
        System.out.println("-----------------------------------所有公有构造方法-----------------------------------");
        //获取所有公有构造方法
        Constructor[] conArrayPublic=classPeople.getConstructors();
        for(Constructor conTemp:conArrayPublic){
            System.out.println(conTemp);
        }

        System.out.println("-----------------------------------所有构造方法-----------------------------------");
        //获取所有构造方法
        Constructor[] conArrayAll=classPeople.getDeclaredConstructors();
        for(Constructor conTemp:conArrayAll){
            System.out.println(conTemp);
        }

        System.out.println("-----------------------------------公有、无参的构造方法-----------------------------------");
        //获取公有、无参的构造方法
        Constructor conPublicNoneParam=classPeople.getConstructor();
        System.out.println(conPublicNoneParam);
        //调用构造方法
        conPublicNoneParam.newInstance();

        System.out.println("-----------------------------------私有的构造方法-----------------------------------");
        //获取私有的构造方法
        Constructor conPrivate=classPeople.getDeclaredConstructor(boolean.class);
        System.out.println(conPrivate);
        //调用构造方法
        //暴力访问，忽略访问修饰符
        conPrivate.setAccessible(true);
        conPrivate.newInstance(true);
        conPrivate.setAccessible(false);

        System.out.println("-----------------------------------公有、两个参的构造方法-----------------------------------");
        //获取公有、两个参的构造方法
        Constructor conPublicTwoParam=classPeople.getConstructor(String.class,int.class);
        System.out.println(conPublicTwoParam);
        //调用构造方法
        conPublicTwoParam.newInstance("刘杨斌",26);

        System.out.println("-----------------------------------所有公有字段-----------------------------------");
        //获取所有公有字段
        Field[] fieldsPublicAll=classPeople.getFields();
        for(Field fieldTemp:fieldsPublicAll){
            System.out.println(fieldTemp);
        }

        System.out.println("-----------------------------------所有字段-----------------------------------");
        //获取所有字段
        Field[] fieldsAll=classPeople.getDeclaredFields();
        for(Field fieldTemp:fieldsAll){
            System.out.println(fieldTemp);
        }

        System.out.println("-----------------------------------公有字段-----------------------------------");
        //获取公有字段
        Field fieldPublic=classPeople.getField("name");
        System.out.println(fieldPublic);
        //获取一个对象
        Object objectOne=classPeople.getConstructor().newInstance();
        fieldPublic.set(objectOne,"刘杨斌");
        //验证
        People peopleOne=(People)objectOne;
        System.out.println(peopleOne.getName());

        System.out.println("-----------------------------------私有字段-----------------------------------");
        //获取私有字段
        Field fieldPrivate=classPeople.getDeclaredField("height");
        System.out.println(fieldPrivate);
        //获取一个对象
        Object objectTwo=classPeople.getConstructor().newInstance();
        fieldPrivate.setAccessible(true);
        fieldPrivate.set(objectTwo,175);
        fieldPrivate.setAccessible(false);
        //验证
        People peopleTwo=(People)objectTwo;
        System.out.println(peopleTwo.getHeight());

        System.out.println("-----------------------------------受保护字段-----------------------------------");
        //获取受保护字段
        Field fieldProtect=classPeople.getDeclaredField("age");
        System.out.println(fieldProtect);
        //获取一个对象
        Object objectThree=classPeople.getConstructor().newInstance();
        fieldProtect.setAccessible(true);
        fieldProtect.set(objectThree,26);
        fieldProtect.setAccessible(false);
        //验证
        People peopleThree=(People)objectThree;
        System.out.println(peopleThree.getAge());

        System.out.println("-----------------------------------所有公有方法-----------------------------------");
        //获取所有公有的方法
        Method[] methodsPublicAll=classPeople.getMethods();
        for(Method methodTemp:methodsPublicAll){
            System.out.println(methodTemp);
        }

        System.out.println("-----------------------------------所有方法-----------------------------------");
        //获取所有方法
        Method[] methodsAll=classPeople.getDeclaredMethods();
        for(Method methodTemp:methodsAll){
            System.out.println(methodTemp);
        }

        System.out.println("-----------------------------------获取公有方法method1-----------------------------------");
        Method method1=classPeople.getMethod("method1",String.class);
        System.out.println(method1);
        //获取一个对象
        Object objectFour=classPeople.getConstructor().newInstance();
        //调用method1方法
        method1.invoke(objectFour,"刘杨斌");

        System.out.println("-----------------------------------获取私有方法method4-----------------------------------");
        Method method4=classPeople.getDeclaredMethod("method4",int.class);
        System.out.println(method4);
        //获取一个对象
        Object objectFive=classPeople.getConstructor().newInstance();
        method4.setAccessible(true);
        //调用并且获取返回值
        Object result=method4.invoke(objectFive,26);
        method4.setAccessible(false);
        System.out.println("返回值："+result);

        System.out.println("-----------------------------------逃避泛型检查-----------------------------------");
        //这里限定了ArrayList里面只能存放String型的数据
        ArrayList<String> strArrayList=new ArrayList<String>();
        strArrayList.add("您好");
        strArrayList.add("刘杨斌");
        for(Object temp:strArrayList){
            System.out.println(temp);
        }

        //通过反射可以逃避ArrayList的泛型检查，可以在限定了String的ArrayList中存入int类型的数据
        Class<? extends ArrayList> classArrayList=strArrayList.getClass();
        Method add=classArrayList.getMethod("add",Object.class);
        add.invoke(strArrayList,1994);
        add.invoke(strArrayList,26);
        for(Object temp:strArrayList){
            System.out.println(temp);
        }

        System.out.println("-----------------------------------静态代理模式-----------------------------------");
        //目标对象
        UserDao targetStatic=new UserDao();
        //代理对象，把目标对象传给代理对象，建立代理关系
        UserDaoProxy proxyStatic=new UserDaoProxy(targetStatic);
        //执行代理的方法
        proxyStatic.save();
        System.out.println(proxyStatic.say("哈哈"));

        System.out.println("-----------------------------------动态代理模式-----------------------------------");
        //目标对象
        com.study.designmodel.proxymodel.dynamicproxy.UserDao targetDynamic=new com.study.designmodel.proxymodel.dynamicproxy.UserDao();
        //原始的类类型
        System.out.println(targetDynamic.getClass());
        //给目标对象创建代理对象
        IUserDao proxyDynamic= (IUserDao) new ProxyFactory(targetDynamic).getProxyInstanceTwo();
        //内存中动态生成的代理对象
        System.out.println(proxyDynamic.getClass());
        proxyDynamic.save();
        System.out.println(proxyDynamic.say("哈哈"));

        System.out.println("-----------------------------------Cglib代理模式-----------------------------------");
        //目标对象
        com.study.designmodel.proxymodel.cglibproxy.UserDao targetCglib=new com.study.designmodel.proxymodel.cglibproxy.UserDao();
        //代理对象
        com.study.designmodel.proxymodel.cglibproxy.UserDao proxyCglib= (com.study.designmodel.proxymodel.cglibproxy.UserDao) new com.study.designmodel.proxymodel.cglibproxy.ProxyFactory(targetCglib).getProxyInstance();
        //执行代理对象方法
        proxyCglib.save();
        System.out.println(proxyCglib.say("欧阳先森"));

        System.out.println("-----------------------------------Java集合-----------------------------------");
        List list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("-----------------------------------AOP-----------------------------------");
        ICal target=new CalImp();
        ICal proxy=(ICal)new CalProxyFactory(target).getCalProxyInstance();
        proxy.jia(1,2);
        proxy.jian(1,2);
        proxy.chen(1,2);
        proxy.chu(1,2);
    }
}
