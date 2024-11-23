package com.pedroperez.java8newfeatures.function;
import org.junit.jupiter.api.Test;
import java.util.function.ToLongFunction;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ToLongFunctionTest {

    @Test
    public void testStringToLongFunction() {
        ToLongFunction<String> stringToLong = Long::parseLong;

        // Test case for a positive long number
        long result = stringToLong.applyAsLong("12345");
        assertEquals(12345L, result);

        // Test case for zero
        result = stringToLong.applyAsLong("0");
        assertEquals(0L, result);

        // Test case for a negative long number
        result = stringToLong.applyAsLong("-6789");
        assertEquals(-6789L, result);

        // Test edge case for Long.MAX_VALUE
        result = stringToLong.applyAsLong(Long.toString(Long.MAX_VALUE));
        assertEquals(Long.MAX_VALUE, result);

        // Test edge case for Long.MIN_VALUE
        result = stringToLong.applyAsLong(Long.toString(Long.MIN_VALUE));
        assertEquals(Long.MIN_VALUE, result);
    }

    @Test
    public void testInvalidStringInput() {
        ToLongFunction<String> stringToLong = Long::parseLong;

        // Assertions.assertThrows can be used to check for exceptions
        assertThrows(NumberFormatException.class, () -> {
            stringToLong.applyAsLong("notANumber");
        });
    }
}
