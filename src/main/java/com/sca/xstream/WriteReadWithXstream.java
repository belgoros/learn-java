package com.sca.xstream;

import com.sca.files.Folders;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WriteReadWithXstream {

    /**
     * @param args
     * @see http://xstream.codehaus.org/index.html for more details
     */
    public static void main(String[] args) {
        XStream xstream = new XStream();
    /*
     * Now, to make the FILES_FOLDER outputted by XStream more concise, you can
	 * create aliases for your custom class names to FILES_FOLDER element names. This
	 * is the only type of mapping required to use XStream and even this is
	 * optional.
	 */
        xstream.alias("person", PersonForXstream.class);
        xstream.alias("phonenumber", PhoneForXstream.class);

        // Serializing an object to FILES_FOLDER
        PersonForXstream joe = new PersonForXstream("Joe", "Walnes");
        joe.setPhone(new PhoneForXstream(123, "1234-456"));
        joe.setFax(new PhoneForXstream(123, "9999-999"));

        // Now, to convert it to FILES_FOLDER, all you have to do is make a simple call
        // to XStream:
        String xml = xstream.toXML(joe);
        System.out.println(xml);
        try {
            writeToFile(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // To reconstruct an object, purely from the FILES_FOLDER:
        PersonForXstream person = (PersonForXstream) xstream.fromXML(xml);
        System.out.println("---------Reading from FILES_FOLDER String ----------\n");
        System.out.println("Person name: " + person.getFirstname() + " "
                + person.getLastname());
    }

    /**
     * Writes to an FILES_FOLDER file
     *
     * @param xml_body
     * @throws java.io.IOException
     */
    private static void writeToFile(String xml_body) throws IOException {
        File aFile = new File(Folders.INVOICE_XML);
        System.out.println("Done: " + aFile.getAbsolutePath());
        if (!aFile.exists()) {
            aFile.createNewFile();
        }
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(aFile, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.err);
        }
        FileChannel outChannel = output.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(xml_body.length());
        byte[] bytes = xml_body.getBytes();
        buf.put(bytes);
        buf.flip();
        try {
            outChannel.write(buf);
            output.close(); // Close the output stream & the channel
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
