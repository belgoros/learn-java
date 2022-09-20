package com.sca.basic;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Calendar;
import java.util.Date;

public class CertificateTestUtility {

    public static void main(String[] args) {
        System.out.println(generateHexCertificate(new BigInteger("70010123451")));
    }

    public static String generateHexCertificate(BigInteger serialNumber) {
        try {
            return Hex.encodeHexString(generateCertificate(serialNumber).getEncoded());
        } catch (CertificateEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static Certificate generateCertificate(BigInteger serialNumber) {
        try {

            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            // 4096 hurts performance, if we have multiple tests requiring cert generation, extract keypair to static var and initialize once. even 1024 seems a bit heavy.
            keyPairGenerator.initialize(1024, new SecureRandom());
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            long now = System.currentTimeMillis();
            Date startDate = new Date(now);

            X500Name dnName = new X500Name("cn=mock certificate");
            //BigInteger certSerialNumber = serialNumber;

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.YEAR, 1); // <-- 1 Yr validity

            Date endDate = calendar.getTime();

            String signatureAlgorithm = "SHA256WithRSA"; // <-- Use appropriate signature algorithm based on your keyPair algorithm.

            ContentSigner contentSigner = new JcaContentSignerBuilder(signatureAlgorithm).build(keyPair.getPrivate());

            JcaX509v3CertificateBuilder certBuilder = new JcaX509v3CertificateBuilder(dnName, serialNumber, startDate, endDate, dnName, keyPair.getPublic());

            // Extensions --------------------------

            // Basic Constraints
            BasicConstraints basicConstraints = new BasicConstraints(true); // <-- true for CA, false for EndEntity

            certBuilder.addExtension(new ASN1ObjectIdentifier("2.5.29.19"), true, basicConstraints); // Basic Constraints is usually marked as critical.

            // -------------------------------------

            return new JcaX509CertificateConverter().setProvider(new BouncyCastleProvider()).getCertificate(certBuilder.build(contentSigner));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
