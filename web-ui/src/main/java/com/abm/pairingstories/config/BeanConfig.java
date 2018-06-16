package com.abm.pairingstories.config;

import com.abm.pairingstories.domain.PairingSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {

    @Bean
    @Scope("prototype")
    public PairingSystem getPairingSystem() {
        return new PairingSystem();
    }

}
