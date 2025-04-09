package com.pedroperez.java8newfeatures.annotations;

import java.io.IOException;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A class demonstrating various placements of @TypeCustom.
 * This class itself isn't tested directly, but its members are inspected
 * via reflection in the corresponding JUnit test class.
 */
public class TypeCustomAnnotationDemo {

    // 1. Field declaration
    private @TypeCustom String annotatedField = "hello";

    // 2. Generic type argument (List<String>)
    private List<@TypeCustom String> annotatedList = new ArrayList<>();

    // 3. Nested Generic type arguments (Map<String, List<Integer>>)
    private Map<@TypeCustom String, List<@TypeCustom Integer>> complexMap;

    // 4. Array element type
    private @TypeCustom String[] annotatedArray;

    // 5. Type parameter bound
    static class GenericProcessor<T extends @TypeCustom Number> {
        T process(T input) {
            return input;
        }
    }

    // 6. Constructor parameter
    public TypeCustomAnnotationDemo(@TypeCustom String constructorParam) {
        this.annotatedField = constructorParam;
    }

    // 7. Method return type
    public @TypeCustom String getAnnotatedValue() {
        return annotatedField;
    }

    // 8. Method parameter
    public void processValue(@TypeCustom String value) {
        System.out.println("Processing: " + value);
    }

    // 9. Throws clause
    public void potentiallyThrow() throws @TypeCustom IOException {
        if (System.currentTimeMillis() % 2 == 0) { // Simulate conditional throw
            throw new IOException("Simulated IO error");
        }
    }

    // 10. Receiver parameter (less common, 'this' type)
    public void processReceiver(@TypeCustom TypeCustomAnnotationDemo this) {
        System.out.println("Processing this instance: " + this.annotatedField);
    }

    // 11. Type cast (Demonstrated within a method body - harder to test via reflection on class structure)
    public void typeCastExample(Object obj) {
        if (obj instanceof String) {
            String s = (@TypeCustom String) obj; // Annotation on cast
            System.out.println("Casted string: " + s);
        }
    }

    // 12. Constructor invocation (new) (Harder to test via reflection on class structure)
    public MyDataStructure<String> createInstance() {
        return new @TypeCustom MyDataStructure<String>("data"); // Annotation on 'new'
    }

    // 13. Wildcard bounds
    public void processWildcardList(List<? extends @TypeCustom Number> numbers) {
        for (Number n : numbers) {
            System.out.println("Number: " + n);
        }
    }

    // Method to access the annotated field reflectively for testing
    public AnnotatedType getAnnotatedFieldType() throws NoSuchFieldException {
        Field field = TypeCustomAnnotationDemo.class.getDeclaredField("annotatedField");
        return field.getAnnotatedType();
    }

    // Method to access the annotated list type reflectively for testing
    public AnnotatedType getAnnotatedListFieldType() throws NoSuchFieldException {
        Field field = TypeCustomAnnotationDemo.class.getDeclaredField("annotatedList");
        return field.getAnnotatedType();
    }

    // Method to access the annotated array type reflectively for testing
    public AnnotatedType getAnnotatedArrayFieldType() throws NoSuchFieldException {
        Field field = TypeCustomAnnotationDemo.class.getDeclaredField("annotatedArray");
        return field.getAnnotatedType();
    }

    // Method to access the annotated method return type reflectively for testing
    public AnnotatedType getAnnotatedMethodReturnType() throws NoSuchMethodException {
        Method method = TypeCustomAnnotationDemo.class.getDeclaredMethod("getAnnotatedValue");
        return method.getAnnotatedReturnType();
    }

    // Method to access annotated parameter types reflectively for testing
    public AnnotatedType[] getAnnotatedMethodParameterTypes() throws NoSuchMethodException {
        Method method = TypeCustomAnnotationDemo.class.getDeclaredMethod("processValue", String.class);
        return method.getAnnotatedParameterTypes();
    }

    // Method to access annotated exception types reflectively for testing
    public AnnotatedType[] getAnnotatedExceptionTypes() throws NoSuchMethodException {
        Method method = TypeCustomAnnotationDemo.class.getDeclaredMethod("potentiallyThrow");
        return method.getAnnotatedExceptionTypes();
    }

    // Method to access annotated receiver type reflectively for testing
    public AnnotatedType getAnnotatedReceiverType() throws NoSuchMethodException {
        Method method = TypeCustomAnnotationDemo.class.getDeclaredMethod("processReceiver");
        // Note: Reflection support for receiver parameters can be limited depending on JDK version and context.
        // This might return null if the compiler didn't store the info or reflection API doesn't expose it easily here.
        // A more robust way might involve specific bytecode analysis tools.
        // Let's proceed assuming it might work.
        return method.getAnnotatedReceiverType(); // May return null
    }

    // Method to access annotated constructor parameter types reflectively for testing
    public AnnotatedType[] getAnnotatedConstructorParameterTypes() throws NoSuchMethodException {
        // Use getDeclaredConstructor instead of getDeclaredMethod
        java.lang.reflect.Constructor<?> constructor = TypeCustomAnnotationDemo.class.getDeclaredConstructor(String.class);
        return constructor.getAnnotatedParameterTypes();
    }
}
