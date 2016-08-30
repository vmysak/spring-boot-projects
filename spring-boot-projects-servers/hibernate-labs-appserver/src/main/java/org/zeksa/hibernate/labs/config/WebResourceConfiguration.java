package org.zeksa.hibernate.labs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class WebResourceConfiguration extends WebMvcConfigurerAdapter {

	@Value( "${swaggerUnpackedDirectory}" )
	private String swaggerDir;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/swagger/**")
				.addResourceLocations("classpath:"+swaggerDir);

		registry.addResourceHandler("/app/**")
				.addResourceLocations("classpath:/static/gui/app/");
	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new MappingJackson2HttpMessageConverter());
		super.extendMessageConverters(converters);
	}

}