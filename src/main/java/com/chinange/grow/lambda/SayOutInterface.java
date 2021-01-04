package com.chinange.grow.lambda;

public interface SayOutInterface {
    default void say(){
        System.out.println(" hahaha , i`m the default ");
    }
}
