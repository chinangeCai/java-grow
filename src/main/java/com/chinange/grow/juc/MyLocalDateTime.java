package com.chinange.grow.juc;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class MyLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime current = LocalDateTime.now();
        System.out.println(current); // 2020-09-29T18:20:33.667
        /*LocalDateTime parse = LocalDateTime.parse("2020-09-29");
        System.out.println(parse);*/
        System.out.println(new Date());

        LocalDateTime localDateTime = current.withDayOfMonth(10).withYear(2012);
        System.out.println(localDateTime);

        LocalDate of = LocalDate.of(2012, 9, 10);
        System.out.println(of);
        LocalTime of1 = LocalTime.of(22, 30);
        System.out.println(of1.getNano());

    }
}
