package com.ruoyi.mongo.model;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

/**
 * @author: juzi
 * @date: 2023/11/8
 * @desc:
 */
@Data
@Document(collection = "clothing")
public class ClothingMongoModel {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;

    private Long userId;
    private Long adminId;
    private Long brandId;
    private Long categoryId;

    private String title;
    private String remark;
    private String imgUrl;

    private Integer season;
    private Integer status;
    private Integer deleted;

    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private LocalDateTime updatedAt;

}
