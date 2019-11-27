package com.algorithm4;

/**
 * ≤Â»Î≈≈–Ú
 */
public class Insertion{
    public static void sort(Comparable[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(nums[j],nums[j - 1])) {
                    exch(nums, j, j-1);
                }
            }
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
