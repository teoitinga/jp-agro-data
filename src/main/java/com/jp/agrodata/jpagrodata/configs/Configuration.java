package com.jp.agrodata.jpagrodata.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.format.DateTimeFormatter;

@org.springframework.context.annotation.Configuration
@EnableJpaAuditing
public class Configuration {
    @Bean
    public DateTimeFormatter formatterddMMyyyy(){
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

}
