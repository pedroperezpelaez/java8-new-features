package com.pedroperez.java8newfeatures.methodreferences;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReferenceInstanceMethodTest {

    @Test
    public void testReferenceInstanceMethod() {
        final ReferenceInstanceMethod referenceInstanceMethod = new ReferenceInstanceMethod();
        final List<String> list = Arrays.asList("3", "4", "text");

        //before java8
        final boolean anyNumber = list.stream().anyMatch(text -> referenceInstanceMethod.isValidNumber(text));
        assertThat(anyNumber).isEqualTo(true);
        //after java8
        final long numberCount = list.stream().filter(referenceInstanceMethod::isValidNumber).count();
        assertThat(numberCount).isEqualTo(2);

    }
}

