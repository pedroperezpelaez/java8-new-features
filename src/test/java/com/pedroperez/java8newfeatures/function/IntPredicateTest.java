package com.pedroperez.java8newfeatures.function;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.function.IntPredicate;

public class IntPredicateTest {

    @Test
    public void testEvenNumberPredicate() {
        IntPredicate isEven = number -> number % 2 == 0; // Predicate to check even numbers

        assertTrue(isEven.test(4), "4 should be even");
        assertFalse(isEven.test(5), "5 should not be even");
        assertTrue(isEven.test(0), "0 should be even"); // Edge case
        assertTrue(isEven.test(-2), "-2 should be even"); // Negative number
    }

    @Test
    public void testPositiveNumberPredicate() {
        IntPredicate isPositive = number -> number > 0; // Predicate to check positive numbers

        assertTrue(isPositive.test(3), "3 should be positive");
        assertFalse(isPositive.test(-1), "-1 should not be positive");
        assertFalse(isPositive.test(0), "0 should not be positive"); // Edge case
    }
}
