package com.ruoyi.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.BeanCopier;
import cn.hutool.core.bean.copier.CopyOptions;
import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.domain.request.ClothingListRQ;
import com.ruoyi.common.core.domain.request.ClothingUpsertRQ;
import com.ruoyi.common.core.domain.response.ClothingListVO;
import com.ruoyi.mapper.base.pojo.ClothingPO;
import com.ruoyi.mongo.model.ClothingMongoModel;
import com.ruoyi.mongo.repository.ClothingRepository;
import com.ruoyi.system.repository.IClothingRpService;
import com.ruoyi.system.service.IClothingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    private final ClothingRepository clothingRepository;

    @Override
    public List<ClothingListVO> list(ClothingListRQ rq) {
        List<ClothingPO> list = clothingRpService.list();
        return BeanUtil.copyToList(list, ClothingListVO.class, CopyOptions.create().ignoreError().ignoreNullValue());
    }

    @Override
    public void upsert(ClothingUpsertRQ rq) {
        ClothingPO clothingPO = new ClothingPO();
        BeanUtil.copyProperties(rq, clothingPO, CopyOptions.create().ignoreError().ignoreNullValue());
        clothingRpService.saveOrUpdate(clothingPO);

        ClothingMongoModel clothingMongoModel = new ClothingMongoModel();
        try {
            BeanUtil.copyProperties(clothingPO, clothingMongoModel, CopyOptions.create().setIgnoreProperties("id").ignoreError().ignoreNullValue());
            clothingRepository.saveOrUpdate(clothingMongoModel);
        } catch (Exception e) {
            log.error("error, clothingMongoModel:{}", JSON.toJSONString(clothingMongoModel));
        }

    }
}
