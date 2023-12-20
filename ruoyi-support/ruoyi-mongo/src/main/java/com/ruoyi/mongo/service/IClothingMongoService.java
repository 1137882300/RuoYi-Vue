package com.ruoyi.mongo.service;

import com.ruoyi.mongo.model.ClothingMongoModel;
import org.springframework.scheduling.annotation.Async;

/**
 * @author: juzi
 * @date: 2023/12/20
 * @desc:
 */
public interface IClothingMongoService {

    @Async
    void saveOrUpdate(ClothingMongoModel clothingMongoModel);
}
