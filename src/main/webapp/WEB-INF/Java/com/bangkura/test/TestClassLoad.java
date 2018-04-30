package com.bangkura.test;

import java.lang.reflect.Method;

class SuperClass {
    public static final String staticvalue = "staticvalue";
    public static final int value = Math.abs(10);
    static {
        System.out.println("preparing super class");
    }
    public void method1() {}
    public void method2() {}
}

public class TestClassLoad {
    public static void main(String[] args) {
        Class superclass = SuperClass.class;
        for(Method method : superclass.getDeclaredMethods()) {
            System.out.println(method.getName());
        }
        System.out.println("this will not invoke the class loading");
        String staticvalue = SuperClass.staticvalue;
        System.out.println("static value will not invoke the class loading");
        //int value = SuperClass.value;
        System.out.println("Non-static value will invoke the class loading");
        try {
            Class superclass2 = Class.forName("com.SuperClass");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
