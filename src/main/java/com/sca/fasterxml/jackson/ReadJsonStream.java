package com.sca.fasterxml.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ReadJsonStream {

    public static void main(String[] args) {
        ReadJsonStream runner = new ReadJsonStream();
        ClassLoader classLoader = runner.getClass().getClassLoader();
        File file = new File(classLoader.getResource("developers.json").getFile());

        ObjectMapper mapper = new ObjectMapper();
        JsonFactory jsonFactory = mapper.getFactory();
        try {
            JsonParser parser = jsonFactory.createParser(file);
            //JsonToken token;
            /*while ((token = parser.nextToken()) != null) {
                switch (token) {
				case START_OBJECT:
					JsonNode node = parser.readValueAsTree();
					System.out.println("Read object: " + node.toString());
					break;
				}
			}*/
            while (parser.nextToken() != JsonToken.END_OBJECT) {
                String fieldname = parser.getCurrentName();
                if ("data".equals(fieldname)) {
                    while (parser.nextToken() != JsonToken.END_ARRAY) {
                        System.out.println("data content: " + parser.getText());
                    }
                }
                if ("developer".equals(fieldname)) {
                    parser.nextToken();
                    System.out.println("Developer:" + parser.getText());
                }
            }
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
