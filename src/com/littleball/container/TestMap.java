package com.littleball.container;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int temp;
        for (int i = 0; i < args.length; i++) {
            if (map.containsKey(args[i])) {
                temp = map.get(args[i]);
                map.put(args[i], temp + 1);
            }else {
                map.put(args[i],1);
            }
        }
        System.out.println(map);
//        List list = new LinkedList();
//        list.add(0,"a");
//        list.add(1,"b");
//        System.out.println(list.set(1,"bb"));
//        list.add(2,"c");
//        Map map = new HashMap();
//        map.put("1","a");
//        map.put("2","b");
//        System.out.println(map.put("2","bb"));
//        System.out.println(map.put("3","c"));
//        map.put("4",1);
//        System.out.println(map.size());
    }
}
