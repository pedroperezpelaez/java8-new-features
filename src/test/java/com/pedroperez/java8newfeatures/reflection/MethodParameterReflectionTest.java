package com.pedroperez.java8newfeatures.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MethodParameterReflectionTest {

    @Test
    public void testPrintItemsParameters() throws NoSuchMethodException {
        Method method = ReflectionParameterTest.class.getMethod("printItems", List.class);

        // Assert method name and parameter count
        assertEquals("printItems", method.getName());
        Parameter[] parameters = method.getParameters();
        assertEquals(1, parameters.length); // The method should only have one parameter

        // Validate details about the parameter
        Parameter parameter = parameters[0];
        assertEquals("items", parameter.getName());
        assertEquals(List.class, parameter.getType());
        assertTrue(parameter.isNamePresent());
    }
}