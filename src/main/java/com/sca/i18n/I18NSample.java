package com.sca.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by z28scamb on 24/05/2016.
 */
public class I18NSample {
    static public void main(String[] args) {

        String language;
        @SuppressWarnings("unused")
        String country;

        if (args.length != 2) {
            language = new String("en");
            country = new String("US");
        } else {
            language = new String(args[0]);
            country = new String(args[1]);
        }

        Locale currentLocale;
        ResourceBundle bundle;

        currentLocale = new Locale(language);

        bundle = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        System.out.println(bundle.getString("greetings"));
        System.out.println(bundle.getString("inquiry"));
        System.out.println(bundle.getString("farewell"));
    }
}
