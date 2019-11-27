package com.algorithm4;

import java.util.Arrays;

public class Shell{
    public static void sort(Comparable[] c) {
        int len = c.length;
        int h = 1;  //最终要以1结尾进行插入排序
        while (h < len / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < c.length; i ++) {
                for (int j = i; j >= h && less(c[j], c[j-h]); j -= h) {
                    exch(c, j, j-h);
                }
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{4,76,32,22,1,5,44,0,63,9,46,27};
        Shell.sort(nums);
        Arrays.stream(nums).forEach(num -> System.out.print(num + " "));
    }

    public static void exch( Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
