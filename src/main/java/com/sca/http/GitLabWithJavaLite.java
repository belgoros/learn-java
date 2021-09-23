package com.sca.http;

import org.javalite.http.Get;
import org.javalite.http.Http;

import java.util.StringJoiner;

public class GitLabWithJavaLite {

    private final static String API_URL = "https://gitlab.com/api/v4";
    private final static String PROJECT_ID = "19943940";
    private final static String TOKEN = "84QcngsBhNKRi9Kf_Rsr";
    private final static String PROJECTS_URL = "projects";
    private final static String TAGS_URL = "repository/tags";

    public static void main(String[] args) {
        com.sca.http.GitLabWithJavaLite example = new com.sca.http.GitLabWithJavaLite();
        Get response = Http.get(example.buildUrl()).header("Authorization", "Bearer " + TOKEN);
        System.out.println(response.text());
    }

    private String buildUrl() {
        StringJoiner joiner = new StringJoiner("/");
        joiner.add(API_URL).add(PROJECTS_URL).add(PROJECT_ID).add(TAGS_URL);

        return joiner.toString();
    }
}
