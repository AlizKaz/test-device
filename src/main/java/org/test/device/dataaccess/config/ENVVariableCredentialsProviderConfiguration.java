package org.test.device.dataaccess.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Alireza on 1/29/2019.
 */
@Configuration
public class ENVVariableCredentialsProviderConfiguration {

    @Bean
    public AWSCredentialsProvider getProvider() {
        return new EnvironmentVariableCredentialsProvider();
    }
}
