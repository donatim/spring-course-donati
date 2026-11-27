package com.example.spring_course.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ConditionalOnProperty(
        name = "app.scheduling.enabled",
        havingValue = "true"
)
public class SchedulingConfig {
}
