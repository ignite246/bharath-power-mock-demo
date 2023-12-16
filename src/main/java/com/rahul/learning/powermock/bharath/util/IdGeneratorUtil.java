package com.rahul.learning.powermock.bharath.util;

/*
Utility to generate unique Id
Making it final so that no one can extend and override generateId method
 */
public final class  IdGeneratorUtil {
    private static int i;
    public static int generateId(){
        return ++i;
    }
}
