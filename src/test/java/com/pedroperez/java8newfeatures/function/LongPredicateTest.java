package com.pedroperez.java8newfeatures.function;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.function.LongPredicate;

public class LongPredicateTest {

    @Test
    public void testIsEven() {
        LongPredicate isEven = value -> value % 2 == 0;

        assertTrue(isEven.test(4L), "4 should be even");
        assertFalse(isEven.test(5L), "5 should not be even");
    }

    @Test
    public void testIsPositive() {
        LongPredicate isPositive = value -> value > 0;

        assertTrue(isPositive.test(10L), "10 should be positive");
        assertFalse(isPositive.test(-1L), "-1 should not be positive");
        assertFalse(isPositive.test(0L), "0 should not be positive");
    }

    @Test
    public void testCombinedPredicates() {
        LongPredicate isEven = value -> value % 2 == 0;
        LongPredicate isPositive = value -> value > 0;
        LongPredicate isEvenAndPositive = isEven.and(isPositive);

        assertTrue(isEvenAndPositive.test(2L), "2 should be even and positive");
        assertFalse(isEvenAndPositive.test(-2L), "-2 should not be even and positive");
        assertFalse(isEvenAndPositive.test(1L), "1 should not be even and positive");
    }
}
