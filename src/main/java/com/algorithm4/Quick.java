package com.algorithm4;

import java.util.Arrays;

public class Quick {

    public static void sort(Comparable[] c) {
        StdRandom.shuffle(c);
        sort(c, 0, c.length - 1);
    }

    private static void sort(Comparable[] c, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partition(c, lo, hi);
        sort(c, lo, j - 1);
        sort(c, j + 1, hi);

        Arrays.sort(c);
    }

    /**
     * ÇÐ·Ö³ÌÐò
     * @param c
     * @param lo
     * @param hi
     * @return
     */
    private static int partition(Comparable[] c, int lo, int hi) {
        Comparable v = c[lo];

        int i = lo, j = hi + 1;
        while (true) {
            while (less(c[++i], v)) {
                if (i >= hi) {
                    break;
                }
            }

            while (less(v, c[--j])) {
                if (j <= lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(c, i, j);
        }
        exch(c, lo, j);
        return j;
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
