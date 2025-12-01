package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Map.Entry;
import java.util.Arrays;

public class Task04Main {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8)
        );

        String text = reader.lines()
                .collect(Collectors.joining(" "));

        String[] words = text.toLowerCase(Locale.ROOT)
                .split("[^A-Za-zА-Яа-яЁё0-9]+");

        Map<String, Long> freq = Arrays.stream(words)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        List<String> topWords = freq.entrySet().stream()
                .sorted(
                        Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                                .thenComparing(Entry.comparingByKey())
                )
                .limit(10)
                .map(Entry::getKey)
                .collect(Collectors.toList());

        System.out.print(String.join("\n", topWords));
    }
}