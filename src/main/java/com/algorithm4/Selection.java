package com.algorithm4;

/**
 * —°‘Ò≈≈–Ú
 */
public class Selection {
    public static void sort(Comparable[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i; j < nums.length; j++) {
                if (less(nums[j],nums[i])) {
                    min = j;
                }
            }
            exch(nums, i, min);
        }
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
