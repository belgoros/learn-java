package com.sca.files;

import java.io.File;
import java.net.URL;

/**
 * Created by ZFTC0418 on 09/03/2015.
 */
public class RenameWithClassLoader {

    public static void main(final String[] args) {
        RenameWithClassLoader runner = new RenameWithClassLoader();

        URL resource = runner.getClass().getResource("/entities.xml");
        System.out.println(resource.getFile());

        File file = new File(resource.getFile());
        boolean resultat = file.renameTo(new File(file.getParent(), "toto_yoyo.xml"));
        System.out.println("renamed: " + resultat);
    }
}
