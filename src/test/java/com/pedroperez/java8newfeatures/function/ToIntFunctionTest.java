package com.pedroperez.java8newfeatures.function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.function.ToIntFunction;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToIntFunctionTest {

    private ToIntFunction<String> stringLengthFunction;

    @BeforeEach
    public void setup() {
        // Initialize the ToIntFunction to return the length of the string
        stringLengthFunction = String::length;
    }

    @Test
    public void testStringLengthFunction_withRegularString() {
        int result = stringLengthFunction.applyAsInt("hello");
        assertEquals(5, result, "The length of 'hello' should be 5");
    }

    @Test
    public void testStringLengthFunction_withEmptyString() {
        int result = stringLengthFunction.applyAsInt("");
        assertEquals(0, result, "The length of an empty string should be 0");
    }

    @Test
    public void testStringLengthFunction_withWhitespaceString() {
        int result = stringLengthFunction.applyAsInt(" ");
        assertEquals(1, result, "The length of a whitespace string should be 1");
    }

    @Test
    public void testStringLengthFunction_withSpecialCharacters() {
        int result = stringLengthFunction.applyAsInt("!@#");
        assertEquals(3, result, "The length of '!@#' should be 3");
    }
}

