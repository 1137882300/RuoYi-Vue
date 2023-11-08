package com.ruoyi.mapper.support.support;

import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;

import java.util.Optional;

/**
 * @author ashui
 * @date 2022/9/18
 */
public class SqlUtils {

    public static String getWhereLogicDeleteSql(TableInfo tableInfo, boolean startWithAnd) {
        Optional<TableFieldInfo> first = tableInfo.getFieldList().stream().filter(it -> it.getColumn().equals("deleted")).findFirst();

        if (first.isPresent()) {
            String logicDeleteSql = " deleted=0 ";
            if (startWithAnd) {
                logicDeleteSql = " AND " + logicDeleteSql;
            }
            return logicDeleteSql;
        }
        return "";
    }

    /**
     * 更新 deleted 和 deleted_at 字段
     *
     * @author ashui
     * @date 2022/9/18
     */
    public static String sqlLogicSetAndDate(TableInfo table) {
        String setDeletedAtSql = "";
        Optional<TableFieldInfo> deletedAt = table.getFieldList().stream().filter(it -> it.getColumn().equals("deleted_at")).findFirst();

        if (deletedAt.isPresent()) {
            setDeletedAtSql = " , deleted_at=now() ";
        }
        return "SET deleted=1 " + setDeletedAtSql;
    }
}
