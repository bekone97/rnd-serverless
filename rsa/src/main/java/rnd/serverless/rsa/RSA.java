package rnd.serverless.rsa;

import rnd.serverless.api.Calculate;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class RSA implements Calculate {

    private final int keySize;

    public RSA() {
        this.keySize = 2048;
    }

    @Override
    public String calculate() {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(keySize);
            KeyPair keyPair = generator.generateKeyPair();
            return String.format("RSA PUBLIC KEY:\n%s\nRSA PRIVATE KEY:\n%s", keyPair.getPublic().toString(), keyPair.getPrivate().toString());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
