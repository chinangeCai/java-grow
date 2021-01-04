package com.chinange.grow.jvm;

/**
 * 除堆中的基本类型  jvm在处理除long double等基本类型数据时,都是将其转型为int进行计算、比较
 * byte short int  long  float  double char boolean  8种基本类型 所有的基本类型的默认值都是0 浮点数除外
 * 1字节 2字节  4字节 8字节  4字节   8字节  2字节  1字节
 *
 *  .class文件即是 java字节码指令集,在JVM虚拟机中运行, JVM的实现遵循虚拟机规范
 *  command: javac HelloJava.java  -> HelloJava.class
 *           java HelloJava
 *
 */
public class HelloJava {
    public static void main(String[] args) {
        boolean flag = true;
        if(flag){
            System.out.println("hello java!");
        }else{
            System.out.println("hello jvm");
        }
    }
}
