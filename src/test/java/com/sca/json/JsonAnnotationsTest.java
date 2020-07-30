package com.sca.json;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class JsonAnnotationsTest {

    private class ExtendableBean {
        public String name;
        private Map<String, String> properties = new HashMap<>();

        public ExtendableBean(String name) {
            this.name = name;
            this.properties = new HashMap<>();
        }

        public void add(String key, String value) {
            properties.put(key, value);
        }

        @JsonAnyGetter
        public Map<String, String> getProperties() {
            return properties;
        }
    }

    @Test
    public void whenSerializingUsingJsonAnyGetter_thenCorrect()
            throws JsonProcessingException {

        ExtendableBean bean = new ExtendableBean("My bean");
        bean.add("attr1", "val1");
        bean.add("attr2", "val2");

        String result = new ObjectMapper().writeValueAsString(bean);

        assertThat(result, containsString("attr1"));
        assertThat(result, containsString("val1"));
    }
}
