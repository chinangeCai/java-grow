package com.chinange.grow.lambda;

public class LambdaDemo2 {
    public static void main(String[] args) {
        LambdaDemo2 ld2 = new LambdaDemo2();
        // 类型声明
        MathOperation add = (int a, int b)->a+b;
        // 不声明类型
        MathOperation sub = (a, b)-> a-b;
        // 大括号返回语句
        MathOperation multiple = (int a, int b)->{return a*b;};
        // 没有大括号及返回语句
        MathOperation div = (a, b)-> a/b;

        System.out.println("9 + 3 = "+ld2.operate(9,3,add));
        System.out.println("9 - 3 = "+ld2.operate(9, 3, sub));
        System.out.println("9 * 3 = "+ld2.operate(9, 3, multiple));
        System.out.println("9 / 3 = "+ld2.operate(9, 3, div));

        GreetingService gs1 = (message) -> System.out.println("gs1 -> hello "+message);

        GreetingService gs2 = message -> System.out.println("gs2 -> hello "+message);

        gs1.sayMessage("welcome to lambda expresion");
        gs2.sayMessage("welcome to lambda expresion");
    }

    interface MathOperation {
        // 有返回值
        int operation(int a, int b);
    }
    interface GreetingService {
        // 没有返回值
        void sayMessage(String message);
    }
    private int operate(int a ,int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}


