package com.pedroperez.java8newfeatures.function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.ToIntBiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ToIntBiFunctionTest {

    private ToIntBiFunction<String, String> addStringsAsInts;

    @BeforeEach
    public void setup() {
        addStringsAsInts = (s1, s2) -> Integer.parseInt(s1) + Integer.parseInt(s2);
    }

    @Test
    public void whenValidStrings_thenCorrectSum() {
        int result = addStringsAsInts.applyAsInt("3", "5");
        assertEquals(8, result);
    }

    @Test
    public void whenZeroStrings_thenZeroSum() {
        int result = addStringsAsInts.applyAsInt("0", "0");
        assertEquals(0, result);
    }

    @Test
    public void whenNegativeStrings_thenCorrectSum() {
        int result = addStringsAsInts.applyAsInt("-2", "-3");
        assertEquals(-5, result);
    }

    @Test
    public void whenMixedSignStrings_thenCorrectSum() {
        int result = addStringsAsInts.applyAsInt("-2", "3");
        assertEquals(1, result);
    }

    @Test
    public void whenEmptyStrings_thenNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> {
            addStringsAsInts.applyAsInt("", "5");
        });
    }

    @Test
    public void whenNonNumericStrings_thenNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> {
            addStringsAsInts.applyAsInt("a", "b");
        });
    }
}
