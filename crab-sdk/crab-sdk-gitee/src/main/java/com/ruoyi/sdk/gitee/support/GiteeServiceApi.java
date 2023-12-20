package com.ruoyi.sdk.gitee.support;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author: juzi
 * @date: 2023/12/20
 * @desc:
 */
public interface GiteeServiceApi {

    String uploadImg(MultipartFile file, String message);

    List<String> getAllImg();


}
