package org.test.device.dataaccess.config;

import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.auth.*;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories
  (basePackages = "org.test.device.data.dynamodb.repositories")
public class DynamoDBConfig {

    @Autowired
    private AWSCredentialsProvider credentialsProvider;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB amazonDynamoDB =
                AmazonDynamoDBClientBuilder
                .standard()
                .withCredentials(credentialsProvider)
                .withRegion(Regions.US_EAST_1)
                        .withRequestHandlers(new RequestHandler2[]{new RequestHandler2() {
                            @Override
                            public void afterError(Request<?> request, Response<?> response, Exception e) {
                                super.afterError(request, response, e);
                            }
                        }})
                .build();


        return amazonDynamoDB;
    }
}