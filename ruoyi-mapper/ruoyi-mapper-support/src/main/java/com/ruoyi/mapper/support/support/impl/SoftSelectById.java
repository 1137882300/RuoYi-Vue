package com.ruoyi.mapper.support.support.impl;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.ruoyi.mapper.support.support.SqlUtils;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.defaults.RawSqlSource;

/**
 * 软查询 增加 where deleted=0
 *
 * @author ashui
 * @date 2022/9/18
 */
public class SoftSelectById extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sql = "SELECT %s FROM %s WHERE %s=#{%s} %s";
        SqlSource sqlSource = new RawSqlSource(configuration, String.format(sql,
                sqlSelectColumns(tableInfo, false),
                tableInfo.getTableName(), tableInfo.getKeyColumn(), tableInfo.getKeyProperty(),
                SqlUtils.getWhereLogicDeleteSql(tableInfo, true)), Object.class);
        return this.addSelectMappedStatementForTable(mapperClass, "softSelectById", sqlSource, tableInfo);
    }


}

