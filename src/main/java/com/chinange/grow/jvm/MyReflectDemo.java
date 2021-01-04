package com.chinange.grow.jvm;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyReflectDemo {

    public static void main(String[] args) {
        //反射的创建
        // 1. 通过类的.class获取到
        Class<MyReflectDemo> aClass = MyReflectDemo.class;
        // 2. 通过全限定路径获取
        try {
            Class<?> bClass = Class.forName("com.chinange.grow.jvm.MyReflectDemo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 3. 通过对象获取
        Class<? extends MyReflectDemo> cClass = new MyReflectDemo().getClass();



        // 获取到类的接口
        Class<?>[] interfaces = aClass.getInterfaces();

        // 获取到声明的方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        // 获取到声明的变量
        Field[] declaredFields = aClass.getDeclaredFields();
        // 获取到声明的构造方法
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        // 获取到声明注解    类上标记的注解
        Annotation[] declaredAnnotations = aClass.getDeclaredAnnotations();

        // 获取到类的父类
        Class<? super MyReflectDemo> superclass = aClass.getSuperclass();

        // how : 父类的属性  父类的方法   封装的作用？

        Field[] sDeclaredFields = superclass.getDeclaredFields();
        Method[] sDeclaredMethods = superclass.getDeclaredMethods();

    }

}
