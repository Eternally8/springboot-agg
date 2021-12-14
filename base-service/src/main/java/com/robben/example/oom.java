package com.robben.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Description： TODO
 * Author: robben
 * Date: 2021/4/25 17:52
 */
public class oom {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        long a = 0;
        while(true){
            a++;
            list.add(a + "");
        }


    }

}
