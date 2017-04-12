package com.sca.jaxb;

import com.sca.files.Folders;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by ZFTC0418 on 26/01/2015.
 */
public class PlayWithJAXB {

    public static void main(String[] args) {
        writeToXML();
        readFromXML();
        readStructuredEntities();

    }

    private static void readStructuredEntities() {
        File file = new File(Folders.FILES_FOLDER, "entities.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(StructuredEntities.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StructuredEntities structuredEntities = (StructuredEntities) jaxbUnmarshaller.unmarshal(file);
            for (BatchStructuredLine entity : structuredEntities.getEntities()) {
                System.out.println(entity);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void readFromXML() {
        File file = new File(Folders.FILES_FOLDER, "entities.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BatchStructuredLine.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            BatchStructuredLine entity = (BatchStructuredLine) jaxbUnmarshaller.unmarshal(file);
            System.out.println(entity);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void writeToXML() {
        BatchStructuredLine entity = new BatchStructuredLine();
        entity.setNumber("10");
        entity.setExtension("A");
        entity.setStreet("Rue Neuve");
        entity.setLocality("Uccle");
        entity.setPostalCode("1180");
        entity.setCity("Bruxelles");

        try {

            File file = new File(Folders.FILES_FOLDER, "entities.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(BatchStructuredLine.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(entity, file);
            jaxbMarshaller.marshal(entity, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
