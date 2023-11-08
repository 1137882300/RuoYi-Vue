package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.domain.request.ClothingListRQ;
import com.ruoyi.common.core.domain.request.ClothingUpsertRQ;
import com.ruoyi.common.core.domain.response.ClothingListVO;
import com.ruoyi.mapper.base.pojo.ClothingPO;
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
    }
}
