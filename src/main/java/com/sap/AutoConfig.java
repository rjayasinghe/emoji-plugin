package com.sap;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class AutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public EmojiHandler exampleHandler() {
        return new EmojiHandler();
    }

}