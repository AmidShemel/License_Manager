package sample;

import java.util.Base64;

public class Encryptor {

    private int iterOfCrypt = 9;

    public String encrypt (String encryptData) {

        String encryptedData = Base64.getEncoder().encodeToString(encryptData.getBytes());
        for (int i = 0; i < iterOfCrypt; i++) {
            encryptedData = Base64.getEncoder().encodeToString(encryptedData.getBytes());
        }
        return encryptedData;
    }

    public String decrypt(String decryptData) {

        String decrypted = "";
        try {
            decrypted = new String(Base64.getDecoder().decode(decryptData));
            for (int i = 0; i < iterOfCrypt; i++) {
                decrypted = new String(Base64.getDecoder().decode(decrypted));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error: 5");
        }
        return decrypted;
    }

}
