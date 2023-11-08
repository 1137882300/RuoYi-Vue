package com.ruoyi.mapper.support.support;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.toolkit.GlobalConfigUtils;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.ruoyi.mapper.support.page.PlusPaginationInterceptor;
import org.apache.ibatis.plugin.Interceptor;

/**
 * 配置
 *
 * @author ashui
 * @date 2022/9/10
 */
public class ConfigAdapter {

    private static GlobalConfig getGlobalConfig() {
        GlobalConfig config = GlobalConfigUtils.defaults();
        config.setSqlInjector(new SqlInjectorAdapter());
        // 逻辑删除
//        config.getDbConfig().setLogicDeleteValue("1");
//        config.getDbConfig().setLogicNotDeleteValue("0");
//        config.getDbConfig().setLogicDeleteField("deleted");
        return config;
    }

    public static void config(MybatisSqlSessionFactoryBean sqlSessionFactoryBean) {
        //添加插件
        sqlSessionFactoryBean.setPlugins(new PlusPaginationInterceptor());
        //配置扩展
        sqlSessionFactoryBean.setGlobalConfig(getGlobalConfig());
    }
}
