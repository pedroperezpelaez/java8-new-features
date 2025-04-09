package com.pedroperez.java8newfeatures.typeinference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TypeInferenceTest {

    public static void main(String[] args) {
        // Type inference with Lambda Expressions
        Function<String, Integer> stringLengthLambda = String::length;
        System.out.println("Length of 'TypeInference': " + stringLengthLambda.apply("TypeInference"));

        // Diamond operator in generics (Improved in Java 8)
        List<String> stringList = new ArrayList<>(); // Compiler infers <String>
        Collections.addAll(stringList, "Java", "Type", "Inference", "Test");
        System.out.println("List: " + stringList);

        // Type inference in streams (method references and collectors)
        List<Integer> lengths = stringList.stream()
                .map(String::length) // Infers the map function
                .collect(Collectors.toList()); // Infers Collectors to List<Integer>
        System.out.println("Lengths of each string: " + lengths);

        // Custom generic methods with inferred types
        TypeInferenceTest.<String>printItems(stringList); // Explicit type inference (optional)
        printItems(stringList); // Compiler infers the type automatically

        List<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(101);
        numbers.add(102);
        numbers.add(103);
        System.out.println(numbers);
        // Java 7
        numbers.addAll(Arrays.<Integer>asList(104));
        System.out.println(numbers);
        // Java 8
        numbers.addAll(Arrays.asList(105));
        System.out.println(numbers);
    }

    // A generic method with type inference
    public static <T> void printItems(List<T> items) {
        items.forEach(item -> System.out.println("Item: " + item));
    }
}