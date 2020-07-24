package com.example.demo.suanfa.digui;

import java.util.ArrayList;
import java.util.List;

public class KuoHao {
    private static List<String> list = new ArrayList();
    public static void main(String[] args) {
        int n = 3;
        String str="";
        List<String> strings = generateParenthesis(n);
        System.out.println(strings.toString());
    }
    public static List<String> generateParenthesis(int n) {
        return generate(0,0,n,"");
    }
    private static List<String> generate(int left,int right, int max, String string) {
        if (right ==max&&left==max) {
            list.add(string);
            return list;
        }
        if (right>=max){
            return list;
        }
        if(right>left){
            return list;
        }
        if (left<max){
            generate(left+1,right, max, string + "(");
        }
        if (right<max){
            generate(left,right+1, max, string + ")");
        }
        return list;
    }


}
