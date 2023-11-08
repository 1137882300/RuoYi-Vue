package com.ruoyi.mapper.support.page.stream.vo;


import java.util.List;

/**
 *  带刷选条件的office 分页对象
 * @author ashui
 * @date 2021/9/9
 */
public class FilterPagerVO< L extends List<?>,F> extends PagerVO<L> {

    //刷选条件
    private F filter;

    public F getFilter() {
        return filter;
    }

    public FilterPagerVO(L list, int recordCount, int pageSize) {
        super(list, recordCount, pageSize);
    }

    public FilterPagerVO(L list, int recordCount, int pageSize, F filter) {
        super(list, recordCount, pageSize);
        this.filter = filter;
    }



    @Override
    public String toString() {
        return super.toString()+ ",OfficeFilterPagerVO{" +
                "filter=" + filter +
                "} " + super.toString();
    }
}
