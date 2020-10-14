package com.sca.fasterxml.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JsonPropertyExampleTest {

    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testSerializingWithJsonProperty()
            throws JsonProcessingException {
        String jsonString = objectMapper.writeValueAsString(new JsonPropertyExample());
        System.out.println(jsonString);
        assertThat(jsonString, containsString("James Clark"));
        assertThat(jsonString, containsString("123"));
    }

    @Test
    public void testDeSerializingWithJsonProperty() throws IOException {
        String jsonString = "{\"person-id\": 231, \"name\": \"Mary Parker\"}";
        JsonPropertyExample bean = objectMapper.readValue(jsonString, JsonPropertyExample.class);
        System.out.println(bean);
        assertThat(bean.name, is(equalTo("Mary Parker")));
        assertThat(bean.personId, is(equalTo(231L)));
    }

    @Test
    public void testKafkaJson() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("kafka.json")).getFile());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file);
        JsonNode payload = rootNode.path("payload").path("after");
        System.out.println("++++++= Display payload values ++++++++++++");
        System.out.println("username: " + payload.path("username").asText());
    }
}
