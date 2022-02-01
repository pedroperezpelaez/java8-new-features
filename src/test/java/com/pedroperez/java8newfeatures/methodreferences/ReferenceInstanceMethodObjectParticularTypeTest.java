package com.pedroperez.java8newfeatures.methodreferences;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReferenceInstanceMethodObjectParticularTypeTest {
    @Test
    public void testReferenceInstanceMethodObjectParticularType() {
        final List<String> list = Arrays.asList("3", "4", "text", "");
        final ReferenceInstanceMethodObjectParticularType referenceInstanceMethodObjectParticularType =
                new ReferenceInstanceMethodObjectParticularType();

        assertThat(referenceInstanceMethodObjectParticularType.filterNotEmptyStrings(list).size()).isEqualTo(1);
    }
}
