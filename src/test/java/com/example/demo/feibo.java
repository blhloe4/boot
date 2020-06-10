package com.example.demo;

public class feibo {
    public static void main(String[] args) {
        int first = 0;
        int second = 1;
        int third = 0;
        int n = 10;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        System.out.println(third);
    }
}
