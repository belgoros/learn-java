package com.sca.javax.json;

import com.jayway.jsonpath.JsonPath;
import com.sca.files.Folders;

import java.io.File;
import java.io.IOException;

/**
 * Created by ZFTC0418 on 23/02/2015.
 */
public class JsonPathExample {

    public static void main(String[] args) {
        JsonPathExample runner = new JsonPathExample();
        runner.readJson();

    }

    public void readJson() {
        File outputFile = new File(Folders.FILES_FOLDER, "multi_devs.json");

        String jsonPath = "$.data.*";

        Object result = null;
        try {
            result = JsonPath.read(outputFile, jsonPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);

    }
}
