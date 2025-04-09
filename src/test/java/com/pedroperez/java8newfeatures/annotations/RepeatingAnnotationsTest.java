package com.pedroperez.java8newfeatures.annotations;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeatingAnnotationsTest {

    @Test
    public void testRepeatingAnnotations() {
        // Step 1: Locate the class annotated with repeating annotations
        Class<RepeatingAnnotations> clazz = RepeatingAnnotations.class;

        // Step 2: Fetch all annotations of type "Tag"
        Tag[] tags = clazz.getAnnotationsByType(Tag.class);

        // Step 3: Verify the correct number of annotations exist
        assertEquals(3, tags.length);

        // Step 4: Verify the annotation values
        assertTrue(Arrays.asList(tags).stream().anyMatch(tag -> tag.value().equals("FeatureA")));
        assertTrue(Arrays.asList(tags).stream().anyMatch(tag -> tag.value().equals("FeatureB")));
        assertTrue(Arrays.asList(tags).stream().anyMatch(tag -> tag.value().equals("FeatureC")));

        // Step 5: Verify presence of the container @Tags annotation
        Annotation container = clazz.getAnnotation(Tags.class);
        assertTrue(container instanceof Tags);
    }
}
