package com.algorithm4;

public class Merge {
    private static Comparable[] aux;
    public static void sort(Comparable[] c) {
        aux = new Comparable[c.length];
        sort(c, 0, c.length - 1);
    }


    /**
     * 自顶向下的归并方法
     * @param c
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] c, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo)/2;
        sort(c, lo, mid);
        sort(c, mid + 1, hi);
        merge(c, lo, mid, hi);
    }



    /**
     * 原地归并的抽象方法
     * @param c
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] c, int lo, int mid, int hi) {
        for (int k = 0; k < c.length; k++) {
            aux[k] = c[k];
        }

        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; k ++){
            if (i > mid) {
                c[k] = aux[j++];
            }else if (j > hi) {
                c[k] = aux[i++];
            }else if(less(aux[i], aux[j])) {
                c[k] = aux[i++];
            }else{
                c[k] = aux[j++];
            }
        }
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
