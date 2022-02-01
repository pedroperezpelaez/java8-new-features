package com.pedroperez.java8newfeatures.methodreferences;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReferenceStaticMethodTest {

    @Test
    public void testReferenceStaticMethod() {
        final List<String> list = Arrays.asList("3", "4", "text");

        //before java8
        boolean anyNumber = list.stream().anyMatch(text -> ReferenceStaticMethod.isValidNumber(text));
        //after java8
        anyNumber = list.stream().anyMatch(ReferenceStaticMethod::isValidNumber);
        assertThat(anyNumber).isEqualTo(true);
        final boolean allNumbers = list.stream().allMatch(ReferenceStaticMethod::isValidNumber);
        assertThat(allNumbers).isEqualTo(false);
    }
}

