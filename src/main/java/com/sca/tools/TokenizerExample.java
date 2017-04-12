package com.sca.tools;

import java.util.StringTokenizer;

/**
 * Created by z28scamb on 24/05/2016.
 */
public class TokenizerExample {

    public static void main(String[] args) {
        String acceptLang = "en,fr;q=0.8,ru;q=0.6";
        StringTokenizer tokenizer = new StringTokenizer(acceptLang, ",; ");

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            String language = token.replace('-', '_');

            System.out.println(language);
        }
    }
}
