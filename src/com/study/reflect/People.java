package com.study.reflect;

public class People {
    public String name;
    protected int age;
    String sex;
    private int height;
    public People(){
        System.out.println("无参构造器");
    }

    public People(String name){
        System.out.println("一个参数参构造器 name:"+name);
    }

    public People(String name,int age){
        System.out.println("两个参构造器 name:"+name+" age:"+age);
    }

    protected People(int age){
        System.out.println("受保护的构造器 age:"+age);
    }

    private People(boolean isPrivate){
        System.out.println("私有构造器 isPrivate："+isPrivate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void method1(String s){
        System.out.println("方法名为【method1】,公有的，无返回值，参数类型为String："+s);
    }
    protected void method2(){
        System.out.println("方法名为【method2】,受保护的，无返回值,无参");
    }
    void method3(){
        System.out.println("方法名为【method3】,默认的，无返回值,无参");
    }
    private String method4(int age){
        System.out.println("方法名为【method4】,私有的，有返回值，参数类型为int："+age);
        return "年龄为："+age;
    }
}
