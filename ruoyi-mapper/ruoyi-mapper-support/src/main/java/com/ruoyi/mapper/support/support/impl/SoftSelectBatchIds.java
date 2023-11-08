package com.ruoyi.mapper.support.support.impl;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.sql.SqlScriptUtils;
import com.ruoyi.mapper.support.support.SqlUtils;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * 软批量查询 增加 where deleted=0
 *
 * @author ashui
 * @date 2022/9/18
 */
public class SoftSelectBatchIds extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sql = "<script>\nSELECT %s FROM %s WHERE %s IN (%s) %s\n</script>";
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, String.format(sql,
                sqlSelectColumns(tableInfo, false), tableInfo.getTableName(), tableInfo.getKeyColumn(),
                SqlScriptUtils.convertForeach("#{item}", COLLECTION, null, "item", COMMA),
                SqlUtils.getWhereLogicDeleteSql(tableInfo, true)), Object.class);
        return addSelectMappedStatementForTable(mapperClass, "softSelectBatchIds", sqlSource, tableInfo);
    }
}