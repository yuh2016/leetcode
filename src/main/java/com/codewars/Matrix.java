package com.codewars;

/**
 * �׳�Neo�쳣
 */
public class Matrix {
    public static void enter(){
        try {
            throw new Error();
        } catch (Error error) {
            throw new RuntimeException(new Neo());
        }
    }
}
