package com.pedroperez.java8newfeatures.function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EvenNumberPredicateTest {

    Predicate<Integer> evenPredicate;


    @BeforeEach
    public void setup() {
        evenPredicate = num -> num % 2 == 0;
    }

    @Test
    public void testEvenNumber() {
        assertTrue(evenPredicate.test(2), "2 should be even");
        assertTrue(evenPredicate.test(100), "100 should be even");
    }

    @Test
    public void testOddNumber() {
        assertFalse(evenPredicate.test(3), "3 should be odd");
        assertFalse(evenPredicate.test(101), "101 should be odd");
    }

    @Test
    public void testZero() {
        assertTrue(evenPredicate.test(0), "0 should be even");
    }

    @Test
    public void testNegativeEvenNumber() {
        assertTrue(evenPredicate.test(-4), "-4 should be even");
    }

    @Test
    public void testNegativeOddNumber() {
        assertFalse(evenPredicate.test(-3), "-3 should be odd");
    }
}
