package com.ruoyi.mongo.service.impl;

import com.ruoyi.mongo.model.ClothingMongoModel;
import com.ruoyi.mongo.repository.ClothingRepository;
import com.ruoyi.mongo.service.IClothingMongoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author: juzi
 * @date: 2023/12/20
 * @desc:
 */
@Service
@RequiredArgsConstructor
public class ClothingMongoServiceImpl implements IClothingMongoService {

    private final ClothingRepository clothingRepository;

    @Override
    public void saveOrUpdate(ClothingMongoModel clothingMongoModel) {
        clothingRepository.saveOrUpdate(clothingMongoModel);
    }
}
