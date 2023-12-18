package com.ruoyi.mongo.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.event.CommandListener;
import com.mongodb.event.CommandStartedEvent;
import com.mongodb.event.CommandSucceededEvent;
import org.bson.BsonDocument;
import org.bson.BsonReader;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriter;
import org.bson.json.JsonWriterSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;

import java.io.StringWriter;

/**
 * @author: juzi
 * @date: 2023/11/8
 * @desc:
 */
public class MongoCustomizer implements MongoClientSettingsBuilderCustomizer {

    @Override
    public void customize(MongoClientSettings.Builder clientSettingsBuilder) {
        clientSettingsBuilder.addCommandListener(new YxkCommandListener());
    }

    private static class YxkCommandListener implements CommandListener {

        public static final String MONGODB_LOGGER = "mongodb.logger";

        private static final Logger log = LoggerFactory.getLogger(MONGODB_LOGGER);

        @Override
        public void commandStarted(CommandStartedEvent event) {
            BsonDocument command = event.getCommand();
            if (log.isInfoEnabled()) {
                log.info("mongo command {} request ->{}", event.getCommandName(), getTruncatedJsonCommand(command.asDocument()));
            }

        }

        @Override
        public void commandSucceeded(CommandSucceededEvent event) {
            if (log.isInfoEnabled()) {
                log.info("mongo command {} Response ->{}", event.getCommandName(), event.getResponse());
            }
        }

        private String getTruncatedJsonCommand(BsonDocument commandDocument) {
            StringWriter writer = new StringWriter();
            BsonReader bsonReader = commandDocument.asBsonReader();
            String msg;
            try {
                JsonWriter jsonWriter = new JsonWriter(writer, JsonWriterSettings.builder().outputMode(JsonMode.RELAXED).maxLength(1000).build());
                jsonWriter.pipe(bsonReader);
                if (jsonWriter.isTruncated()) {
                    writer.append(" ...");
                }
                msg = writer.toString();
            } finally {
                bsonReader.close();
            }
            return msg;
        }
    }


}
