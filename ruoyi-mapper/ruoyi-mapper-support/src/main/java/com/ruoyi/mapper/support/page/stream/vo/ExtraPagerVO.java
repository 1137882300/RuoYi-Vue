package com.ruoyi.mapper.support.page.stream.vo;


import java.util.List;

/**
 * 带扩展条件的office 分页对象
 *
 * @author ashui
 * @date 2021/9/9
 */
public class ExtraPagerVO<L extends List<?>, E> extends PagerVO<L> {


    //扩展信息
    private E extra;


    public ExtraPagerVO(L list, int recordCount, int pageSize) {
        super(list, recordCount, pageSize);
    }

    public ExtraPagerVO(L list, int recordCount, int pageSize, E extra) {
        super(list, recordCount, pageSize);
        this.extra = extra;
    }


    public E getExtra() {
        return extra;
    }

    public void setExtra(E extra) {
        this.extra = extra;
    }


    @Override
    public String toString() {
        return super.toString() + ",OfficeExPagerVO{" +
                ", extra=" + extra +
                "} " + super.toString();
    }
}
