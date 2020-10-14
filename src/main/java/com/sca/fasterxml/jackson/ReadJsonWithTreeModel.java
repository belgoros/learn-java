package com.sca.fasterxml.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ReadJsonWithTreeModel {

    enum Operation {
        CREATE("c"),
        UPDATE("u"),
        DELETE("d"),
        UNKNOWN("UNKNOWN");

        private static final Map<String, Operation> OPERATIONS = new HashMap<>();

        static {
            for (final Operation operation : values()) {
                OPERATIONS.put(operation.letter, operation);
            }
        }

        private final String letter;

        Operation(String letter) {
            this.letter = letter;
        }

        public static Operation getByLetter(final String letter) {
            final Operation operation = OPERATIONS.get(letter);
            if (operation == null) {
                return UNKNOWN;
            }
            return operation;
        }
    }


    public static void main(String[] args) throws IOException {
        ReadJsonWithTreeModel runner = new ReadJsonWithTreeModel();
        ClassLoader classLoader = runner.getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("kafka.json")).getFile());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file);
        JsonNode payload = rootNode.path("payload").path("after");
        System.out.println("++++++= Display payload values ++++++++++++");
        System.out.println("username: " + payload.get("username").asText());

        String operationLetter = rootNode.path("payload").get("op").asText();
        Operation operation = Operation.getByLetter(operationLetter);

        switch (operation) {
            case CREATE:
                System.out.println("CREATE");
                break;
            case DELETE:
                System.out.println("DELETE");
                break;
            case UPDATE:
                System.out.println("UPDATE");
            default:
                System.err.println("Unknown operation: " + operationLetter);
        }
    }
}
