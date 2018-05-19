package com.j.mq.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {
    @Bean
    public Jackson2JsonMessageConverter createJackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}