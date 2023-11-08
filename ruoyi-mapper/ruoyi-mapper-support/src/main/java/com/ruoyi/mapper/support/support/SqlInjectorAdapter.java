package com.ruoyi.mapper.support.support;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.ruoyi.mapper.support.support.impl.*;

import java.util.List;

/**
 * @author ashui
 * @date 2020/12/15
 */
public class SqlInjectorAdapter extends DefaultSqlInjector {
    public SqlInjectorAdapter() {
    }

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        methodList.add(new SelectAll());
        methodList.add(new InsertList());
        methodList.add(new SoftDeleteById());
        methodList.add(new ExistById());
        methodList.add(new SoftSelectById());
        methodList.add(new SoftSelectBatchIds());
        methodList.add(new SoftExistById());
        methodList.add(new SoftSelectAll());
        return methodList;
    }
}
