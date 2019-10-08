package com.codewars.yh;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

/**
 * Å×³öNeoÒì³£
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
