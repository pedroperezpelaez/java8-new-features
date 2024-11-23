package com.pedroperez.java8newfeatures.function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.LongConsumer;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongConsumerTest {

    private AtomicLong consumerResult;
    private LongConsumer longConsumer;

    @BeforeEach
    public void setUp() {
        consumerResult = new AtomicLong();
        longConsumer = consumerResult::set;
    }

    @Test
    public void testLongConsumer() {
        long testValue = 123L;
        longConsumer.accept(testValue);

        assertEquals(testValue, consumerResult.get(), "The consumer result should match the input value");
    }

    @Test
    public void testLongConsumerWithZero() {
        longConsumer.accept(0L);

        assertEquals(0L, consumerResult.get(), "The consumer result should match the input value 0");
    }

    @Test
    public void testLongConsumerWithNegativeValue() {
        long testValue = -456L;
        longConsumer.accept(testValue);

        assertEquals(testValue, consumerResult.get(), "The consumer result should match the negative input value");
    }
}

