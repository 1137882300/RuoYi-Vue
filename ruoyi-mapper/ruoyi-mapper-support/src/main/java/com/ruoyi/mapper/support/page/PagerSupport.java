package com.ruoyi.mapper.support.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * ThreadLocal 存储分页状态
 *
 * @date 2022/4/12
 */
public class PagerSupport implements Pager {

    private static final ThreadLocal<Page<?>> threadLocalPage = new ThreadLocal<>();

    public static ThreadLocal<Page<?>> getThreadLocalPage() {
        return threadLocalPage;
    }

    @Override
    public void startPage(int pageIndex, int pageSize) {
        Page<?> page = new Page<>(pageIndex, pageSize);
        threadLocalPage.set(page);
    }

    @Override
    public long getRecordTotal(List<?> list) {
        Page<?> page = threadLocalPage.get();
        return page.getTotal();
    }

    @Override
    public void endPage() {
        threadLocalPage.remove();
    }

    @Override
    public Page<?> getPage() {
        return threadLocalPage.get();
    }
}
