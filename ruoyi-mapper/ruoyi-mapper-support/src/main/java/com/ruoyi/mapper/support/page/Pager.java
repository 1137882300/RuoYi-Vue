package com.ruoyi.mapper.support.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 分页操作类
 * @author ashui
 * @date 2022/4/13
 */
public interface Pager {

    void startPage(int page, int pageSize);

    long getRecordTotal(List<?> list);

    void endPage();

    Page<?> getPage();

}
