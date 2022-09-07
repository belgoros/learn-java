package com.sca.basic;

import java.nio.charset.StandardCharsets;

/**
 * In a Spring Boot app, you can use <code>org.springframework.security.crypto.codec.Hex</code> class
 * and call its <code>encode</code> method, e.g.:
 * <code>
 *     private static String encodeStringToHex(String hashToSign) {
 *         char[] chars = Hex.encode(hashToSign.getBytes(StandardCharsets.UTF_8));
 *
 *         return String.valueOf(chars);
 *     }
 * </code>
 */
public class HexConverter {
    private final String strToConvert;

    public HexConverter(String strToConvert) {
        this.strToConvert = strToConvert;
    }

    public static void main(String[] args) {
        HexConverter converter = new HexConverter("azerty");
        String hexString = converter.encodeHexString();
        System.out.println("converted to HEX: " + hexString);
    }

    public String encodeHexString() {
        StringBuffer hexStringBuffer = new StringBuffer();
        byte[] byteArray = getBytes();
        for (int i = 0; i < byteArray.length; i++) {
            hexStringBuffer.append(byteToHex(byteArray[i]));
        }
        return hexStringBuffer.toString();
    }

    private byte[] getBytes() {
        return this.strToConvert.getBytes(StandardCharsets.UTF_8);
    }

    private String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }
}
