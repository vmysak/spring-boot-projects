package org.zeksa.hibernate.labs;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class AppServerConfiguration {

    @Bean
    public PropertyPlaceholderConfigurer swaggerPropertiesConfiguration() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setIgnoreUnresolvablePlaceholders(true);
        configurer.setLocation(new ClassPathResource("swagger.build.properties"));

        return configurer;
    }

}
