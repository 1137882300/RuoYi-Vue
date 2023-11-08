package com.ruoyi.mapper.support.page.stream;

import java.util.function.Supplier;

/**
 * 分页数据懒加载器
 * @author ashui
 * @date 2021/9/9
 */
public interface PageDataSupplier<T>  extends Supplier<T> {
}
