package com.sca.sax.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CustomSaxHandler extends DefaultHandler {
    /**
     * startDocument() and endDocument() – Method called at the start and end of an FILES_FOLDER document.
     * startElement() and endElement() – Method called at the start  and end of a document element.
     * characters() – Method called with the text contents in between the start and end tags of an FILES_FOLDER document element.
     */

    boolean bfname = false;
    boolean blname = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start Element :" + qName);

        if (qName.equalsIgnoreCase("FIRSTNAME")) {
            this.bfname = true;
        }

        if (qName.equalsIgnoreCase("LASTNAME")) {
            blname = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element :" + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bfname) {
            System.out.println("First Name : " + new String(ch, start, length));
            bfname = false;
        }

        if (blname) {
            System.out.println("Last Name : " + new String(ch, start, length));
            blname = false;
        }
    }
}
