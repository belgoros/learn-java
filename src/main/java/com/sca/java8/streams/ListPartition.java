package com.sca.java8.streams;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListPartition {
    public static void main(String[] args) {
        partitionListWithGuava();
        partitionCollectionWithGuava();
        partitionWithJava8();
        groupCollection();
        splitListBySeparator();
    }

    private static void splitListBySeparator() {
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 0, 4, 5, 6, 0, 7, 8);

        int[] indexes =
                Stream.of(IntStream.of(-1), IntStream.range(0, intList.size())
                        .filter(i -> intList.get(i) == 0), IntStream.of(intList.size()))
                        .flatMapToInt(s -> s).toArray();
        List<List<Integer>> subSets =
                IntStream.range(0, indexes.length - 1)
                        .mapToObj(i -> intList.subList(indexes[i] + 1, indexes[i + 1]))
                        .collect(Collectors.toList());

        List<Integer> lastPartition = subSets.get(2);
        List<Integer> expectedLastPartition = Lists.<Integer>newArrayList(7, 8);
        System.out.println("#splitListBySeparator: result: " + (subSets.size() == 3) + ", and equality: " + lastPartition.equals(expectedLastPartition));
    }

    private static void groupCollection() {
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);

        Map<Integer, List<Integer>> groups =
                intList.stream().collect(Collectors.groupingBy(s -> (s - 1) / 3));
        List<List<Integer>> subSets = new ArrayList<List<Integer>>(groups.values());

        List<Integer> lastPartition = subSets.get(2);
        List<Integer> expectedLastPartition = Lists.<Integer>newArrayList(7, 8);
        System.out.println("#groupCollection: result: " + (subSets.size() == 3) + ", and equality: " + lastPartition.equals(expectedLastPartition));
    }

    private static void partitionWithJava8() {
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        Map<Boolean, List<Integer>> groups =
                intList.stream().collect(Collectors.partitioningBy(s -> s > 6));
        List<List<Integer>> subSets = new ArrayList<List<Integer>>(groups.values());

        List<Integer> lastPartition = subSets.get(1);
        List<Integer> expectedLastPartition = Lists.<Integer>newArrayList(7, 8);
        System.out.println("#partitionWithJava8, result: " + (subSets.size() == 2) + ", equality: " + lastPartition.equals(expectedLastPartition));
    }

    private static void partitionCollectionWithGuava() {
        Collection<Integer> intCollection = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        Iterable<List<Integer>> subSets = Iterables.partition(intCollection, 3);
        List<Integer> firstPartition = subSets.iterator().next();
        List<Integer> expectedLastPartition = Lists.<Integer>newArrayList(1, 2, 3);
        System.out.println("#partitionCollectionWithGuava => collection partitioned: " + (firstPartition.equals(expectedLastPartition)));
    }

    private static void partitionListWithGuava() {
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> subSets = Lists.partition(intList, 3);

        List<Integer> lastPartition = subSets.get(2);
        List<Integer> expectedLastPartition = Lists.newArrayList(7, 8);
        System.out.println("#partitionListWithGuava => subset size: " + subSets.size() + ", equality: " + (lastPartition.size() == expectedLastPartition.size()));
    }
}
