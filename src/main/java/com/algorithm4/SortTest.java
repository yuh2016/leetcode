package com.algorithm4;

public class SortTest {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{2,5,7,9,5,8,12,22};
//        Integer[] a = new Integer[]{8,5,7,9,10,6,12,22};
        /*int i = 3;
        System.out.println(a[i--]);
        System.out.println(a[i]);*/
        Quick.sort(a);
        for (Integer i : a) {
            System.out.print(i + " ");
        }
    }
}
