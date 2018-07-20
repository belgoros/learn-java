package com.sca.fasterxml.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadJsonFromString {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        //readNestedJson();
        //readPhraseChromeJson();
        readPhraseSimpleJson();
    }

    private static void readNestedJson() throws IOException {
        System.out.println("++++++++++++++++ nested classic JSON ++++++++++++++++++++++");
        JsonNode jsonRoot = MAPPER.readTree(nestedJson());
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

    private static void readPhraseChromeJson() throws IOException {
        System.out.println("++++++++++++++++ PhraseApp json (chrome json) ++++++++++++++++++++++");
        JsonNode jsonRoot = MAPPER.readTree(phraseChromeJson());
        JsonNode jsonNode = jsonRoot.get("balisage.errorTransfer");
        JsonNode message = jsonNode.get("message");
        System.out.println(message.asText());
    }

    private static String nestedJson() {
        return "{\"referenceModelPrice\":7.69,\"models\":[8066692,8152079,8311894,8341215,8066693,8280915,8280989,8297656,8297657,8288276,8325274,8240443,8297551,8311897,8325273,8341219,8297552,8066696,8311896,8311895,8240438,8325275,8341217,8066694,8296634,8280983,8280988,8240440,8280990,8325278,8325277,8325276,8341214,8366103]}";
    }

    private static void readPhraseSimpleJson() throws IOException {
        System.out.println("++++++++++++++++ PhraseApp simple_json ++++++++++++++++++++++");
        JsonNode jsonRoot = MAPPER.readTree(phraseSimpleJSON());
        JsonNode jsonNode = jsonRoot.get("balisage.errorGeneration");
        HashMap hashMap = MAPPER.readValue(phraseSimpleJSON(), HashMap.class);

        TypeReference<HashMap<String, String>> typeRef = new TypeReference<HashMap<String, String>>() {
        };
        Map<String, String> map = MAPPER.readValue(phraseSimpleJSON(), typeRef);


        System.out.println(map);
    }

    /**
     * file_format=json
     *
     * @return
     */
    private static String phraseChromeJson() {
        String json = "{\n" +
                "  \"balisage.concupour\": {\n" +
                "    \"message\": \"Conçu pour\",\n" +
                "    \"description\": \"Visible by the customer\"\n" +
                "  },\n" +
                "  \"balisage.date.on\": {\n" +
                "    \"message\": \"le\",\n" +
                "    \"description\": \"Visible by the customer\"\n" +
                "  },\n" +
                "  \"balisage.errorGeneration\": {\n" +
                "    \"message\": \"Erreur à la génération du fichier\",\n" +
                "    \"description\": \"Error displayed to the seller when a problem happens during the markup generation\"\n" +
                "  },\n" +
                "  \"balisage.errorTransfer\": {\n" +
                "    \"message\": \"Erreur lors du transfert du fichier\",\n" +
                "    \"description\": \"Error displayed to the seller when a problem happens during the markup download\"\n" +
                "  }\n" +
                "}";

        return json;
    }

    /**
     * file_format=simple_json
     *
     * @return
     */
    private static String phraseSimpleJSON() {
        String simpleJson = "{\n" +
                "  \"balisage.concupour\": \"Conçu pour\",\n" +
                "  \"balisage.date.on\": \"le\",\n" +
                "  \"balisage.errorGeneration\": \"Erreur à la génération du fichier\",\n" +
                "  \"balisage.errorTransfer\": \"Erreur lors du transfert du fichier\",\n" +
                "  \"balisage.from.date.without.end.date\": \"A partir du\",\n" +
                "  \"balisage.from.the\": \"Depuis le\",\n" +
                "  \"balisage.garantie.annee\": \"an\",\n" +
                "  \"balisage.garantie.annees\": \"ans\",\n" +
                "  \"balisage.no.product.reviews\": \"Il n'y a pas d'avis disponibles pour ce modèle\"}";

        return simpleJson;
    }
}
