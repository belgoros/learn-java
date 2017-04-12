package com.sca.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Created by ZFTC0418 on 27/03/2015.
 */
public class CollectionsExamples {

    public static void main(String[] args) {
        /*finLastElementWithGuava();
		finLastElementWithApacheCommons();
		finLastElementWithPureJava();
		collectionFilterExample();
		filterWithRetain();*/

        CollectionsExamples examples = new CollectionsExamples();
        examples.selectClients();
    }

    private static void finLastElementWithGuava() {
        List<String> strings = Lists.newArrayList("one", "two", "three");
        String lastElement = Iterables.getLast(strings, null);
        System.out.println(lastElement);
    }

    private static void finLastElementWithApacheCommons() {
        List<String> strings = Lists.newArrayList("one", "two", "three");
        String lastElement = (String) CollectionUtils.get(strings, strings.size() - 1);
        System.out.println(lastElement);
    }

    private static void finLastElementWithPureJava() {
        List<String> strings = new ArrayList<String>();
        strings.add("one");
        strings.add("two");
        strings.add("three");

        String lastElement = null;
        lastElement = strings.get(strings.size() - 1);
        System.out.println(lastElement);
    }

    private static void collectionFilterExample() {
        List<String> names = Arrays.asList("Ted", "Fred", "Jed", "Ned");
        List<String> shortNames = new ArrayList<String>();

        shortNames.addAll(names);
        // Take the names with less than 4 character length only
        CollectionUtils.filter(shortNames, new Predicate() {
            @Override
            public boolean evaluate(Object input) {
                return ((String) input).length() < 4;
            }
        });
        System.out.println(shortNames.size());
        for (String s : shortNames) {
            System.out.println(s);
        }
    }

    private static void filterWithRetain() {
        List<Integer> lstOne = new ArrayList<Integer>();
        lstOne.add(1);
        lstOne.add(2);
        lstOne.add(3);
        lstOne.add(4);

        List<Integer> lstTwo = new ArrayList<Integer>();
        lstTwo.add(2);
        lstTwo.add(4);
        lstTwo.add(6);
        lstTwo.add(8);

        lstOne.retainAll(lstTwo);

        System.out.println(lstOne);
    }

    private void selectClients() {
        List<Client> fullList = new ArrayList<Client>();
        for (int x = 1; x < 3; x++) {
            Client client = new Client("1/0" + x + "/1970", "Jean", "Dupont-" + x);
            fullList.add(client);
            System.out.println("Added client: " + client);

        }

        for (int x = 1; x < 3; x++) {
            Client client = new Client("2/0" + x + "/1970", "Toto", "Yoyo-" + x);
            fullList.add(client);
            System.out.println("Added client: " + client);
        }

        CollectionUtils.filter(fullList, new Predicate() {
            @Override
            public boolean evaluate(Object object) {
                Client client = (Client) object;
                boolean result = client.getBirthdate().equals("1/02/1970") &&
                        (client.getFirstName().toUpperCase().startsWith("JE") || client.getLastName().toUpperCase().startsWith("T"));

                return result;
            }
        });

        for (Client client : fullList) {
            System.out.println(client.getLastName());
        }
    }

    private class Client {

        private String birthdate, firstName, lastName;

        public Client(String birthdate, String firstName, String lastName) {
            this.birthdate = birthdate;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getBirthdate() {
            return birthdate;
        }

        public void setBirthdate(String birthdate) {
            this.birthdate = birthdate;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return getFirstName().concat(" ").concat(getLastName()).concat(" ").concat(getBirthdate());

        }
    }
}
