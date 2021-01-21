package com.jp.agrodata.jpagrodata.configs;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;


public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("JP-SYSTEM");
    }
}
