package nl.vinyamar.jks;

import java.io.FileInputStream;
import java.security.*;
import java.security.cert.Certificate;

public class testJKS {

    public static void main(String[] args) throws Exception {
        FileInputStream is = new FileInputStream("/home/vf65fn/Projects/Javatests/resources/store.jks");

        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(is, "password".toCharArray());

        String alias = "1";

        Key key = keystore.getKey(alias, "password".toCharArray());
        if (key instanceof PrivateKey) {
            // Get certificate of public key
            Certificate cert = keystore.getCertificate(alias);

            // Get public key
            PublicKey publicKey = cert.getPublicKey();

        }
    }
}
