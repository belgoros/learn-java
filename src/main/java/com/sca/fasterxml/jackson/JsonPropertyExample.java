package com.sca.fasterxml.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonPropertyExample {
    @JsonProperty("person-id")
    public long personId = 123L;

    public String  name = "James Clark";
    @Override
    public String toString() {
        return "PropertyDemoBean{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                '}';
    }
}
