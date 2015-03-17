package nl.vinyamar.jks;


import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;

public class TestJKS {

    public static void main(String[] args) throws Exception {
        FileInputStream is = new FileInputStream(new ClassPathResource("store.jks").getFile());

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
