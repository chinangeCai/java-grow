package com.chinange.grow.jvm;

/**
 *  编译类异常,在代码编译阶段就会被监测
 *
 *  在编写代码的时候如果影响业务的正常运行,并显示的定位到某处执行不符合预期,则使用 extends Exception
 *  大部分情况使用
 */
public class GrowException  extends Exception{
    private static final long serialVersionUID = 1L;
    public GrowException(){}
    public GrowException(String message){
        super(message);
    }
    public GrowException(Throwable t){
        super(t);
    }

    public static void main(String[] args) {
        new GrowException().printStackTrace();  //  打印方法栈的栈轨迹
    }
}


/**
 *  运行类异常,在代码运行阶段才会抛出
 *
 *  该类异常并不会显示抛出,只会在程序执行期间抛出，如不影响正常业务流程, 仅运行期间未按预期执行,则使用 extends RuntimeException
 *  详见 shiro 源码  WeBase 源码
 */
class GrowRuntimeException extends  RuntimeException {
    private static final long serialVersionUID = 2L;
    public GrowRuntimeException(){}
    public GrowRuntimeException(String message){
        super(message);
    }
    public GrowRuntimeException(Throwable t){
        super(t);
    }
}