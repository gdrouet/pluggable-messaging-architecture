package com.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * This configuration demonstrates how the driver can use IoC inside the container.
 */
@Configuration
public class DriverDemoConfig {

    /**
     * Injects a bean to the container.
     *
     * @return the bean
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
