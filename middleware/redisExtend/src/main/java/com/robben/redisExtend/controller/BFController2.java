package com.robben.redisExtend.controller;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;


public class BFController2 {

    public static void main(String[] args) {
        BloomFilter<String> bloomFilter2 = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),100000,0.01);
        bloomFilter2.put("10086");
        System.out.println(bloomFilter2.mightContain("123456"));
        System.out.println(bloomFilter2.mightContain("10086"));
    }

}
