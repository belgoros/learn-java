package com.sca.jaxb;

import com.sca.files.Folders;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by ZFTC0418 on 23/02/2015.
 */
public class WriteWithStream {

    public static void main(String[] args) throws FileNotFoundException {

        try {
            File file = new File(Folders.FILES_FOLDER, "entities.xml");

            XMLOutputFactory xof = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = xof.createXMLStreamWriter(new FileWriter(file));

            writer.writeStartDocument("utf-8", "1.0");
            writer.writeStartElement("data");

            BatchStructuredLine entity;
            for (int i = 0; i < 5; i++) {
                entity = new BatchStructuredLine();
                entity.setNumber("10" + i);
                entity.setExtension("A" + i);
                entity.setStreet("Rue Neuve");
                entity.setLocality("Uccle");
                entity.setPostalCode("118" + i);
                entity.setCity("Bruxelles");

                writer.writeStartElement("BatchStructuredLine");

                writer.writeStartElement("number");
                writer.writeCharacters(entity.getNumber());
                writer.writeEndElement();

                writer.writeStartElement("extension");
                writer.writeCharacters(entity.getExtension());
                writer.writeEndElement();

                writer.writeStartElement("street");
                writer.writeCharacters(entity.getStreet());
                writer.writeEndElement();

                writer.writeStartElement("locality");
                writer.writeCharacters(entity.getLocality());
                writer.writeEndElement();

                writer.writeStartElement("postalCode");
                writer.writeCharacters(entity.getPostalCode());
                writer.writeEndElement();

                writer.writeStartElement("city");
                writer.writeCharacters(entity.getCity());
                writer.writeEndElement();

                writer.writeEndElement();
            }
            writer.writeEndElement();

            writer.writeEndDocument();

            writer.flush();
            writer.close();
            System.out.println("Done");

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

