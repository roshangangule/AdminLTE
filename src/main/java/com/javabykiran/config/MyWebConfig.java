package com.javabykiran.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.javabykiran")
public class MyWebConfig extends WebMvcConfigurerAdapter implements WebMvcConfigurer{
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/pages/examples/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	
	@Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    return messageSource;
	}
	
	
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/bootstrap/**").addResourceLocations("/WEB-INF/pages/bootstrap/");
		registry.addResourceHandler("/dist/**").addResourceLocations("/WEB-INF/pages/dist/");
		registry.addResourceHandler("/pages/**").addResourceLocations("/WEB-INF/pages/pages/");
		registry.addResourceHandler("/plugins/**").addResourceLocations("/WEB-INF/pages/plugins/");

	}
	
	
	
	
}

