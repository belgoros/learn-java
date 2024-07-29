package com.sca.json;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import static uk.org.webcompere.modelassert.json.JsonAssertions.assertJson;
import static uk.org.webcompere.modelassert.json.PathWildCard.ANY;
import static uk.org.webcompere.modelassert.json.PathWildCard.ANY_SUBTREE;
import static uk.org.webcompere.modelassert.json.Patterns.GUID_PATTERN;
import static uk.org.webcompere.modelassert.json.condition.ConditionList.conditions;

public class ModelAssertJsonTest {

    @Test
    public void shouldTestJsonString() {
        String jsonString = loadFile("test.json");
        assertJson(jsonString)
                .at("/name").isText("Baeldung");

        assertJson(jsonString)
                .at("/name").isText("Baeldung")
                .at("/topics/1").isText("Spring");
    }

    @Test
    public void shouldTestAnyNode() {
        String jsonString = loadFile("test.json");
        assertJson(jsonString)
                .isNotNull()
                .isNotNumber()
                .isObject()
                .containsKey("name");

        assertJson(jsonString)
                .at("/topics").hasSize(5);

        assertJson(jsonString)
                .at("/isOnline").booleanNode().isTrue();
    }

    @Test
    public void shouldTestTextNode() {
        String jsonString = loadFile("test.json");
        assertJson(jsonString)
                .at("/name").textContains("ael");

        assertJson(jsonString)
                .at("/name").matches("[A-Z].+");
    }

    @Test
    public void shouldTestNumberNode() {
        assertJson("{count: 12}")
                .at("/count").isBetween(1, 25);

        assertJson("{height: 6.3}")
                .at("/height").isGreaterThanDouble(6.0);

        assertJson("{height: 6.3}")
                .at("/height").isNumberEqualTo(6.3);
    }

    @Test
    public void shouldMatchWholeTree() {
        String jsonString = loadFile("test.json");
        assertJson(jsonString)
                .at("/topics")
                .isEqualTo("[ \"Java\", \"Spring\", \"Kotlin\", \"Scala\", \"Linux\" ]");
    }

    @Test
    public void shouldTestArrayNode() {
        String jsonString = loadFile("test.json");
        assertJson(jsonString)
                .at("/topics").isArrayContaining("Scala", "Spring");

        assertJson(jsonString)
                .at("/topics")
                .isArrayContainingExactlyInAnyOrder("Scala", "Spring", "Java", "Linux", "Kotlin");
    }

    @Test
    public void shouldTestItemsOrder() {
        String actualJson = "{a:{d:3, c:2, b:1}}";
        String expectedJson = "{a:{b:1, c:2, d:3}}";
        assertJson(actualJson)
                .where().keysInAnyOrder()
                .isEqualTo(expectedJson);

        assertJson(actualJson)
                .where()
                .at("/a").keysInAnyOrder()
                .isEqualTo(expectedJson);
    }

    @Test
    public void shouldTestWhenItemsInAnyOrder() {
        String actualJson = "{a:[1, 2, 3, 4, 5]}";
        String expectedJson = "{a:[5, 4, 3, 2, 1]}";

        assertJson(actualJson)
                .where().arrayInAnyOrder()
                .isEqualTo(expectedJson);
    }

    @Test
    public void shouldTestWhenIgnoringItemPath() {
        String actualJson = "{user:{name: \"Baeldung\", url:\"http://www.baeldung.com\"}}";
        String expectedJson = "{user:{name: \"Baeldung\"}}";

        assertJson(actualJson)
                .where()
                .at("/user/url").isIgnored()
                .isEqualTo(expectedJson);
    }

    /*
    expected value could have anything for the id field because we’ve simply ignored any field
    whose JSON Pointer starts “/user/credentials” then has a single node (the array index) and
    ends in “/id”.
     */
    @Test
    public void shouldTestWhenApplyingWildcards() {
        String actualJson = "{user:{credentials:[" +
                "{id:\"a7dc2567-3340-4a3b-b1ab-9ce1778f265d\",role:\"Admin\"}," +
                "{id:\"09da84ba-19c2-4674-974f-fd5afff3a0e5\",role:\"Sales\"}]}}";
        String expectedJson = "{user:{credentials:" +
                "[{id:\"???\",role:\"Admin\"}," +
                "{id:\"???\",role:\"Sales\"}]}}";

        assertJson(actualJson)
                .where()
                .path("user", "credentials", ANY, "id").isIgnored()
                .isEqualTo(expectedJson);

        /*
        The ANY_SUBTREE wildcard matches any number of nodes between parts of the path expression.
        The GUID_PATTERN comes from the ModelAssert Patterns class, which contains some common regular
        expressions to match things like numbers and date stamps
         */
        assertJson(actualJson)
                .where()
                .path(ANY_SUBTREE, "id").matches(GUID_PATTERN)
                .isEqualTo(expectedJson);
    }

    @Test
    public void shouldTestNestedData() {
        String actualJson = loadFile("nested_data.json");
        assertJson(actualJson).at("/level1/level2/items")
                .isArrayContainingExactlyInAnyOrder(conditions()
                        .satisfies(conditions()
                                .at("/id").isNumberEqualTo(1)
                                .at("/name").hasValue("item1")
                        )
                        .satisfies(conditions()
                                .at("/id").isNumberEqualTo(2)
                                .at("/name").hasValue("item2")
                        )
                        .satisfies(conditions()
                                .at("/id").isNumberEqualTo(3)
                                .at("/name").hasValue("item3")
                        )
                );
    }


    private String loadFile(String fileName) {
        var inputStream = getClass().getResourceAsStream("/" + fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("File not found! " + fileName);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            return null;
        }
    }
}
