package com.kt.sw.edu.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableDiscoveryClient
@EnableEurekaClient
public class RestClientConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
