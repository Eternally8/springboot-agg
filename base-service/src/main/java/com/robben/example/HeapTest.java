package com.robben.example;

import java.util.ArrayList;

public class HeapTest {
    byte[] a = new byte[1024*100];  //100KB

    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapTest> list = new ArrayList<>();
        while (true){
            list.add(new HeapTest());
            Thread.sleep(100);
        }
    }

}
