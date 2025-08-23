package com.sca.json;

import net.javacrumbs.jsonunit.core.Option;
import org.junit.Test;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.*;

public class JsonUnitExampleTest {

    @Test
    public void shouldTestWithAssertJ() {
        assertThatJson("{\"a\":1, \"b\":2}").isEqualTo("{b:2, a:1}");

        // Type placeholders
        assertThatJson("{\"a\":1, \"b\": {\"c\" :3}}")
                .isObject().containsValue(json("{\"c\" :\"${json-unit.any-number}\"}"));

        // AssertJ string assertion
        assertThatJson("""
                {
                    "a": "value"
                }""")
                .node("a").isString().isEqualTo("value");

        // AssertJ array assertion
        assertThatJson("{\"a\":[{\"b\": 1}, {\"c\": 1}, {\"d\": 1}]}")
                .node("a").isArray().contains(json("{\"c\": 1}"));

        // Can ignore array order
        assertThatJson("{\"a\":[{\"b\": 1}, {\"c\": 1}, {\"d\": 1}]}")
                .when(Option.IGNORING_ARRAY_ORDER).node("a").isArray()
                .isEqualTo(json("[{\"c\": 1}, {\"b\": 1} ,{\"d\": 1}]"));

        // JsonPath support
        String json = """
                {
                    "store": {
                        "book": [
                            {
                                "category": "reference",
                                "author": "Nigel Rees",
                                "title": "Sayings of the Century",
                                "price": 8.96
                            }
                        ]
                    }
                }""";
        assertThatJson(json)
                .inPath("$.store.book")
                .isArray()
                .contains(json(
                        """
                                            {
                                                "category": "reference",
                                                "author": "Nigel Rees",
                                                "title": "Sayings of the Century",
                                                "price": 8.96
                                            }\
                                """
                ));


        // This test does NOT pass. "1" is parsed as JSON containing number 1, the actual value is a string.
        /*assertThatJson("{\"id\":\"1\", \"children\":[{\"parentId\":\"1\"}]}")
                .inPath("children[*].parentId")
                .isArray()
                .containsOnly("1");*/

        // You have to wrap the expected value by `JsonAssertions.value()`
        // to prevent parsing
        assertThatJson("{\"id\":\"1\", \"children\":[{\"parentId\":\"1\"}]}")
                .inPath("children[*].parentId")
                .isArray()
                .containsOnly(value("1"));
    }
}
