package org.zeksa.springcore.server.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class PropertiesConfiguration {

    @Bean
    public PropertyPlaceholderConfigurer swaggerPropertiesConfiguration() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setIgnoreUnresolvablePlaceholders(true);
        configurer.setLocations(
                new ClassPathResource("mailservice.properties"),
                new ClassPathResource("swagger.build.properties"));
        return configurer;
    }

}
