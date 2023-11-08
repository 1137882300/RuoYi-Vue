package com.ruoyi.mapper.base.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: juzi
 * @date: 2023/11/8
 * @desc:
 */
@Data
@TableName("clothing")
public class ClothingPO {

    @TableId(type = IdType.AUTO)
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
