package com.pedroperez.java8newfeatures.function;

import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BiPredicateTest {
    // Test BiPredicate: Check if two integers are equal
    @Test
    public void testBiPredicateEquals() {
        BiPredicate<Integer, Integer> isEqual = Integer::equals;

        // Apply BiPredicate to check if two numbers are equal
        assertTrue(isEqual.test(10, 10));
        assertFalse(isEqual.test(10, 20));
    }

    // Test BiPredicate: Check if one string contains another
    @Test
    public void testBiPredicateContains() {
        BiPredicate<String, String> contains = String::contains;

        // Apply BiPredicate to check if one string contains another
        assertTrue(contains.test("Hello World", "World"));
        assertFalse(contains.test("Hello World", "Java"));
    }

    // Test BiPredicate: Check if the sum of two numbers is greater than a threshold
    @Test
    public void testBiPredicateSumGreaterThanThreshold() {
        int threshold = 15;
        BiPredicate<Integer, Integer> sumGreaterThan = (a, b) -> (a + b) > threshold;

        // Apply BiPredicate to check if the sum of two numbers is greater than 15
        assertTrue(sumGreaterThan.test(10, 10));  // 10 + 10 > 15
        assertFalse(sumGreaterThan.test(5, 5));   // 5 + 5 <= 15
    }

    // Test BiPredicate: Check if the length of the first string is greater than the second
    @Test
    public void testBiPredicateLengthGreater() {
        BiPredicate<String, String> lengthGreaterThan = (s1, s2) -> s1.length() > s2.length();

        // Apply BiPredicate to check if the length of the first string is greater than the second
        assertTrue(lengthGreaterThan.test("Lambda", "Java"));
        assertFalse(lengthGreaterThan.test("Java", "Stream"));
    }
}
