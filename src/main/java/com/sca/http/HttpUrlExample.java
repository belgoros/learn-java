package com.sca.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringJoiner;

public class HttpUrlExample {
    private final static String API_URL = "https://api.phraseapp.com/api/v2/projects/";
    private final static String PROJECT_ID = "c1043b898698aab0cd3c7afb61e99ed9";
    private final static String TOKEN = "59e0b0be34894e6e724e9f294a18fbcd2833c6e0302b51aa3105beb0d5f066ce";
    private final static String TRANSLATIONS_URL = "/translations";

    public static void main(String[] args) throws IOException {
        HttpUrlExample example = new HttpUrlExample();
        URL url = new URL(example.buildUrl());

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "token " + TOKEN);
        con.connect();

        int responseCode = con.getResponseCode();
        System.out.println("Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response.toString());
        } else {
            System.out.println("GET request failed");
        }

    }

    private String buildUrl() {
        StringJoiner joiner = new StringJoiner("/");
        joiner.add(API_URL).add(PROJECT_ID).add(TRANSLATIONS_URL);

        return joiner.toString();
    }
}
