package com.littleball.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        String str = "com.littleball.reflection.T";
        Class c = Class.forName(str);
        Object t =c.newInstance();
        //System.out.println("123-"+c.getMethod("mm",int.class).getName());
        for (Method method:c.getMethods()) {
            if(method.getName().equals("m")){

                method.invoke(t,56);
                Class[] type = method.getParameterTypes();
                for (Class cl:type) {
                    System.out.println(cl.getName());

                }


            }
            System.out.println(method);
            //System.out.println(method.getName());
        }



    }
}

class T {
    static {
        System.out.println("T: loaded.");
    }

    public T(){
        System.out.println("T: constructed.");
    }

    public void m(int i){
        System.out.println("func-m  i = "+i);
    }

    public void mm(){
        System.out.println("func-mm");
    }
}