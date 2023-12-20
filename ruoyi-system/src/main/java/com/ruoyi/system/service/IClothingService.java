package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.request.ClothingListRQ;
import com.ruoyi.common.core.domain.request.ClothingUpsertRQ;
import com.ruoyi.common.core.domain.response.ClothingListVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author: juzi
 * @date: 2023/11/8
 * @desc:
 */
public interface IClothingService {


    List<ClothingListVO> list(ClothingListRQ rq);

    void upsert(ClothingUpsertRQ rq, MultipartFile file, String username);
}
