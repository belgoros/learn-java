package com.regex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FilterListWithRegexTest {

    @Test
    public void shouldFilterListUsingStringMatches() {
        List<String> filteredNumbers = filterUsingStringMatches();
        Assertions.assertThat(filteredNumbers).containsExactly("123", "789");
    }

    @Test
    public void shouldFilterListUsingPatternAndPredicate() {
        List<String> filteredFruits = filterUsingPatternAndPredicate();
        Assertions.assertThat(filteredFruits).containsExactly("apple", "apricot", "avocado");
    }

    @Test
    public void shouldFilterListUsingCollectorsPartitioningBy() {
        Map<Boolean, List<String>> partitionedFruits = filterUsingCollectorsPartitioningBy();
        Assertions.assertThat(partitionedFruits.get(true)).containsExactly("apple", "apricot");
        Assertions.assertThat(partitionedFruits.get(false)).containsExactly("banana", "berry");
    }


    List<String> filterUsingStringMatches() {
        List<String> list = List.of("123", "abc", "456def", "789", "xyz");

        return list.stream()
                .filter(str -> str.matches("\\d+")).toList();
    }

    List<String> filterUsingPatternAndPredicate() {
        List<String> fruits = List.of("apple", "banana", "cherry", "apricot", "avocado");

        Pattern pattern = Pattern.compile("^a.*");

        return fruits.stream().filter(pattern.asPredicate()).toList();
    }

    Map<Boolean, List<String>> filterUsingCollectorsPartitioningBy() {
        List<String> fruits = List.of("apple", "banana", "apricot", "berry");

        Pattern pattern = Pattern.compile("^a.*");

        return fruits.stream()
                .collect(Collectors.partitioningBy(pattern.asPredicate()));
    }
}
