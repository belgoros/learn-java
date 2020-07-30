package com.sca.fasterxml.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

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
}
