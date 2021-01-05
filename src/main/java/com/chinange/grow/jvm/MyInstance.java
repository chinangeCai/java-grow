package com.chinange.grow.jvm;


/**
 *  创建对象的方法:  new  , clone , Class.getInstance , deSerializer, Unsafe.allocateInstance
 *  MyInstance@15db9742    MyInstance@6d06d69c  浅拷贝对象的堆内地址值不一样 所以对象并不是同一个对象  但是对象内部的指针引用是同一个
 *
 *  对象头   对象体    对象头包括 标记字段和类型指针  在64位的计算机中  标记字段8字节  类型指针8字节  所以默认情况下对象头会多占用内存16字节
 *
 *  -XX:+UseCompressedOops 压缩指针命令会将类型指针压缩为4字节   对象头占用内存12字节  -XX:ObjectAlignmentInBytes  内存对齐选项   对象在内存中默认占用8n字节,如果未满则使用padding填充
 *  之所以要对齐  主要是保证字段出现在cpu的同一缓存行
 *
 *  字段重排列  为了让对象占用内存为8n字节，虚拟机会将对象内字段进行重排列
 *
 *  curl -L -O http://central.maven.org/maven2/org/openjdk/jol/jol-cli/0.9/jol-cli-0.9-full.jar
 *  java -cp jol-cli-0.9-full.jar org.openjdk.jol.Main internals java.lang.String
 *
 *  GC:  如何知道对象死亡了    引用计数法    可达性分析法
 *
 *  引用计数: 添加对象计数器,当对象被引用时+1; 当对象方法调用结束引用-1 为0则死亡   : 存在弊端  a-b 互相引用则计数不为0实际死亡
 *  可达性分析法: 以GC roots对象为根 搜索被引用对象集合  当没有被引用则认为对象死亡
 *  GC roots:  未死亡java线程 , JNI handle ,加载类的静态变量 , java方法栈帧中的局部变量
 *  在多线程环境下   可达性分析法  可能会将其他线程引用的对象误认为没有引用而删掉 从而严重时造成程序崩溃
 *  所以在full gc的时候, JVM会将其他非垃圾回收线程暂停 stop-the-world  safe-point (GC pause)
 *
 *  大部分的对象调用后即死亡   小部分的对象会在内存中存活很久   因此产生了堆内存分代和回收策略不同的思想
 *
 *  -XX:+UsePSAdaptiveSurvivorSizePolicy  默认动态分配堆空间
 *  -XX:SurvivorRatio     指定eden 和 survivor比例  8  浪费10%的堆内存 即 1比例的to/from区将会一直空着
 *
 *  -XX:+UseTLAB  jvm为线程提供的额外的加锁内存空间  因为堆内存是共享的 所以通过TLAB来处理对象的存储，防止多线程环境下多个线程将多个对象放置在同一片内存区域
 *  当某个线程的TLAB不够用了,jvm会采用加锁的方式再次为线程提供一段连续内存 也就是 from - to指针之间内存区域
 *
 *  -XX:+MaxTenuringThreshold 复制算法下对象被复制了默认15次   就会放到老年代
 *  -XX:TargetSurvivorRatio   指定survivor区的比例，默认50%,当survivor区占用超过50%,将会把复制次数多的对象 放到老年代
 *
 *  volatile 字段的内存屏障其本质是无法加载到 寄存器中 所以每次读只能从内存中获取  理想情况是 1写n读
 */
public class MyInstance implements Cloneable {

    public MyInstance(){}

    public static void main(String[] args) throws CloneNotSupportedException {
        MyInstance i1 = new MyInstance();
        MyInstance clone = (MyInstance) i1.clone();

        System.out.println(i1);
        System.out.println(clone);

    }


}
