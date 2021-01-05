package com.chinange.grow.jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

/**
 *  方法调用
 *
 *  -XX:TypeProfileWidth  设置 内联缓存的类型个数   -XX: +printGC  打印gc情况
 *  -XX:+ShowHiddenFrames  打印被虚拟机隐藏的栈信息
 *
 *  invokestatic 调用静态方法
 *  invokespecial  调用接口默认方法  私有实例方法  构造器   super()
 *  invokevirtual   调用非私有实例方法
 *  invokeinterface  调用接口方法
 *
 *  上面的4种方法调用指令  都与 目标方法类名、方法名以及方法描述符 用符号引用进行了捆绑  所以在运行过程中都非常明确具体该调用哪个方法
 *
 *  invokedynamic 调用动态方法  在多态情况下  编译.java文件的时候并不知道具体的实例类型  因此只能采取符号占位
 *
 *  方法句柄  MethodHandle
 *
 *
 */
public class MethodInvoke {

    public static void main(String[] args) {
        //MethodType
        //MethodHandle

    }

}
