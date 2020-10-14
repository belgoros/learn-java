package com.sca.fasterxml.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ReadJsonWithTreeModel {

    public static void main(String[] args) throws IOException {
        ReadJsonWithTreeModel runner = new ReadJsonWithTreeModel();
        ClassLoader classLoader = runner.getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("kafka.json")).getFile());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file);
        JsonNode payload = rootNode.path("payload").path("after");
        System.out.println("++++++= Display payload values ++++++++++++");
        System.out.println("username: " + payload.path("username").asText());
    }
}
