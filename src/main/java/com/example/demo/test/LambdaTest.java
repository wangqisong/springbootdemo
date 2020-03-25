package com.example.demo.test;

/**
 * @author: wangqisong
 * @date: 2020/3/24
 * @Description:
 */
public class LambdaTest {
    public static void main(String[] args) {
        Calculate1 c  = (a,b)->{return a+b; };
        System.out.println(c.add(1, 2));
    }

    interface Calculate1{
        int add(int a ,int b);
    }

    interface Calculate2{
        int add(int a ,int b);
    }
}
