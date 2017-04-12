package com.sca.sax.parser;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxXMLReader {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SaxXMLReader runner = new SaxXMLReader();
        ClassLoader classLoader = runner.getClass().getClassLoader();
        File file = new File(classLoader.getResource("developers.xml").getFile());
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new CustomSaxHandler();
            saxParser.parse(file, handler);
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
