package com.littleball.container;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set s = new HashSet();
        s.add("hello");
        s.add(123);
        System.out.println(s.add(new Integer(123)));

        s.add("hello");

        Iterator iterator = s.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(s.size());



    }
}
