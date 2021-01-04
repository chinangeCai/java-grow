package com.chinange.grow.lambda;

/**
 * 季节枚举类
 *
 * ** 通过属性，携带不同的信息，这和注解Annotation的属性一样，但是枚举的属性是固定的，而注解的属性值可以自定义
 */
public enum SeasonEnum {

    SPRING(0), SUMMER(1), AUTUMN(2), WINTER(3);
    private int seq;
    SeasonEnum(int seq){
        this.seq = seq;
    }

    public int getSeq(){
        return seq;
    }
}
