package com.ruoyi.mongo.repository;

import com.ruoyi.mongo.model.ClothingMongoModel;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


@Repository
public class ClothingRepository {

    @Resource
    private MongoTemplate mongoTemplate;

    public void saveOrUpdate(ClothingMongoModel model) {
        mongoTemplate.save(model);
    }


}
