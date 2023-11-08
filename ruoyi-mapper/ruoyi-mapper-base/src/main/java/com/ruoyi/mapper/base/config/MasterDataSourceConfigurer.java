package com.ruoyi.mapper.base.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.ruoyi.mapper.support.DataSourceConfigurer;
import com.ruoyi.mapper.support.support.ConfigAdapter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @desc 数据源配置
 */
@Configuration
public class MasterDataSourceConfigurer implements DataSourceConfigurer {

    public static final String DB_PREFIX = "crab";
    public static final String TRANSACTION_MANAGER = DB_PREFIX + "DataSourceTransactionManager";

    @Override
    @Bean(name = DB_PREFIX + "DataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Override
    @Bean(DB_PREFIX + "SqlSessionFactory")
//    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier(DB_PREFIX + "DataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                        .getResources("classpath:mapper/*/*.xml")
        );

//        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        ConfigAdapter.config(sqlSessionFactoryBean);
        return sqlSessionFactoryBean.getObject();
    }


    @Override
    @Bean(TRANSACTION_MANAGER)
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier(DB_PREFIX + "DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Override
    @Bean(DB_PREFIX + "MapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName(DB_PREFIX + "SqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.ruoyi.**.mapper");
        return mapperScannerConfigurer;
    }
}


