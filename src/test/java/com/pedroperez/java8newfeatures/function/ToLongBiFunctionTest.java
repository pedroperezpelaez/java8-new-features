package com.pedroperez.java8newfeatures.function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.function.ToLongBiFunction;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToLongBiFunctionTest {

    private ToLongBiFunction<String, String> lengthMultiplier;

    @BeforeEach
    public void setup() {
        // This ToLongBiFunction takes two strings and returns the product of their lengths
        lengthMultiplier = (String a, String b) -> (long) a.length() * b.length();
    }

    @Test
    public void testLengthMultiplier() {
        // Test the function with two strings of specific lengths
        long result = lengthMultiplier.applyAsLong("Hello", "World");
        assertEquals(25, result, "Expected: 25"); // "Hello".length() * "World".length() == 5 * 5

        // Test the function with empty strings
        result = lengthMultiplier.applyAsLong("", "World");
        assertEquals(0, result, "Expected: 0"); // "".length() * "World".length() == 0 * 5

        // Test the function with both inputs as empty strings
        result = lengthMultiplier.applyAsLong("", "");
        assertEquals(0, result, "Expected: 0"); // "".length() * "".length() == 0 * 0

        // Test with one string longer than the other
        result = lengthMultiplier.applyAsLong("Java", "Programming");
        assertEquals(44, result, "Expected: 44"); // "Java".length() * "Programming".length() == 4 * 11
    }
}
