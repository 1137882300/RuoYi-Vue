package com.ruoyi.mapper.support;

import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import lombok.SneakyThrows;


/**
 * Mapper工具类
 */
public class MapperUtils {


    /**
     * 根据model 获取 IMapperAdapter
     */
    @SneakyThrows
    public static IMapperAdapter<?> getIMapperAdapter(String modelStr) {
        final Class<?> modelClazz = Class.forName(modelStr);
        return getIMapperAdapter(modelClazz);
    }

    /**
     * 根据model class 获取 IMapperAdapter
     */
    @SneakyThrows
    public static IMapperAdapter<?> getIMapperAdapter(Class<?> modelClazz) {
        final String currentNamespace = SqlHelper.table(modelClazz).getCurrentNamespace();
        final Class<?> aClass = Class.forName(currentNamespace);
        return (IMapperAdapter<?>) SpringUtil.getBean(aClass);
    }
}
