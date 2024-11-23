package com.pedroperez.java8newfeatures.function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.DoublePredicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoublePredicateTest {

    private DoublePredicate isPositivePredicate;
    private DoublePredicate isEvenPredicate;

    @BeforeEach
    public void setup() {
        isPositivePredicate = (value) -> value > 0;
        isEvenPredicate = (value) -> value % 2 == 0;
    }

    @Test
    public void testIsPositivePredicate() {
        assertTrue(isPositivePredicate.test(5.0)); // Positive case
        assertFalse(isPositivePredicate.test(-1.0)); // Negative case
        assertFalse(isPositivePredicate.test(0.0)); // Zero case
    }

    @Test
    public void testIsEvenPredicate() {
        assertTrue(isEvenPredicate.test(4.0)); // Even number
        assertFalse(isEvenPredicate.test(3.0)); // Odd number
        assertTrue(isEvenPredicate.test(0.0)); // Zero is considered even
    }

    @Test
    public void testCombinedPredicates() {
        DoublePredicate isPositiveAndEven = isPositivePredicate.and(isEvenPredicate);

        assertTrue(isPositiveAndEven.test(4.0)); // Positive and even
        assertFalse(isPositiveAndEven.test(-4.0)); // Negative and even
        assertFalse(isPositiveAndEven.test(5.0)); // Positive but odd
        assertFalse(isPositiveAndEven.test(0.0)); // Zero
    }
}

