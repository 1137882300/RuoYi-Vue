package com.ruoyi.sdk.gitee;

import com.ruoyi.sdk.gitee.support.GiteeServiceApi;
import com.ruoyi.sdk.gitee.support.impl.GiteeServiceApiImpl;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author: juzi
 * @date: 2023/12/20
 * @desc:
 */
public class GiteeUtil {

    private static class SingletonInstance {
        private static final GiteeServiceApi API;

        static {
            API = new GiteeServiceApiImpl();
        }
    }

    private static GiteeServiceApi getApi() {
        return SingletonInstance.API;
    }

    public static String uploadImg(MultipartFile file, String message) {
        return getApi().uploadImg(file, message);
    }


    public static List<String> getAllImg() {
        return getApi().getAllImg();
    }

}
