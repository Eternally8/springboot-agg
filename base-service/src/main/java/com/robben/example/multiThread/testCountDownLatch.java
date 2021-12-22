package com.robben.example.multiThread;

import cn.hutool.core.date.SystemClock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//实现线程同时并发执行任务
public class testCountDownLatch {
    CountDownLatch countDownLatch = new CountDownLatch(1);
    private  void runThread(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<20 ;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                        System.out.println("Thread:"+Thread.currentThread().getName()+",time: "+ SystemClock.now());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        countDownLatch.countDown();
    }

    public static void main(String[] args) {
        testCountDownLatch test = new testCountDownLatch();
        test.runThread();
    }
}
