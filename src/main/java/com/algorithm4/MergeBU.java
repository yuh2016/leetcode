package com.algorithm4;

public class MergeBU {
    private static Comparable[] aux;

    /**
     * 自底向上的归并方法
     * @param c
     */
    public static void sort(Comparable[] c) {
        int n = c.length;
        aux = new Comparable[c.length];
        //size表示数组跨度
        for(int size = 1; size < n; size = size + size){
            //lo表示每个跨度的小数组的左边
            for (int lo = 0; lo < n - 1; lo = size+size) {
                merge(c, lo, lo + size - 1, Math.min(n-1, lo+size+size - 1));
            }
        }
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
