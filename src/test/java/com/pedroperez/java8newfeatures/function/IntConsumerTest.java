package com.pedroperez.java8newfeatures.function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.function.IntConsumer;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntConsumerTest {

    private List<Integer> consumedValues;
    private IntConsumer intConsumer;

    @BeforeEach
    public void setup() {
        consumedValues = new ArrayList<>();
        // Initialize the IntConsumer to add elements to the consumedValues list
        intConsumer = consumedValues::add;
    }

    @Test
    public void testIntConsumerConsumesValues() {
        // Given
        int value1 = 5;
        int value2 = 10;

        // When
        intConsumer.accept(value1);
        intConsumer.accept(value2);

        // Then
        assertEquals(2, consumedValues.size(), "The size of the consumed values list should be 2.");
        assertEquals(value1, consumedValues.get(0), "The first consumed value should be 5.");
        assertEquals(value2, consumedValues.get(1), "The second consumed value should be 10.");
    }
}
