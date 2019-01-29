package org.test.device.repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Alireza on 1/10/2019.
 */
@Configuration
public class RepositoryBeans {
    @Autowired
    private AmazonDynamoDB db;

    @Bean
    public DeviceRepository getDeviceRepository() {
        return new DeviceRepositoryImpl(db, new DynamoDBMapper(db));
    }
}
