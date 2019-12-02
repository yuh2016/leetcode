package com.algorithm4;

public class SortTest {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{2,5,7,9,5,8,12,22};
        Merge.sort(a);
        for (Integer i : a) {
            System.out.print(i + " ");
        }
    }
}
