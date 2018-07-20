package com.sca.java8.streams;

import com.sca.basic.Developer;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterCollection {

    public static void main(final String[] args) {

        FilterCollection runner = new FilterCollection();
        List<Developer> developers = runner.createDevelopersList();

        // selecting the developers according to the method condition
        Stream<Developer> filterStream = developers.stream().filter(developer -> respondToNameCriteria(developer.getLastName(), "Du"));

        // Collect the found developers into the list
        List<Developer> filteredList = filterStream.collect(Collectors.toList());

        System.out.println("Selected developers:" + "\n");
        for (Developer developer : filteredList) {
            System.out.println(developer.getLastName());
        }

        // selecting the developers according to the method condition
        Developer first = developers.stream()
                .filter(developer -> developer.getLastName().equalsIgnoreCase("Cambier")).findFirst().orElse(null);
        System.out.println("First found Developer: " + first.getLastName());

        if (runner.foundSameFirstName(developers) || runner.foundSameLastName(developers)) {
            System.out.println("Found duplicates developers");
        }

        runner.selectByRange(Arrays.asList(5, 3, 4, 20, 100));
        runner.createMapFromSet();

        runner.removeDuplicateValues();
    }

    private void flattenListOfLists() {
        List<List<Developer>> partials = new ArrayList<>();
        partials.add(createDevelopersList());
        partials.add(createDevelopersList());
        System.out.println(partials.size());
        List<Developer> flattened = partials.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("flattened size: " + flattened.size()); //=> 12
    }

    private static boolean respondToNameCriteria(final String lastName, final String criteria) {
        return lastName.startsWith(criteria);
    }

    private boolean foundSameLastName(final List<Developer> developers) {
        Set<String> unicums = new HashSet<>();
        return developers.removeIf(developer -> !unicums.add(developer.getLastName()));
    }

    private boolean foundSameFirstName(final List<Developer> developers) {
        Set<String> unicums = new HashSet<>();
        return developers.removeIf(developer -> !unicums.add(developer.getFirstName()));
    }

    private List<Developer> createDevelopersList() {
        List<Developer> list = new ArrayList<>();
        list.add(createDeveloper("Jean", "Dupont"));
        list.add(createDeveloper("Martin", "Durand"));
        list.add(createDeveloper("Olivier", "Cambier"));
        list.add(createDeveloper("Jerome", "Cambier"));
        list.add(createDeveloper("Hélène", "Dubois"));
        list.add(createDeveloper("Jacques", "Heureux"));

        return list;
    }

    private Developer createDeveloper(final String firstName, final String lastName) {
        Developer developer = new Developer();
        developer.setFirstName(firstName);
        developer.setLastName(lastName);

        return developer;
    }

    private void selectByRange(List<Integer> range) {
        System.out.println("Select list values by range:");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 20, 23, 101);
        Stream<Integer> filterStream = numbers.stream().filter((Integer number) -> range.contains(number));
        // could be shorter
        //Stream<Integer> filterStream = numbers.stream().filter(range::contains);
        List<Integer> collected = filterStream.collect(Collectors.toList());
        System.out.println(collected.toString());

    }

    private void buildUniqueList() {
        Integer[] items = {1, 2, 2, 3, 4, 4, 4, 5, 7, 56, 3, 98, 34, 3};
        List<Integer> listWithUniqueValues = Arrays.asList(items).stream().distinct().collect(Collectors.toList());

        System.out.println("Unique values list: " + listWithUniqueValues.toString());
    }

    /**
     * Get the unique surnames in uppercase of the first 15 book authors that are 50 years old or older
     */
    private void uniqueSurnames() {
        /*
        library.stream()
          .map(Book::getAuthor)
          .filter(author -> author.getGender() == Gender.FEMALE)
          .map(Author::getAge)
          .filter(age -> age < 25)
          .reduce(0, Integer::sum)
         */

    }

    /**
     * Find, if all elements of a collection that matches the specified condition
     */
    private void matchWithPredicate() {
        // Declare and Initialize the Collection
        Set<Integer> intSet = new HashSet<Integer>();
        // Add Elements
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);
        // Specify the Predicate or the Condition using Lambda expressions

        Predicate<Integer> moreThan2Pred = (p) -> (p > 2);

        // Use the stream method allMatch to see if all elements fulfils the Predicate.
        System.out.println(intSet.stream().allMatch(moreThan2Pred)); // Prints False.
    }

    /**
     * Find, if any element of the collection matches the specified condition
     */

    private void findWithPredicate() {
        // Declare and Initialize the Collection
        Set<Integer> intSet = new HashSet<Integer>();

        // Add Elements
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);

        // Specify the Predicate or the Condition using Lambda expressions
        Predicate<Integer> moreThan2Pred = (p) -> (p > 2);

        // Use the stream method anyMatch to see if all elements fulfils the Predicate.

        System.out.println(intSet.stream().anyMatch(moreThan2Pred)); // Prints True.
    }

    /**
     * Find, if no element of the collection matches the specified condition ( Inverse of anyMatch )
     */

    private void findNoElementsMatch() {
        // Declare and Initialize the Collection
        Set<Integer> intSet = new HashSet<Integer>();

        // Add Elements
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);

        // Specify the Predicate or the Condition using Lambda expressions
        Predicate<Integer> moreThan2Pred = (p) -> (p > 2);

        // Use the stream method noneMatch to see if all elements fulfils the Predicate.
        System.out.println(intSet.stream().noneMatch(moreThan2Pred)); // Prints False.
    }

    /**
     * Count number of collection elements
     */

    private void countElements() {
        // Declare and Initialize the Collection
        Set<Integer> intSet = new HashSet<Integer>();

        // Add Elements
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);

        // Use the stream method count to see if all elements fulfils the Predicate.

        System.out.println(intSet.stream().count()); // Prints 4.
    }

    /**
     * Find the Average of all collection elements
     */
    private void findAverage() {
        // Declare and Initialize the Collection
        Set<Integer> intSet = new HashSet<Integer>();

        // Add Elements
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);

        // Use the stream and Collector to find the average of all elements.
        System.out.println(intSet.stream().collect(Collectors.averagingInt(p -> ((Integer) p)))); // Prints 2.5
    }

    /**
     * Group elements by even or odd
     */
    private void groupEvenOdd() {
        // Declare and Initialize the Collection
        Set<Integer> intSet = new HashSet<Integer>();

        // Add Elements
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);

        // Use the stream and Collector to Group by Even and Odd
        System.out.println(intSet.stream().collect(Collectors.groupingBy(p -> (p) % 2))); // Prints {0=[2, 4], 1=[1, 3]}
    }

    /**
     * Sum all collection elements
     */
    private void sumAllElements() {
        // Declare and Initialize the Collection
        Set<Integer> intSet = new HashSet<Integer>();

        // Add Elements
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);

        // Use the stream and collectors to sum all elements.
        System.out.println(intSet.stream().collect(Collectors.summingInt(p -> (Integer) p)));
    }

    /**
     * Populate a List from Set elements
     */
    private void populateListFromSet() {
        // Declare and Initialize the Collection
        Set<Integer> intSet = new HashSet<Integer>();

        // Add Elements
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);

        // Use the stream and collectors to get List out of Set
        List li = intSet.stream().collect(Collectors.toList());
        System.out.println(li); // Prints [1, 2, 3, 4]
    }

    /**
     * Get the complete Summary of Collection Elements
     */
    private void completeSummarize() {
        // Declare and Initialize the Collection
        Set<Integer> intSet = new HashSet<Integer>();

        // Add Elements
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);

        // Use the stream and collectors to Summarize all Integer elements
        System.out.println(intSet.stream().collect(Collectors.summarizingInt(p -> ((Integer) p))));
        // Prints IntSummaryStatistics{count=4, sum=10, min=1, average=2.500000, max=4}
    }

    /**
     * Combine two Summaries and Generate a new Summary
     */

    private void combineSummaries() {
        // Declare and Initialize the Collections
        Set<Integer> intSet = new HashSet<Integer>();
        Set<Integer> intSet2 = new HashSet<Integer>();

        // Add Elements
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);
        intSet2.add(1);
        intSet2.add(2);
        intSet2.add(3);
        intSet2.add(4);

        // Use the stream and collectors to Summarize all Integer elements
        IntSummaryStatistics summary = intSet.stream().collect(Collectors.summarizingInt(p -> ((Integer) p)));
        summary.combine(intSet2.stream().collect(Collectors.summarizingInt(p -> ((Integer) p))));

        System.out.println(summary); // Prints IntSummaryStatistics{count=8, sum=20, min=1, average=2.500000, max=4}
    }

    /**
     * Create a Map using Set elements
     */
    private void createMapFromSet() {
        // Declare and Initialize the Collection
        Set<Integer> intSet = new HashSet<Integer>();

        // Add Elements
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);
        System.out.println("Creating Map from Set:");
        System.out.println(intSet.stream().collect((Collectors.toMap(p -> p, q -> q * 500))));
        // Prints {1=500, 2=1000, 3=1500, 4=2000}
    }

    /**
     * Get count of elements greater than 1
     */
    private void countElementsByCondition() {
        // Declare and Initialize the Collection
        Set<Integer> intSet = new HashSet<Integer>();

        // Add Elements
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);

        Predicate<Integer> moreThan2Pred = (p) -> (p > 2);

        // Use Stream, Predicate and Filter to get the count of elements more than 1
        System.out.println(intSet.stream().filter(moreThan2Pred).count()); // Prints 3
    }

    /**
     * Get all elements greater than 2, sort them and then push them to a new set
     */
    private void countSortPush() {
        // Declare and Initialize the Collection
        Set<Integer> intSet = new HashSet<Integer>();

        // Add Elements
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);

        // Set the predicate or the condition for filtering the elements.
        Predicate<Integer> moreThan2Pred = (p) -> (p > 1);

        // Use Filter to refine the element set, sort to Sort and Collectors.toSet to get a set out of Stream.
        intSet = intSet.stream().filter(moreThan2Pred).sorted().collect(Collectors.toSet());

        System.out.println(intSet); // Prints [2, 3, 4]
    }

    /**
     * Get the Maximum number out of the Integer List
     */
    private void getMaxNumber() {
        // Declare and Initialize the Collection
        List<Integer> intList = new ArrayList<Integer>();

        // Add Elements
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);

        System.out.println(intList.stream().reduce(Math::max).get()); // Prints 1
    }

    private void removeDuplicateValues() {
        List<Integer> listWithDuplicates = Arrays.asList(1, 1, 2, 2, 3, 3);
        List<Integer> listWithoutDuplicates = listWithDuplicates.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("List with duplicates: " + listWithDuplicates);
        System.out.println("After removing duplicates:" + listWithoutDuplicates);
    }
}
