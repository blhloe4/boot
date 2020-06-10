package com.example.demo.suanfa;

public class Climbstairs {
    private  static int times = 0;
    public static void main(String[] args) {
        int n = 4;
        int upp = upp(n);
        System.out.println(upp);
    }

    private static int upp(int n) {
        if(n<=2){
            return n;
        }
        times = upp(n-1)+upp(n-2);
        return times;
    }

}
