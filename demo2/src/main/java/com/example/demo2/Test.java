package com.example.demo2;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {
        genericPrint(1);
        genericPrint("asdasd");
        genericPrint(BigDecimal.TEN);
    }

    private static  <T> void genericPrint(T input) {
        System.out.println(input);

    }

    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;   // assume x is initially the largest

        if(y.compareTo(max) > 0) {
            max = y;   // y is the largest so far
        }

        if(z.compareTo(max) > 0) {
            max = z;   // z is the largest now
        }
        return max;   // returns the largest object
    }
}


