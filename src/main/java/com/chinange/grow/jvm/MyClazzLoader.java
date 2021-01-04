package com.chinange.grow.jvm;

/**
 * 类加载学习
 *
 *
 * 类加载器分为3大类                  bootStrapClassLoader = null , c++代码实现, java中为null, 由系统的 CREATE_CLASSLOADER_PERMISSION 参数进行监测
 * 其他加载器均为 ClassLoader的子类    extentionClassLoader 扩展类加载器   applicationClassLoader 应用类加载器
 *
 * 可以利用自定义classLoader 对.class文件进行加密解密 达到源码防泄漏的目的
 *
 *  类加载分为: 加载   连接   初始化3个阶段      连接分为: 验证  准备  解析
 *
 *
 *  双亲委派模式:    双亲大概是指  parent or bootstrap  所以不是单亲，但实际类加载只会选择其一
 *                     if (parent != null) {
 *                         c = parent.loadClass(name, false);
 *                     } else {
 *                         c = findBootstrapClassOrNull(name);
 *                     }
 * 如果父加载器没有加载就由启动类加载器进行加载    如果依然没有  就需要调用  findClass 方法  该方法为模板方法
 * 将.class文件加载到内存中
 *
 * 连接:
 * 验证:   验证.class文件是否符合java虚拟机约束条件
 * 准备:   给.class文件中的 字段开辟存储空间, 构造类层次的数据结构 ex: 实现虚方法动态调用的方法表
 * 解析:   将符号引用绑定到具体引用
 *
 *
 * 初始化: 为字段进行赋值, 并执行 clinit方法,   静态代码块会在编译阶段被放入clinit方法中, jvm会通过加锁,确保clinit方法只执行一次
 *
 */
public class MyClazzLoader extends ClassLoader {



}
