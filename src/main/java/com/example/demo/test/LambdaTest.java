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
        Calculate2 c2  = (int a, int... b) ->{
            int sum =a+0;
            for (int i = 0; i <b.length ; i++) {
                sum = sum+b[i];
            }
            return sum;
        };
        System.out.println(c2.add(1,2,3,4,5));
    }

    interface Calculate1{
        int add(int a ,int b);
    }

    interface Calculate2{
        int add(int a ,int... b);
    }
}
