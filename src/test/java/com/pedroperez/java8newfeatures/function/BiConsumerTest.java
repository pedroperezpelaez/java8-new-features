package com.pedroperez.java8newfeatures.function;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
 
public class BiConsumerTest {
    // Test BiConsumer: Add two integers to a list
    @Test
    public void testBiConsumerAddToList() {
        List<Integer> numbers = new ArrayList<>();
        BiConsumer<Integer, Integer> addToList = (a, b) -> {
            numbers.add(a);
            numbers.add(b);
        };

        // Apply BiConsumer to add 10 and 20 to the list
        addToList.accept(10, 20);

        assertEquals(Arrays.asList(10, 20), numbers);
    }

    // Test BiConsumer: Concatenate and print two strings
    @Test
    public void testBiConsumerConcatenateStrings() {
        StringBuilder result = new StringBuilder();
        BiConsumer<String, String> concatenate = (s1, s2) -> result.append(s1).append(" ").append(s2);

        // Apply BiConsumer to concatenate two strings
        concatenate.accept("Hello", "World");

        assertEquals("Hello World", result.toString());
    }

    // Test BiConsumer: Update a map with key-value pairs
    @Test
    public void testBiConsumerUpdateMap() {
        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> addToMap = map::put;

        // Add two key-value pairs to the map
        addToMap.accept("Apple", 10);
        addToMap.accept("Banana", 20);

        assertEquals(10, (int) map.get("Apple"));
        assertEquals(20, (int) map.get("Banana"));
    }
}
