package com.ruoyi.mongo.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.ruoyi.tool.CryptoAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.lang.NonNull;

/**
 * @author: juzi
 * @date: 2023/12/18
 * @desc:
 */
@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${mongodb.uri}")
    private String mongoUri;

    @NonNull
    @Override
    protected String getDatabaseName() {
        return "crab";
    }

    @NonNull
    @Override
    public MongoClientSettings mongoClientSettings() {
        String uri = CryptoAlgorithm.decryptWithAes(mongoUri);
        ConnectionString connectionString = new ConnectionString(uri);
        return MongoClientSettings.builder().applyConnectionString(connectionString).build();
    }
}