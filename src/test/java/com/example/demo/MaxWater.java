package com.example.demo;

class MaxWater {
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxArea(height);
        System.out.println(i);
    }

    public static int maxArea(int[] height) {
        int length = height.length-1;
        int area = 0;
        int result = 0;
        for (int i = 0; i <= length; ) {
            int high = height[length] < height[i] ? height[length] : height[i];
            area = high * (length - i);
            if (height[length] > height[i]) {
                i++;
            } else {
                length--;
            }
            result = area > result ? area : result;
            if (i == length) {
                return result;
            }
        }
        return result;
    }
}
