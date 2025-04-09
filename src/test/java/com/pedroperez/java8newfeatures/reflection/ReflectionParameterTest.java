package com.pedroperez.java8newfeatures.reflection;

import java.util.List;

public class ReflectionParameterTest {

    // A generic method with type inference
    public static <T> void printItems(List<T> items) {
        items.forEach(item -> System.out.println("Item: " + item));
    }

}