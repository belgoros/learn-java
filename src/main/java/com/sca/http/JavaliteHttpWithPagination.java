package com.sca.http;

import com.sca.regex.ParseUrlWithRegex;
import org.javalite.http.Get;
import org.javalite.http.Http;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class JavaliteHttpWithPagination {
    private final static String API_URL = "https://api.phraseapp.com/api/v2/projects/";
    private final static String PROJECT_ID = "c1043b898698aab0cd3c7afb61e99ed9";
    private final static String TOKEN = "59e0b0be34894e6e724e9f294a18fbcd2833c6e0302b51aa3105beb0d5f066ce";
    private final static String TRANSLATIONS_URL = "/translations";

    public static void main(String[] args) {
        JavaliteHttpWithPagination example = new JavaliteHttpWithPagination();
        final Get response = Http.get(example.buildUrl()).header("Authorization", "token " + TOKEN);
        System.out.println(response.text());

        final Map<String, List<String>> headers = response.headers();
        final List<String> headerLink = headers.get("Link");
        if (headerLink != null) {
            String link = headerLink.get(0);
            ParseUrlWithRegex parser = new ParseUrlWithRegex();
            parser.processHeaderLink(link);
        }
    }
    private String buildUrl() {
        StringJoiner joiner = new StringJoiner("/");
        joiner.add(API_URL).add(PROJECT_ID).add(TRANSLATIONS_URL);

        return joiner.toString();
    }
}
