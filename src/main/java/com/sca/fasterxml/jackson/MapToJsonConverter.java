package com.sca.fasterxml.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class MapToJsonConverter {
    public static void main(String[] args) throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");

        System.out.println("Map: " + map);

        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        System.out.println(jsonResult);
    }
}
