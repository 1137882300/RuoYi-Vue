package com.ruoyi.sdk.gitee.config;


/**
 * @author: juzi
 * @date: 2023/12/20
 * @desc:
 */
public class GiteeConfig {

    //需AES解密
    public static final String TOKEN = "0M/okMo9x4xKwlma1PZityqPT5uUzbUBzUf57M+f/7Lv+WY51+GjdSL3bJsev/E1";
    public static final String OWNER = "coderzane";
    public static final String REPO = "images";
    public static final String PATH = "images";
    public static final String BRANCH = "master";
    public static final String SHA = "SHA";

    //大写表示要替换的值
    public static final String upload_url = "https://gitee.com/api/v5/repos/OWNER/REPO/contents/PATH";
    public static final String get_url = "https://gitee.com/api/v5/repos/coderzane/images/git/gitee/trees/SHA";

}
