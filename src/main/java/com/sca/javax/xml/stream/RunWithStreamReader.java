package com.sca.javax.xml.stream;

import com.sca.files.Folders;
import com.sca.jaxb.BatchEntity;
import com.sca.jaxb.BatchSemiStructuredLine;
import com.sca.jaxb.BatchStructuredLine;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * Created by ZFTC0418 on 03/03/2015.
 */
public class RunWithStreamReader {


    public static void main(String[] args) {

        RunWithStreamReader runner = new RunWithStreamReader();
        File inputFile = new File(Folders.ENTITIES_XML);

        XMLInputFactory factory = XMLInputFactory.newFactory();


        StreamSource xml = new StreamSource(inputFile);
        XMLStreamReader reader = null;
        try {
            reader = factory.createXMLStreamReader(xml);
            runner.next(reader);
            runner.next(reader);


        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private void next(XMLStreamReader reader) throws XMLStreamException, JAXBException {
        String modelTypeTagName = "BatchStructuredLine";
        BatchEntity result = null;
        boolean isSafeToGetNextXmlElement = true;
        if (reader.hasNext()) {
            if (reader.getEventType() == XMLStreamReader.START_ELEMENT) {
                if ("BatchStructuredLine".equals(reader.getLocalName())) {
                    result = unmarshallStructuredLine(reader);
                } else if ("BatchSemiStructuredLine".equals(reader.getLocalName())) {
                    result = unmarshallSemiStructuredLine(reader);
                }
            }

        }

        if (!reader.isEndElement()) {
            int _const = reader.next();
            System.out.println(_const);
        }
        System.out.println(result);
    }

    private BatchSemiStructuredLine unmarshallSemiStructuredLine(XMLStreamReader xsr) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(BatchSemiStructuredLine.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        JAXBElement<BatchSemiStructuredLine> jb = unmarshaller.unmarshal(xsr, BatchSemiStructuredLine.class);

        return jb.getValue();
    }

    private BatchStructuredLine unmarshallStructuredLine(XMLStreamReader xsr) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(BatchStructuredLine.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        JAXBElement<BatchStructuredLine> jb = unmarshaller.unmarshal(xsr, BatchStructuredLine.class);

        return jb.getValue();
    }
}
