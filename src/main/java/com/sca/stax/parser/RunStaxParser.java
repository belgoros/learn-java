package com.sca.stax.parser;

import java.io.File;
import java.util.List;

public class RunStaxParser {

    /**
     * @param args
     */
    public static void main(String[] args) {
        RunStaxParser runner = new RunStaxParser();
        ClassLoader classLoader = runner.getClass().getClassLoader();
        File file = new File(classLoader.getResource("entities.xml").getFile());
        StaxParser staxParser = new StaxParser();
        List<Item> list = staxParser.read(file);
        for (Item item : list) {
            System.out.println(item);
        }
    }
}
