package com.ruoyi.common.core.domain.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author: juzi
 * @date: 2023/11/8
 * @desc:
 */
@Data
public class ClothingUpsertRQ {

    private Long id;

    private Long brandId;

    @NotNull(message = "类目不能为空")
    private Long categoryId;

    @NotNull(message = "标题不能为空")
    private String title;

    private String remark;

    @NotNull(message = "季节不能为空")
    private Integer season;

}
