package com.ruoyi.mapper.support.page.stream.vo;


import java.util.List;

/**
 * office 分页对象
 *
 * @author ashui
 * @date 2021/9/9
 */
public class PagerVO<L extends List<?>> {

    //数据列表
    private L list;

    //分页信息
    private BasePagerVO pager;


    public L getList() {
        return list;
    }

    public void setList(L list) {
        this.list = list;
    }

    public BasePagerVO getPager() {
        return pager;
    }

    public void setPager(BasePagerVO pager) {
        this.pager = pager;
    }

    public PagerVO(){

    }

    public PagerVO(L list, int recordCount, int pageSize) {
        this.list = list;
        BasePagerVO pagerVO = new BasePagerVO();
        pagerVO.setPageSize(pageSize);
        pagerVO.setTotalPage(computeTotalPage(recordCount, pageSize));
        pagerVO.setTotalRow(recordCount);
        this.pager = pagerVO;
    }

    private int computeTotalPage(int recordCount, int pageSize) {
        if(pageSize==0){
            return 0;
        }
        if (recordCount % pageSize == 0) {
            return recordCount / pageSize;
        } else {
            return recordCount / pageSize + 1;
        }
    }

    @Override
    public String toString() {
        return "OfficePagerVO{" +
                "list=" + list +
                ", pager=" + pager +
                '}';
    }
}
