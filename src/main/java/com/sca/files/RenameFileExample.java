package com.sca.files;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by ZFTC0418 on 12/02/2015.
 */
public class RenameFileExample {

    public static void main(String[] args) {
        boolean isRenamed = false;
        File testFile = new File(Folders.DEVELOPERS_JSON);
        if (testFile.isFile() && testFile.exists()) {
            isRenamed = testFile.renameTo(new File(testFile.getParent(), "renamed_developers.json"));
        }

        System.out.println("First test: File renamed: " + isRenamed);

        RenameFileExample example = new RenameFileExample();
        try {
            File cfgFile = example.initFile("example_to_rename.cfg");
            System.out.println("renamed: " + example.renameConfigFile(cfgFile));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


    }

    protected boolean renameConfigFile(File cfgFile) {
        String newName = buildNewFileName(cfgFile);

        boolean isRenamed = cfgFile.renameTo(new File(cfgFile.getParent(), newName));

        return isRenamed;
    }

    protected File initFile(String fileName) throws URISyntaxException {
        StringBuilder builder = new StringBuilder();
        builder.append("/");
        builder.append(fileName);
        URL url = getClass().getResource(builder.toString());

        File file = new File(url.getFile());

        return file;
    }

    protected String buildNewFileName(File cfgFile) {
        StringBuilder builder = new StringBuilder();
        builder.append(cfgFile.getName());
        builder.append(".done");

        return builder.toString();
    }
}
