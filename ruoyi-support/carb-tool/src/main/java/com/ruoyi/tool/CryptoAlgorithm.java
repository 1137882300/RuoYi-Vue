package com.ruoyi.tool;

import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 加密算法
 *
 * @author ashui
 * @date 2022/9/25
 */
public class CryptoAlgorithm {

    private static final String key = "2dbb558d82691242";
    private static final String iv = "13cec004f8a341dd";

    /**
     * aes  解密
     *
     * @author ashui
     * @date 2022/9/24
     */
    @SneakyThrows
    public static String decryptWithAes(String content) {
        return AesUtils.decrypt(content, key, iv);


    }

    public static String decryptWithAesForBase64(String content) throws Exception {
        return AesUtils.decryptForBase64(content, key, iv);
    }

    /**
     * aes 加密
     *
     * @author ashui
     * @date 2022/9/24
     */
    @SneakyThrows
    public static String encryptWithAes(String content) {
        return AesUtils.encrypt(content, key, iv);
    }


    /**
     * md5 加密 密码 算法
     *
     * @author ashui
     * @date 2022/9/24
     */
    public static String encryptPassword(String content) {
        return MD5Utils.MD5(content + key);
    }


    public static void main(String[] args) {
        String s = encryptWithAes("mongodb+srv://923828430:ZIhan1123@mongo-cluster0.uhhdjbf.mongodb.net/crab?retryWrites=true&w=majority");
        System.out.println(s);

        String s1 = decryptWithAes(s);
        System.out.println(s1);

    }


}
