package com.sca.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class Base64ImageEncoder {
    public static void main(String[] args) {
        try (InputStream in = Base64ImageEncoder.class.getResourceAsStream("/warning.png")) {
            assert in != null;
            byte[] bytes = in.readAllBytes();
            String base64 = Base64.getEncoder().encodeToString(bytes);
            System.out.println(base64);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
