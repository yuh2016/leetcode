package com.algorithm4;

public class MergeBU {
    private static Comparable[] aux;

    /**
     * �Ե����ϵĹ鲢����
     * @param c
     */
    public static void sort(Comparable[] c) {
        int n = c.length;
        aux = new Comparable[c.length];
        //size��ʾ������
        for(int size = 1; size < n; size = size + size){
            //lo��ʾÿ����ȵ�С��������
            for (int lo = 0; lo < n - 1; lo = size+size) {
                merge(c, lo, lo + size - 1, Math.min(n-1, lo+size+size - 1));
            }
        }
    }



    /**
     * ԭ�ع鲢�ĳ��󷽷�
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
