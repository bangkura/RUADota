package com.RUADota.Config;

import org.springframework.context.annotation.*;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;


@Configuration
@ComponentScan(basePackages = "com.RUADota.Config")
@Import(MongoConfig.class)
public class RootConfig {

    @Bean
    public PropertyPlaceholderConfigurer getPropertyPlaceHolder() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocations(new ClassPathResource("mongodb.properties"));
        return ppc;
    }
}