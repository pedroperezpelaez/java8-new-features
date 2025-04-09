package com.pedroperez.java8newfeatures.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StreamApiTest {

    @Test
    public void testStreamCreation() {
        // Stream.of()
        Stream<String> stream = Stream.of("Java", "Python", "C++");
        List<String> result = stream.collect(Collectors.toList());
        assertEquals(Arrays.asList("Java", "Python", "C++"), result);

        // Stream.empty()
        Stream<String> emptyStream = Stream.empty();
        assertEquals(0, emptyStream.count());

        // Stream.generate()
        Stream<Integer> generatedStream = Stream.generate(() -> 1).limit(5);
        List<Integer> generatedList = generatedStream.collect(Collectors.toList());
        assertEquals(Arrays.asList(1, 1, 1, 1, 1), generatedList);

        // Stream.iterate()
        Stream<Integer> iteratedStream = Stream.iterate(1, n -> n + 1).limit(5);
        List<Integer> iteratedList = iteratedStream.collect(Collectors.toList());
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), iteratedList);
    }

    @Test
    public void testIntermediateOperations() {
        List<String> data = Arrays.asList("Java", "C++", "Python", "Java", "Go");

        // filter()
        List<String> filtered = data.stream()
                .filter(s -> s.startsWith("J"))
                .collect(Collectors.toList());
        assertEquals(Arrays.asList("Java", "Java"), filtered);

        // map()
        List<Integer> lengths = data.stream()
                .map(String::length)
                .collect(Collectors.toList());
        assertEquals(Arrays.asList(4, 3, 6, 4, 2), lengths);

        // flatMap()
        List<String> flatMapped = Stream.of(Arrays.asList("Java", "C++"), Arrays.asList("Python", "Go"))
                .flatMap(List::stream)
                .collect(Collectors.toList());
        assertEquals(Arrays.asList("Java", "C++", "Python", "Go"), flatMapped);

        // distinct()
        List<String> distinct = data.stream()
                .distinct()
                .collect(Collectors.toList());
        assertEquals(Arrays.asList("Java", "C++", "Python", "Go"), distinct);

        // sorted()
        List<String> sorted = data.stream()
                .sorted()
                .collect(Collectors.toList());
        assertEquals(Arrays.asList("C++", "Go", "Java", "Java", "Python"), sorted);

        // peek()
        List<String> peeked = data.stream()
                .peek(System.out::println) // Does not change the list, but logs each item
                .collect(Collectors.toList());
        assertEquals(data, peeked);

        // limit() and skip()
        List<String> limited = data.stream()
                .limit(3)
                .collect(Collectors.toList());
        assertEquals(Arrays.asList("Java", "C++", "Python"), limited);

        List<String> skipped = data.stream()
                .skip(2)
                .collect(Collectors.toList());
        assertEquals(Arrays.asList("Python", "Java", "Go"), skipped);
    }

    @Test
    public void testTerminalOperations() {
        List<String> data = Arrays.asList("Java", "C++", "Python", "Java", "Go");

        // forEach()
        StringBuilder sb = new StringBuilder();
        data.stream().forEach(sb::append);
        assertEquals("JavaC++PythonJavaGo", sb.toString());

        // toArray()
        Object[] array = data.stream().toArray();
        assertArrayEquals(new String[]{"Java", "C++", "Python", "Java", "Go"}, array);

        // reduce()
        String concatenated = data.stream()
                .reduce("", (a, b) -> a + b);
        assertEquals("JavaC++PythonJavaGo", concatenated);

        // collect()
        Set<String> set = data.stream()
                .collect(Collectors.toSet());
        assertEquals(new HashSet<>(data), set);

        // min() and max()
        String min = data.stream().min(String::compareTo).orElse(null);
        String max = data.stream().max(String::compareTo).orElse(null);
        assertEquals("C++", min);
        assertEquals("Python", max);

        // count()
        long count = data.stream().count();
        assertEquals(5, count);

        // anyMatch(), allMatch(), noneMatch()
        assertTrue(data.stream().anyMatch(s -> s.startsWith("J")));
        assertFalse(data.stream().allMatch(s -> s.startsWith("J")));
        assertTrue(data.stream().noneMatch(s -> s.startsWith("Z")));

        // findFirst() and findAny()
        String first = data.stream().findFirst().orElse(null);
        assertEquals("Java", first);

        String any = data.stream().findAny().orElse(null);
        assertTrue(data.contains(any));
    }

    @Test
    public void testParallelism() {
        List<Integer> numbers = IntStream.rangeClosed(1, 1_000_000)
                .boxed()
                .collect(Collectors.toList());

        // Sequential sum
        long sequentialSum = numbers.stream()
                .mapToLong(Integer::longValue)
                .sum();

        // Parallel sum
        long parallelSum = numbers.parallelStream()
                .mapToLong(Integer::longValue)
                .sum();

        assertEquals(sequentialSum, parallelSum);
    }
}