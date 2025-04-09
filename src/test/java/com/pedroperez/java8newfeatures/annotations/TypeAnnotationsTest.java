package com.pedroperez.java8newfeatures.annotations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.AnnotatedArrayType;
import java.lang.reflect.AnnotatedParameterizedType;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Java 8 Type Annotations Feature Tests")
public class TypeAnnotationsTest {

    private TypeCustomAnnotationDemo demoInstance;

    @BeforeEach
    void setUp() {
        // Create an instance - needed mainly if we were testing instance behavior,
        // but good practice. Reflection mostly works on the Class object anyway.
        demoInstance = new TypeCustomAnnotationDemo("test");
    }

    @Test
    @DisplayName("Annotation should be present on Field Type")
    void testFieldAnnotation() throws NoSuchFieldException {
        Field field = TypeCustomAnnotationDemo.class.getDeclaredField("annotatedField");
        AnnotatedType annotatedType = field.getAnnotatedType();

        assertNotNull(annotatedType, "AnnotatedType should not be null");
        assertTrue(annotatedType.isAnnotationPresent(TypeCustom.class), "@TypeCustom should be present on field type");
        assertEquals(String.class, annotatedType.getType(), "Underlying type should be String");
    }

    @Test
    @DisplayName("Annotation should be present on Generic Type Argument")
    void testGenericTypeArgumentAnnotation() throws NoSuchFieldException {
        Field field = TypeCustomAnnotationDemo.class.getDeclaredField("annotatedList");
        AnnotatedType annotatedType = field.getAnnotatedType(); // This is AnnotatedParameterizedType

        assertTrue(annotatedType instanceof AnnotatedParameterizedType, "Field type should be an AnnotatedParameterizedType");
        AnnotatedParameterizedType parameterizedType = (AnnotatedParameterizedType) annotatedType;

        AnnotatedType[] typeArguments = parameterizedType.getAnnotatedActualTypeArguments();
        assertEquals(1, typeArguments.length, "Should have one type argument");
        assertTrue(typeArguments[0].isAnnotationPresent(TypeCustom.class), "@TypeCustom should be present on the List's type argument");
        assertEquals(String.class, typeArguments[0].getType(), "Type argument should be String");
    }

    @Test
    @DisplayName("Annotation should be present on Nested Generic Type Arguments")
    void testNestedGenericTypeArgumentAnnotation() throws NoSuchFieldException {
        Field field = TypeCustomAnnotationDemo.class.getDeclaredField("complexMap");
        AnnotatedType annotatedType = field.getAnnotatedType(); // This is AnnotatedParameterizedType for Map

        assertInstanceOf(AnnotatedParameterizedType.class, annotatedType, "Field type should be an AnnotatedParameterizedType");
        AnnotatedParameterizedType mapType = (AnnotatedParameterizedType) annotatedType;

        AnnotatedType[] mapTypeArguments = mapType.getAnnotatedActualTypeArguments();
        assertEquals(2, mapTypeArguments.length, "Map should have two type arguments");

        // Check Key (String)
        assertTrue(mapTypeArguments[0].isAnnotationPresent(TypeCustom.class), "@TypeCustom should be present on the Map's key type argument");
        assertEquals(String.class, mapTypeArguments[0].getType(), "Map key type argument should be String");

        // Check Value (List<@TypeCustom Integer>)
        AnnotatedType valueType = mapTypeArguments[1];
        assertInstanceOf(AnnotatedParameterizedType.class, valueType, "Map value type should be AnnotatedParameterizedType for List");
        AnnotatedParameterizedType listType = (AnnotatedParameterizedType) valueType;
        AnnotatedType[] listTypeArguments = listType.getAnnotatedActualTypeArguments();
        assertEquals(1, listTypeArguments.length, "List value should have one type argument");
        assertTrue(listTypeArguments[0].isAnnotationPresent(TypeCustom.class), "@TypeCustom should be present on the List's type argument within the map value");
        assertEquals(Integer.class, listTypeArguments[0].getType(), "List type argument should be Integer");
    }

    @Test
    @DisplayName("Annotation should be present on Array Element Type")
    void testArrayElementAnnotation() throws NoSuchFieldException {
        Field field = TypeCustomAnnotationDemo.class.getDeclaredField("annotatedArray");
        AnnotatedType annotatedType = field.getAnnotatedType(); // This is AnnotatedArrayType

        assertInstanceOf(AnnotatedArrayType.class, annotatedType, "Field type should be an AnnotatedArrayType");
        AnnotatedArrayType arrayType = (AnnotatedArrayType) annotatedType;

        AnnotatedType componentType = arrayType.getAnnotatedGenericComponentType();
        assertTrue(componentType.isAnnotationPresent(TypeCustom.class));
    }
}
