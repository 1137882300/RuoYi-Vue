package com.ruoyi.mapper.support.transaction;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 事务模板
 *
 * @author ashui
 * @date 2022/10/27
 */
public class TransactionTemplateSupport {


    /**
     * 事务执行
     *
     * @date 2022/10/27
     */
    public static void execute(Runnable runnable) throws TransactionException {
        Boolean flag = SpringUtil.getBean(TransactionTemplate.class).execute(status -> {
            runnable.run();
            return Boolean.TRUE;
        });
    }
}
