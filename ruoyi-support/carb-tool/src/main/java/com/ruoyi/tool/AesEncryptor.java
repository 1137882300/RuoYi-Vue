package com.ruoyi.tool;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.symmetric.AES;

/**
 * @author 美年达
 * @date 2022/9/27
 */
public class AesEncryptor implements Encryptor {

    private final AES aes;

    public AesEncryptor(AES aes) {
        this.aes = aes;
    }

    /**
     * 加密
     */
    @Override
    public String encrypt(String content) {
        if (StrUtil.isBlank(content)) {
            return StrUtil.EMPTY;
        }
        return aes.encryptBase64(content);
    }

    /**
     * 解密
     */
    @Override
    public String decrypt(String content) {
        if (StrUtil.isBlank(content)) {
            return StrUtil.EMPTY;
        }
        return aes.decryptStr(content);
    }



}
