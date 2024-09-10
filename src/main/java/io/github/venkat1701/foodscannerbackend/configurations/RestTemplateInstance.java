package io.github.venkat1701.foodscannerbackend.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateInstance {

    @Bean
    public RestTemplate getRestTemplateInstance() {
        return new RestTemplate();
    }
}
