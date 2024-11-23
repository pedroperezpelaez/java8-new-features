package com.pedroperez.java8newfeatures.function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.function.ObjIntConsumer;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjIntConsumerTest {

    private ObjIntConsumer<List<String>> addElementAtIndex;

    @BeforeEach
    public void setup() {
        // Initialize the ObjIntConsumer to add an element at a specific index in a list
        addElementAtIndex = (list, index) -> list.add(index, "test-element");
    }

    @Test
    public void testObjIntConsumer_AddElement() {
        List<String> list = new ArrayList<>();
        list.add("initial-element");

        // Use the ObjIntConsumer to add an element at index 1
        addElementAtIndex.accept(list, 1);

        // Assert the list size and contents
        assertEquals(2, list.size());
        assertEquals("initial-element", list.get(0));
        assertEquals("test-element", list.get(1));
    }

    @Test
    public void testObjIntConsumer_AddElementAtZero() {
        List<String> list = new ArrayList<>();

        // Use the ObjIntConsumer to add an element at index 0
        addElementAtIndex.accept(list, 0);

        // Assert the list size and contents
        assertEquals(1, list.size());
        assertEquals("test-element", list.get(0));
    }
}
