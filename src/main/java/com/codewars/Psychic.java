package com.codewars;

import java.util.Random;

public class Psychic {
    public static double guess() {
        //Do, or do not. There is no try.
        Math.random();
//        return 0L;

        Random r1 = new Random(1);
        Random r2 = new Random(1);
        r1.nextDouble();

        return 0L;
    }

    public static void main(String[] args) {
        System.out.println(Math.random());
        System.out.println(Math.random());
    }
}
