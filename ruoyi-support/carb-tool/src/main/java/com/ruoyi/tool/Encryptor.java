package com.ruoyi.tool;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.extra.spring.SpringUtil;
import org.springframework.core.env.Environment;


/**
 * @author 美年达
 * @date 2022/9/27
 */
public interface Encryptor {

    Encryptor ENCRYPTOR = new AesEncryptor(SecureUtil.aes(StrUtil.bytes(SpringUtil.getBean(Environment.class).getProperty("crab.aes.key"))));

    /**
     * 加密
     */
    String encrypt(String content);

    /**
     * 解密
     */
    String decrypt(String content);

}
