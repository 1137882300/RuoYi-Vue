package com.ruoyi.mapper.support.page.stream.vo;

import java.util.List;

/**
 * 带刷选条件的office 分页对象
 *
 * @author ashui
 * @date 2021/9/9
 */
public class FilterAndExtraPagerVO<L extends List<?>, F, E> extends FilterPagerVO<L, F> {

    //刷选条件
    private F filter;

    //扩展信息
    private E extra;


    public FilterAndExtraPagerVO(L list, int recordCount, int pageSize) {
        super(list, recordCount, pageSize);
    }

    public FilterAndExtraPagerVO(L list, int recordCount, int pageSize, F filter, E extra) {
        super(list, recordCount, pageSize);
        this.filter = filter;
        this.extra = extra;
    }

    @Override
    public F getFilter() {
        return filter;
    }

    public void setFilter(F filter) {
        this.filter = filter;
    }


    public E getExtra() {
        return extra;
    }

    public void setExtra(E extra) {
        this.extra = extra;
    }


    @Override
    public String toString() {
        return super.toString() + ",OfficeFilterPagerVO{" +
                "filter=" + filter +
                ", extra=" + extra +
                "} " + super.toString();
    }
}
