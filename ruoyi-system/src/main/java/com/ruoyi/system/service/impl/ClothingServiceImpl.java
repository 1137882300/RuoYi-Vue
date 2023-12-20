package com.ruoyi.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.domain.request.ClothingListRQ;
import com.ruoyi.common.core.domain.request.ClothingUpsertRQ;
import com.ruoyi.common.core.domain.response.ClothingListVO;
import com.ruoyi.common.exception.ApiException;
import com.ruoyi.mapper.base.pojo.ClothingPO;
import com.ruoyi.mongo.model.ClothingMongoModel;
import com.ruoyi.mongo.service.IClothingMongoService;
import com.ruoyi.sdk.gitee.GiteeUtil;
import com.ruoyi.system.repository.IClothingRpService;
import com.ruoyi.system.service.IClothingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author: juzi
 * @date: 2023/11/8
 * @desc:
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ClothingServiceImpl implements IClothingService {


    private final IClothingRpService clothingRpService;
    private final IClothingMongoService clothingMongoService;

    @Override
    public List<ClothingListVO> list(ClothingListRQ rq) {
        List<ClothingPO> list = clothingRpService.list();
        return BeanUtil.copyToList(list, ClothingListVO.class, CopyOptions.create().ignoreError().ignoreNullValue());
    }

    @Override
    public void upsert(ClothingUpsertRQ rq, MultipartFile file) {

        //上传图片
        String imgUrl = GiteeUtil.uploadImg(file, "上传图片");
        if (StringUtils.isBlank(imgUrl)) {
            ApiException.throwException("上传图片失败");
        }

        //保存数据
        ClothingPO clothingPO = new ClothingPO();
        BeanUtil.copyProperties(rq, clothingPO, CopyOptions.create().ignoreError().ignoreNullValue());
        clothingPO.setImgUrl(imgUrl);
        clothingRpService.saveOrUpdate(clothingPO);

        ClothingMongoModel clothingMongoModel = new ClothingMongoModel();
        try {
            BeanUtil.copyProperties(clothingPO, clothingMongoModel, CopyOptions.create().setIgnoreProperties("id").ignoreError().ignoreNullValue());
            clothingMongoService.saveOrUpdate(clothingMongoModel);
        } catch (Exception e) {
            log.error("error, clothingMongoModel:{}", JSON.toJSONString(clothingMongoModel));
        }

    }
}
