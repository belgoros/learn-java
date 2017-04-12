package com.sca.fasterxml.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Serguei on 01/12/2016.
 */
public class JavaObjectToJson {

    public static void main(String[] args) throws JsonProcessingException {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 1; i < 6; i++) {
            if (i % 2 == 0) {
                map.put(i, true);
            } else {
                map.put(i, false);
            }
        }
        System.out.println("built map: " + map);

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(map);
        System.out.println(jsonInString);
    }
}
