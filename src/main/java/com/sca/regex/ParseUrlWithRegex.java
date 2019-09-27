package com.sca.regex;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class ParseUrlWithRegex {
    //Any character followed by "page=28>; rel=last"
    static String PAGES_REGEX = ".+page=(\\d+)>;\\s+rel=last$";

    private final static String API_URL = "https://api.phrase.com/v2/projects";
    private final static String PROJECT_ID = "c1043b898698aab0cd3c7afb61e99ed9";
    private final static String TRANSLATIONS_URL = "/translations";

    public static void main(String[] args) {
        ParseUrlWithRegex parser = new ParseUrlWithRegex();
        String headerLink = "<https://api.phrase.com/v2/projects/c1043b898698aab0cd3c7afb61e99ed9/translations?page=1>; rel=first, <https://api.phrase.com/v2/projects/c1043b898698aab0cd3c7afb61e99ed9/translations?page=28>; rel=last, <https://api.phrase.com/v2/projects/c1043b898698aab0cd3c7afb61e99ed9/translations?page=2>; rel=next";
        parser.processHeaderLink(headerLink);
    }

    private String buildUrl() {
        StringJoiner joiner = new StringJoiner("/");
        joiner.add(API_URL).add(PROJECT_ID).add(TRANSLATIONS_URL);

        return joiner.toString();
    }

    private String withPagination(int page) {
        return buildUrl() + "?page=" + page;
    }

    private void parse(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);
        boolean isMatched = matcher.matches();
        if (isMatched) {
            System.out.println("Matched -> Total pages: "  + matcher.group(1));
            int pagesNumber = Integer.valueOf(matcher.group(1));
            if (pagesNumber > 1) {
                makeAdditionalRequests(pagesNumber);
            }

        } else {
            System.err.println("No matches");
        }
    }

    private void makeAdditionalRequests(int pages) {
        for (int page = 1; page <= pages; page++) {
            System.out.println(withPagination(page));
        }
        System.out.println("Done for " + pages + "requests");
    }

    public void processHeaderLink(String headerLink) {
        final String lastLink = extractLastLink(headerLink);
        parse(lastLink, PAGES_REGEX);
    }

    private String extractLastLink(String link) {
        return Arrays.stream(extractLinks(link)).filter(s -> s.contains("last")).collect(toList()).get(0);
    }

    private String[] extractLinks(String link) {
        return link.split(",");
    }
}
