package com.ruoyi.mapper.support.support.impl;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.ruoyi.mapper.support.support.SqlUtils;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.defaults.RawSqlSource;

/**
 * 软根据id判断记录是否存在，存在返回1，否则返回null
 *
 * @author ashui
 * @date 2022/9/18
 */
public class SoftExistById extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sqlFormat = "SELECT 1 FROM %s WHERE %s=#{%s} %s limit 1";
        String sql = String.format(sqlFormat,
                tableInfo.getTableName(), tableInfo.getKeyColumn(), tableInfo.getKeyProperty(),
                SqlUtils.getWhereLogicDeleteSql(tableInfo, true));
        SqlSource sqlSource = new RawSqlSource(configuration, sql, Object.class);

        return this.addSelectMappedStatementForOther(mapperClass, "softExistById", sqlSource, Integer.class);
    }
}
