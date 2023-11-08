package com.ruoyi.mapper.support.support.impl;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.ruoyi.mapper.support.support.SqlUtils;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * 软删除
 *
 * @author ashui
 * @date 2022/9/18
 */
public class SoftDeleteById extends AbstractMethod {


    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sqlScript = "<script>\nUPDATE %s %s WHERE %s=#{%s} %s\n</script>";

        String sql = String.format(sqlScript, tableInfo.getTableName(), SqlUtils.sqlLogicSetAndDate(tableInfo),
                tableInfo.getKeyColumn(), tableInfo.getKeyProperty(),
                tableInfo.getLogicDeleteSql(true, true));
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, Object.class);
        return addUpdateMappedStatement(mapperClass, modelClass, "softDeleteById", sqlSource);
    }


}
