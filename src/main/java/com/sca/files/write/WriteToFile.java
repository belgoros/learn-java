package com.sca.files.write;

import com.sca.files.Folders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WriteToFile {

    public static void main(String[] args) throws IOException {
        String xml_body = "some text - just for testing file writing";
        File dirXML = new File(Folders.FILES_FOLDER);
        dirXML.mkdir();
        File aFile = new File(dirXML, Folders.SIMPLE_FILE);
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
