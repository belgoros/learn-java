package com.sca.basic;

import java.util.Locale;

/**
 * Created by z28scamb on 27/06/2016.
 */
public class LocaleExample {

    public static void main(String[] args) {
        Locale locale = Locale.forLanguageTag("fr-FR");
        System.out.println("Locale: " + locale);
        System.out.println("country: " + locale.getCountry() + ", language: " + locale.getLanguage());
    }
}
