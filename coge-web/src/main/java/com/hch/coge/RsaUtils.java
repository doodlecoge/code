package com.hch.coge;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created with IntelliJ IDEA.
 * User: huaiwang
 * Date: 7/24/13
 * Time: 10:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class RsaUtils {

    public static String DefaultPrivateKeyString = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAI9eMbRdkC+0g79hVGRTZed63W/Fd/+reGvgOt2i0V1VPKqvlAdihflIN/ZZh3yopZWhp1e3GXHaJkj57Bowb0VtCsXhweNruU43dD2O6pv1uVDe0hIv6jiPv+V90vd+USya6FAqAFMmnD3dAaMGEtbVA4QleV+Bb9iR1bEGkKQVAgMBAAECgYBFbW8SklC12WwHrOGKaBysOYKskusmo+oAC6lWFXfgA9wKKFa+MMcCTifTo82J3724NX1ta9zllqf9pRHiKNxo/Vks99ydMr0STA94h+qmodgEYA9GH6/krwOYN+YLkLH/VMYVxUexfIZhl57H3BdKXkkS92rVkHFK35pKYgR3IQJBAOKEzVcVPhCRs8IGVUHzmtBoR7N/tRTPbGjq9jhKiwPvZp0QwG44fYTPbR3q9RHPJLShiHIYJwGDP1X1PY83Jf0CQQCiBvTY1xUMFjItNKHILyImKIRdeQQSB6tWuBiEx1Iq+xjqOLD++BbGDyKzMiQw4aVzH4wTSiSnhdbo3X2mxcX5AkEAjzllFHDMA3H89OtIMSE0fB3TaD2RY40bgOM/t6v6ZgyTFzCmW4rAYp884TPUrOQK02NngKygzSYNf+5GdC1siQJBAKH9dnn8v0wwPMY5Yq3zgZ7Iz11sigdEp6axs8G8TYgvNv+k4kBn5MzrgPPLY6eDUZjBp5f5fqAGDZEPMHq2LHECQA7+xzHDBmS2F6O1kwwAOwiTms04OS8lSz7QWThIy1AmvKGCKqp/E1SUMaR/VS+Agfr4wltLiBzUbJ0mXsXuSss=";
    public static String DefaultPublicKeyString = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCPXjG0XZAvtIO/YVRkU2Xnet1vxXf/q3hr4DrdotFdVTyqr5QHYoX5SDf2WYd8qKWVoadXtxlx2iZI+ewaMG9FbQrF4cHja7lON3Q9juqb9blQ3tISL+o4j7/lfdL3flEsmuhQKgBTJpw93QGjBhLW1QOEJXlfgW/YkdWxBpCkFQIDAQAB";

    public static KeyPair generateRsaKeyPair() throws NoSuchAlgorithmException {
        return KeyPairGenerator.getInstance("RSA").generateKeyPair();
    }


    public static PrivateKey getPrivateKey(String b64) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] bytes = Base64.decodeBase64(b64);


        PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(
                new PKCS8EncodedKeySpec(bytes)
        );

        return privateKey;
    }

    public static String b64EncodePrivateKey(PrivateKey privateKey) {
        return Base64.encodeBase64String(privateKey.getEncoded());
    }

    public static PublicKey getPublicKey(String b64) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] bytes = Base64.decodeBase64(b64);


        PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(
                new X509EncodedKeySpec(bytes)
        );

        return publicKey;
    }

    public static String b64EncodePublicKey(PublicKey publicKey) {
        return Base64.encodeBase64String(publicKey.getEncoded());
    }


    public static String decrypt(String b64EncodedString) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {
        PrivateKey privateKey = getPrivateKey(DefaultPrivateKeyString);
        return decrypt(privateKey, b64EncodedString);
    }

    public static String decrypt(PrivateKey privateKey, String b64EncodedString) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException {
        byte[] enbytes = Base64.decodeBase64(b64EncodedString);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] debytes = cipher.doFinal(enbytes);
        return new String(debytes);
    }

    public static String decrypt(PublicKey publicKey, String b64EncodedString) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException {
        byte[] enbytes = Base64.decodeBase64(b64EncodedString);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] debytes = cipher.doFinal(enbytes);
        return new String(debytes);
    }


    public static String encrypt(String rawString) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {
        PublicKey publicKey = getPublicKey(DefaultPublicKeyString);
        return encrypt(publicKey, rawString);
    }

    public static String encrypt(String publicKeyString, String rawString) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {
        PublicKey publicKey = getPublicKey(publicKeyString);
        return encrypt(publicKey, rawString);
    }

    public static String encrypt(PublicKey publicKey, String rawString) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] enbytes = cipher.doFinal(rawString.getBytes());
        return Base64.encodeBase64String(enbytes);
    }

    public static String encrypt(PrivateKey privateKey, String rawString) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] enbytes = cipher.doFinal(rawString.getBytes());
        return Base64.encodeBase64String(enbytes);
    }
}
