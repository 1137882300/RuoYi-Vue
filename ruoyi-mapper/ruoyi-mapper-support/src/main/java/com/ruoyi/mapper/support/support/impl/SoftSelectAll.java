package com.ruoyi.mapper.support.support.impl;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.ruoyi.mapper.support.support.SqlUtils;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * 查询所有
 * @author ashui
 * @date 2020/12/15
 */
public class SoftSelectAll extends AbstractMethod {


    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sqlScript = "<script>\nSELECT %s FROM %s  WHERE %s %s\n</script>";
        String sql = String.format(sqlScript, this.sqlSelectColumns(tableInfo, true),
                tableInfo.getTableName(),
                SqlUtils.getWhereLogicDeleteSql(tableInfo, false), this.sqlComment());
        SqlSource sqlSource = this.languageDriver.createSqlSource(this.configuration, sql, modelClass);
        return this.addSelectMappedStatementForTable(mapperClass, "softSelectAll", sqlSource, tableInfo);
    }
}
