package com.ruoyi.mapper.support.page.stream;


import com.ruoyi.mapper.support.page.stream.vo.ExtraPagerVO;
import com.ruoyi.mapper.support.page.stream.vo.FilterAndExtraPagerVO;
import com.ruoyi.mapper.support.page.stream.vo.FilterPagerVO;
import com.ruoyi.mapper.support.page.stream.vo.PagerVO;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 流式分页类
 *
 * @author ashui
 * @date 2021/9/9
 */
public class PageEndStreamBuilder<T> {

    private final PageStartStreamBuilder startStream;
    private final List<T> list;
    private int total;
    private int pageSize;


    public PageEndStreamBuilder(List<T> list, PageStartStreamBuilder startStream) {
        this.list = list;
        this.startStream = startStream;
    }

    protected int getPageSize() {
        if (pageSize > 0) {
            return pageSize;
        }
        return startStream.getPageSize();
    }

    protected int getTotal() {
        if (total > 0) {
            return total;
        }
        return startStream.getTotal();
    }


    /**
     * 返回PagerWrap
     *
     * @author ashui
     * @date 2021/9/9
     */
    public PageEndStreamBuilder<T> recordCount(int total) {
        this.total = total;
        return this;
    }

    /**
     * 返回PagerWrap
     *
     * @author ashui
     * @date 2021/9/9
     */
    public PageEndStreamBuilder<T> pageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }


    /**
     * 组装数据
     *
     * @author ashui
     * @date 2021/9/9
     */
    public <R> PageEndStreamBuilder<R> map(Function<T, R> mapper) {
        List<R> rtList = Collections.emptyList();
        if (list != null) {
            rtList = this.list.stream().map(mapper).collect(Collectors.toList());
        }
        return new PageEndStreamBuilder<>(rtList, startStream);
    }

    public PageEndStreamBuilder<T> consumer(Consumer<List<T>> consumer) {
        if (this.list != null && this.list.size() > 0) {
            consumer.accept(this.list);
        }
        return this;
    }

    /**
     * 返回list
     *
     * @author ashui
     * @date 2021/9/9
     */
    public List<T> list() {
        return list;
    }


    /**
     * 返回OfficePagerVO
     *
     * @author ashui
     * @date 2021/9/9
     */
    public PagerVO<List<T>> pagerVO() {
        return new PagerVO<>(list, getTotal(), getPageSize());
    }

    /**
     * 返回OfficeFilterPagerVO
     *
     * @author ashui
     * @date 2021/9/9
     */
    public <F> FilterPagerVO<List<T>, F> filterPagerVO(F filter) {
        return new FilterPagerVO<>(list, getTotal(), getPageSize(), filter);
    }

    /**
     * OfficeFilterExPagerVO
     *
     * @author ashui
     * @date 2021/9/9
     */
    public <F, E> FilterAndExtraPagerVO<List<T>, F, E> filterAndextraPagerVO(F filter, E extra) {
        return new FilterAndExtraPagerVO<>(list, getTotal(), getPageSize(), filter, extra);
    }


    /**
     * OfficeExPagerVO
     *
     * @author ashui
     * @date 2021/9/9
     */
    public <F, E> ExtraPagerVO<List<T>, E> extraPagerVO(E extra) {
        return new ExtraPagerVO<>(list, getTotal(), getPageSize(), extra);
    }


}
