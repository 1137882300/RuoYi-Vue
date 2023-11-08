package com.ruoyi.web.controller.home;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.base.ApiResponse;
import com.ruoyi.common.core.domain.request.ClothingListRQ;
import com.ruoyi.common.core.domain.request.ClothingUpsertRQ;
import com.ruoyi.common.core.domain.response.ClothingListVO;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.service.IClothingService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: juzi
 * @date: 2023/11/8
 * @desc:
 */
@RestController
@AllArgsConstructor
@RequestMapping("/home/clothing")
public class ClothingController extends BaseController {

    private final IClothingService clothingService;

    @PostMapping("/list")
    @PreAuthorize("@ss.hasPermi('home:clothing:list')")
    public ApiResponse<List<ClothingListVO>> list(@RequestBody ClothingListRQ rq) {
        return ApiResponse.ok(clothingService.list(rq));
    }

    @PostMapping("/upsert")
    @PreAuthorize("@ss.hasPermi('home:clothing:upsert')")
    @Log(title = "衣着管理", businessType = BusinessType.UPSERT)
    public ApiResponse<Void> upsert(@RequestBody @Validated ClothingUpsertRQ rq) {
        clothingService.upsert(rq);
        return ApiResponse.ok();
    }

}
