package com.ruoyi.mongo.config;

import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: juzi
 * @date: 2023/11/8
 * @desc:
 */
@Configuration
public class MongodbConfiguration {

    @Bean
    public MongoClientSettingsBuilderCustomizer mongoClientSettingsBuilderCustomizer() {
        return new MongoCustomizer();
    }

}
