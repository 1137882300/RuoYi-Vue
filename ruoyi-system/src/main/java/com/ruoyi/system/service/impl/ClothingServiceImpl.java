package com.ruoyi.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.BeanCopier;
import com.ruoyi.common.core.domain.request.ClothingListRQ;
import com.ruoyi.common.core.domain.request.ClothingUpsertRQ;
import com.ruoyi.common.core.domain.response.ClothingListVO;
import com.ruoyi.mapper.base.pojo.ClothingPO;
import com.ruoyi.mongo.model.ClothingMongoModel;
import com.ruoyi.mongo.repository.ClothingRepository;
import com.ruoyi.system.repository.IClothingRpService;
import com.ruoyi.system.service.IClothingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: juzi
 * @date: 2023/11/8
 * @desc:
 */
@Service
@RequiredArgsConstructor
public class ClothingServiceImpl implements IClothingService {


    private final IClothingRpService clothingRpService;
    private final ClothingRepository clothingRepository;

    @Override
    public List<ClothingListVO> list(ClothingListRQ rq) {
        return null;
    }

    @Override
    public void upsert(ClothingUpsertRQ rq) {
        ClothingPO clothingPO = new ClothingPO();
        clothingPO.setId(rq.getId());
        clothingPO.setSeason(1);
        clothingPO.setRemark("test ...");
        clothingPO.setTitle("title...");
        clothingRpService.saveOrUpdate(clothingPO);

        ClothingMongoModel clothingMongoModel = new ClothingMongoModel();
        BeanUtil.copyProperties(clothingPO, clothingMongoModel);
        clothingRepository.saveOrUpdate(clothingMongoModel);
    }
}
