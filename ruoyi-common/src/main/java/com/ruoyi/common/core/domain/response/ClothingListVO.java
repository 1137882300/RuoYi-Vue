package com.ruoyi.common.core.domain.response;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: juzi
 * @date: 2023/11/8
 * @desc:
 */
@Data
public class ClothingListVO {
    private Long id;
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
