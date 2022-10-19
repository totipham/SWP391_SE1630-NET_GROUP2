/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 * HashUtility
 * Record of change:
 *      DATE:Oct 1, 2022            
 *      VERSION: 1.0
 *      AUTHOR: DucPTMHE160517          
 */
package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The class contains method generate generatePasswordHash, getSalt, toHex,
 * validatePassword, fromHex To support encryption password from input password
 * of user with strong encryption method is PBKDF2 The method will throw an
 * object of <code>java.security.NoSuchAlgorithmException</code>
 * <code>java.security.InvalidKeySpecException</code> class if there is any
 * error occurring when encryption, decryption password
 * <p>
 * Bugs: Still not have yet
 *
 * @author DucPTMHE160517
 */
public class HashUtility {

    /**
     * Encryption password with input password as parameter, use PBKDF2 to
     * encryption.
     *
     * @param password password that user input from login, sign-up form. It is
     * a <code>java.lang.String</code> object
     * @return
     *
     */
    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    private String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for (int j = 0; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    // Change this to something else.
    private String SALT = "hostalpy_salt";

    // A password hashing method.
    public String hashString(String in) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(SALT.getBytes());
            md.update(in.getBytes());
            byte[] out = md.digest();
            return bytesToHex(out);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
