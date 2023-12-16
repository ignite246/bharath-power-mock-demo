package com.rahul.learning.powermock.java2blog;

public class MultipleTypesOfMethodService {
    private String privateMethod() {
        return "Private Message";
    }

    public static String staticMethod() {
        return "Static Message";
    }

    public final String finalMethod() {
        return "Final Message";
    }
}
