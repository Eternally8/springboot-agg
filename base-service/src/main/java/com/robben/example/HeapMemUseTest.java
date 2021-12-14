package com.robben.example;

public class HeapMemUseTest {

    /**
     * 在VM options中添加-Dfile.encoding=UTF-8 -Xmx1m -Xms1m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./oom.out
     * 其中-XX:+HeapDumpOnOutOfMemoryError 指开启OOM后保存dump文件
     * -XX:HeapDumpPath=./oom.out 指定保存的位置
     * @param args
     */
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(1);
        while(true) {
            sb.append(System.currentTimeMillis());
        }
    }

//    public static void main(String[] args) {
//        System.out.println(1);
//    }

}
