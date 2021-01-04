package com.chinange.grow.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaDemo1 {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList();
        for (int i = 0; i < 10; i++) {
            persons.add(new Person("第"+i+"儿子", 8+i));
        }
        /*Person p = new Person("haha",16);
        p.getAge();*/

        //Comparator<Person> c = (p1, p2)-> p2.getAge() - p1.getAge();
        //Collections.sort(persons, c);
        Collections.sort(persons, (p1, p2)-> p2.age - p1.age);
        for (Person p : persons) {
            System.out.println(p.getName() + p.getAge());
        }
    }
}
