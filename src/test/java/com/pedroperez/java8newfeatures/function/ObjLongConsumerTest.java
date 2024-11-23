package com.pedroperez.java8newfeatures.function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.ObjLongConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjLongConsumerTest {

    private StringBuilder result;
    private ObjLongConsumer<StringBuilder> objLongConsumer;

    @BeforeEach
    void setUp() {
        result = new StringBuilder();
        // This consumer appends the long value to the StringBuilder
        objLongConsumer = StringBuilder::append;
    }

    @Test
    void testObjLongConsumer() {
        objLongConsumer.accept(result, 10L);
        assertEquals("10", result.toString());

        objLongConsumer.accept(result, 20L);
        assertEquals("1020", result.toString());
    }
}
