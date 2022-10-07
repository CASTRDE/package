package com.example.demo.configuration;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@Data
@Getter
@Setter
public class ApplicationConfiguration {
    private String ooclTopicName;
    private String cargoSpecQueueName;
    private String packageQueueName;
    private String packageExceptionQueueName;
}
