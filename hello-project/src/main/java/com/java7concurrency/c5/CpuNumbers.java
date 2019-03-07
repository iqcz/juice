package com.java7concurrency.c5;

public class CpuNumbers {

    public static void main(String[] args) {
        int cpuNumber = Runtime.getRuntime().availableProcessors();

        System.out.println(cpuNumber);
    }
}
