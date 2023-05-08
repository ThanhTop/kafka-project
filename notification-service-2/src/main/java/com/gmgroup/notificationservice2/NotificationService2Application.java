package com.gmgroup.notificationservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class NotificationService2Application {

    public static void main(String[] args) {
        SpringApplication.run(NotificationService2Application.class, args);
    }

    @Bean
    JsonMessageConverter converter() {
        return new JsonMessageConverter();
    }

}
