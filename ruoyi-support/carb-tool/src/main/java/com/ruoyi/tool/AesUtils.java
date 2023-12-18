package com.ruoyi.tool;

import cn.hutool.core.util.HexUtil;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * AES 对称加密算法
 *
 * @author ashui
 * @date 2022/9/16
 */
public class AesUtils {


    /**
     * 解密
     *
     * @author ashui
     * @date 2022/9/24
     */
    public static String decrypt(String content, String slatKey, String vectorKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKey secretKey = new SecretKeySpec(slatKey.getBytes(), "AES");
        IvParameterSpec iv = new IvParameterSpec(vectorKey.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        byte[] encrypted = cipher.doFinal(HexUtil.decodeHex(content));
        return new String(encrypted);
    }

    /**
     * 加密-16进制加密
     *
     * @author ashui
     * @date 2022/9/24
     */
    public static String encrypt(String content, String slatKey, String vectorKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKey secretKey = new SecretKeySpec(slatKey.getBytes(), "AES");
        IvParameterSpec iv = new IvParameterSpec(vectorKey.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        byte[] encrypted = cipher.doFinal(content.getBytes());
        return HexUtil.encodeHexStr(encrypted);
    }


    public static String decryptForBase64(String content, String secretkey, String vectorKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKey secretKey = new SecretKeySpec(secretkey.getBytes(), "AES");
        IvParameterSpec iv = new IvParameterSpec(vectorKey.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        byte[] encrypted = cipher.doFinal(HexUtil.decodeHex(new String(Base64.getDecoder().decode(content))));
        return new String(encrypted);
    }
}
