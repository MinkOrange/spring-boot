package com.mink.springboot.testweb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class TestCollection {
    public static void main(String[] args) {
      /*  HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("adc", "物理英雄");
        dictionary.put("apc", "魔法英雄");
        dictionary.put("t", "坦克");
        System.out.println(dictionary.get("t"));*/

        HashSet<Double> numbers = new HashSet<>();
        for(double i = 0;i < 10; i= i + 0.5){
            numbers.add(i);
        }

        System.out.println("迭代器遍历：");
        for(Iterator<Double> iterator = numbers.iterator();iterator.hasNext();){
            double i =  (double)iterator.next();
            System.out.println(i);
        }

        System.out.println("增强型for循环遍历:");
        for(Double i:numbers){
            System.out.println(i);
        }

        System.out.println("强制类型转换，Integer和int的区别:");
        int i =1;
        double j = (double)i;            //强制类型转换
        i = (int) j;
        System.out.println(Integer.parseInt("2018"));     //Integer,Float,Character实现int,float,char与字符串String之间的转换
        String a = i + "";                                   //int转换为String  方法1
        String b = Integer.toString(i);                      //int转换为String  方法2
        System.out.println(a + 1);
        System.out.println("b: " + b);
        String c = a + 2;
        System.out.println("c: " + c);

    }
}
