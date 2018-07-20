package com.sca.elasticsearch;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.node.Node;
import org.elasticsearch.search.SearchHit;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * Created by serguei_cambour on 17/12/2015.
 */
public class RunElasticSearch {

    public static void main(String[] args) {
        Node node = nodeBuilder().node();
        Client client = node.client();
        client.prepareIndex("kodcucom", "article", "1")
                .setSource(putJsonDocument("ElasticSearch: Java API",
                        "ElasticSearch provides the Java API, all operations "
                                + "can be executed asynchronously using a client object.",
                        new Date(),
                        new String[]{"elasticsearch"},
                        "Hüseyin Akdoğan")).execute().actionGet();

        node.close();
    }

    /**
     * The Index API allows you to type a JSON document into a specific index and makes it searchable.
     * There are different ways of generating JSON document. In here we used map which represents JSON structure very well.
     *
     * @param title
     * @param content
     * @param postDate
     * @param tags
     * @param author
     * @return
     */
    public static Map<String, Object> putJsonDocument(String title, String content, Date postDate,
                                                      String[] tags, String author) {

        Map<String, Object> jsonDocument = new HashMap<String, Object>();

        jsonDocument.put("title", title);
        jsonDocument.put("conten", content);
        jsonDocument.put("postDate", postDate);
        jsonDocument.put("tags", tags);
        jsonDocument.put("author", author);

        return jsonDocument;
    }

    public static void getDocument(Client client) {
        GetResponse getResponse = client.prepareGet("kodcucom", "article", "1").execute().actionGet();

        Map<String, Object> source = getResponse.getSource();

        System.out.println("------------------------------");
        System.out.println("Index: " + getResponse.getIndex());
        System.out.println("Type: " + getResponse.getType());
        System.out.println("Id: " + getResponse.getId());
        System.out.println("Version: " + getResponse.getVersion());
        System.out.println(source);
        System.out.println("------------------------------");
    }

    public static void searchDocument(Client client, String index, String type,
                                      String field, String value) {


        SearchResponse response = client.prepareSearch(index)
                .setTypes(type)
                .setSearchType(SearchType.QUERY_AND_FETCH)
                .setQuery(QueryBuilders.termQuery(field, value))
                .setFrom(0).setSize(60).setExplain(true)
                .execute()
                .actionGet();

        SearchHit[] results = response.getHits().getHits();

        System.out.println("Current results: " + results.length);
        for (SearchHit hit : results) {
            System.out.println("------------------------------");
            Map<String, Object> result = hit.getSource();
            System.out.println(result);
        }

    }
}
