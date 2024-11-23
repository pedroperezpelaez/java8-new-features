package com.pedroperez.java8newfeatures.function;
import org.junit.jupiter.api.Test;
import java.util.function.Supplier;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupplierTest {

    @Test
    void testStringSupplier() {
        Supplier<String> stringSupplier = () -> "Hello, World!";
        String result = stringSupplier.get();
        assertEquals("Hello, World!", result, "Supplier should provide 'Hello, World!'");
    }

    @Test
    void testNumberSupplier() {
        Supplier<Integer> numberSupplier = () -> 42;
        Integer result = numberSupplier.get();
        assertEquals(42, result, "Supplier should provide number 42");
    }
}
