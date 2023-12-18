package com.ruoyi.tool;

import cn.hutool.crypto.digest.DigestUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * md5 加密工具类
 *
 * @author ashui
 * @date 2022/9/16
 */
public class MD5Utils {

    /**
     * md5 加密
     *
     * @author ashui
     * @date 2022/9/16
     */
    public static String MD5(String str) {
        try {
            return DigestUtil.md5Hex(str);
        } catch (Exception e) {
            throw e;
        }
    }


}
