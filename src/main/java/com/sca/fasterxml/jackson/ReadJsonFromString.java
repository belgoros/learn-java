package com.sca.fasterxml.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;

/**
 * Created by Serguei on 30/11/2016.
 */
public class ReadJsonFromString {

    public static void main(String[] args) throws IOException {

        String jsonString = "{\"referenceModelPrice\":7.69,\"models\":[8066692,8152079,8311894,8341215,8066693,8280915,8280989,8297656,8297657,8288276,8325274,8240443,8297551,8311897,8325273,8341219,8297552,8066696,8311896,8311895,8240438,8325275,8341217,8066694,8296634,8280983,8280988,8240440,8280990,8325278,8325277,8325276,8341214,8366103]}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonRoot = mapper.readTree(jsonString);
        double price = jsonRoot.get("referenceModelPrice").asDouble();
        System.out.println("price: " + price);

        JsonNode models = jsonRoot.path("models");


        for (JsonNode modelNode : models) {
            System.out.println("model: " + modelNode.asInt());
        }

        ArrayNode modelsNode = (ArrayNode) jsonRoot.get("models");
        for (JsonNode jsonNode : modelsNode) {
            System.out.println("model from array node: " + jsonNode.asInt());
        }
    }
}
