package com.pedroperez.java8newfeatures.methodreferences;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReferenceToConstructorTest {
    @Test
    public void testReferenceConstructor() {
        final List<String> list = Arrays.asList("3", "4", "text");
        final Stream<ReferenceToConstructor> stream = list.stream().map(ReferenceToConstructor::new);
        assertThat(stream.findFirst().get().getName()).isEqualTo("3");
    }
}
