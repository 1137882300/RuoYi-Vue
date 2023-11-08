package com.ruoyi.mapper.support.page.stream;


import com.ruoyi.mapper.support.page.PageSupportAdapter;

import java.util.List;

/**
 * 定义分页器
 *
 * @author ashui
 * @date 2021/9/9
 */
public class PageStartStreamBuilder {

    private int pageNum;
    private int pageSize;
    private int total;

    public PageStartStreamBuilder(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public PageStartStreamBuilder() {
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotal() {
        return total;
    }


    public <T> PageEndStreamBuilder<T> stream(PageDataSupplier<List<T>> supplier) {
        List<T> list;
        try {
            PageSupportAdapter.getInstance().startPage(this.pageNum, this.pageSize);
            list = supplier.get();
            this.total = (int) PageSupportAdapter.getInstance().getRecordTotal(list);
        } finally {
            PageSupportAdapter.getInstance().endPage();
        }

        return new PageEndStreamBuilder<>(list, this);
    }

}
