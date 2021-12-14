package com.robben.example;

public class JvmTest {
    public int Match(){
        int a = 100;
        int b = 200;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        JvmTest M = new JvmTest();
        int a = M.Match();
        System.out.println(a);

        int aa =1;
        int bb = aa;
        bb = 0;
        System.out.println(aa);

    }
}
