package com.sca.stax.parser;

import com.sca.jaxb.BatchStructuredLine;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZFTC0418 on 04/03/2015.
 */
public class ReadStructuredEntities {

    public static void main(String[] args) {
        ReadStructuredEntities runner = new ReadStructuredEntities();
        URL url = runner.getClass().getClassLoader().getResource("entities.xml");
        if (url == null) {
            System.err.println("Wrong URL");
            System.exit(1);
        }
        File xmlFile = new File(url.getFile());
        if (!xmlFile.isFile() || !xmlFile.exists()) {
            System.err.println("File not found");
            System.exit(1);
        }

        List entities = parseXML(xmlFile);
        for (Object entity : entities) {
            System.out.println(entity);
        }
    }

    private static List<BatchStructuredLine> parseXML(File xmlFle) {
        List<BatchStructuredLine> entitiesList = new ArrayList<BatchStructuredLine>();
        BatchStructuredLine entity = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader eventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(xmlFle));


            while (eventReader.hasNext()) {
                XMLEvent xmlEvent = eventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("BatchStructuredLine")) {
                        entity = new BatchStructuredLine();
                        //Get the 'id' attribute from Employee element
                        Attribute numberAttr = startElement.getAttributeByName(new QName("number"));
                        if (numberAttr != null) {
                            entity.setNumber(numberAttr.getValue());
                        }
                    } else if (startElement.getName().getLocalPart().equals("extension")) {
                        xmlEvent = eventReader.nextEvent();
                        entity.setExtension(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("street")) {
                        xmlEvent = eventReader.nextEvent();
                        entity.setStreet(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("locality")) {
                        xmlEvent = eventReader.nextEvent();
                        entity.setLocality(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("postalCode")) {
                        xmlEvent = eventReader.nextEvent();
                        entity.setPostalCode(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("city")) {
                        xmlEvent = eventReader.nextEvent();
                        entity.setCity(xmlEvent.asCharacters().getData());
                    }
                }

                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("BatchStructuredLine")) {
                        entitiesList.add(entity);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return entitiesList;
    }
}
