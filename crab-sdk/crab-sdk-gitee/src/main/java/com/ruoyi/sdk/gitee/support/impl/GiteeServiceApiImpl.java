package com.ruoyi.sdk.gitee.support.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ruoyi.sdk.gitee.config.GiteeConfig;
import com.ruoyi.sdk.gitee.support.GiteeServiceApi;
import com.ruoyi.tool.AesEncryptor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: juzi
 * @date: 2023/12/20
 * @desc:
 */
@Slf4j
public class GiteeServiceApiImpl implements GiteeServiceApi {

    @SneakyThrows
    @Override
    public String uploadImg(MultipartFile file, String message) {
        if (ObjectUtils.isEmpty(file)) {
            log.error("上传文件为空");
            return null;
        }
        String fileName = file.getOriginalFilename();
        if (StringUtils.isBlank(fileName)) {
            log.error("文件名为空");
            return null;
        }
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        byte[] bytes = file.getBytes();
        String fileBase64 = Base64.getEncoder().encodeToString(bytes);

        JSONObject param = new JSONObject();
        param.put("access_token", AesEncryptor.ENCRYPTOR.decrypt(GiteeConfig.TOKEN));
        param.put("content", fileBase64);
        param.put("message", message);// 提交描述
        param.put("branch", GiteeConfig.BRANCH);

        String url = GiteeConfig.upload_url
                .replace("OWNER", GiteeConfig.OWNER)
                .replace("REPO", GiteeConfig.REPO)
                .replace("PATH", GiteeConfig.PATH);

        url = url + System.currentTimeMillis() + suffixName;
        log.info("url：{}", url);

        HttpResponse response = HttpRequest.post(url)
                .body(param.toString())
                .execute();
        if (!response.isOk()) {
            log.error("上传文件失败，url:{},错误信息：{}", url, response.body());
            return null;
        }
        try {
            JSONObject jsonObject = JSONObject.parseObject(response.body());
            JSONObject content = jsonObject.getJSONObject("content");
            return content.getString("download_url");
        } catch (Exception e) {
            log.error("上传文件失败，url:{}", url, e);
            return null;
        }
    }

    @Override
    public List<String> getAllImg() {
        String url = String.format("https://gitee.com/api/v5/repos/coderzane/images/git/gitee/trees/%s", GiteeConfig.BRANCH);
        JSONArray tree = this.HttpRequest(url);
        Optional<String> first = tree.stream().filter(x -> {
            JSONObject js = (JSONObject) x;
            String path = js.getString("path");
            return path.equalsIgnoreCase("images");
        }).map(x -> {
            JSONObject js = (JSONObject) x;
            return js.getString("sha");
        }).findFirst();

        if (!first.isPresent()) {
            return null;
        }
        String url2 = String.format("https://gitee.com/api/v5/repos/coderzane/images/git/gitee/trees/%s", first.get());
        JSONArray array = HttpRequest(url2);
        List<String> pathList = array.stream().map(x -> {
            JSONObject js = (JSONObject) x;
            return js.getString("path");
        }).collect(Collectors.toList());
        List<String> result = Lists.newArrayList();
        String prefix = "https://gitee.com/coderzane/images/raw/master/images/";
        pathList.forEach(x -> result.add(prefix + x));
        return result;
    }

    private JSONArray HttpRequest(String url) {
        HttpResponse response = HttpRequest.get(url)
                .execute();
        log.info("响应结果：{}", response.body());
        JSONObject jsonObject = JSONObject.parseObject(response.body());
        return jsonObject.getJSONArray("tree");
    }

}
