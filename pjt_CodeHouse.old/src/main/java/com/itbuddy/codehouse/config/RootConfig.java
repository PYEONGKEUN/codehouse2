package com.itbuddy.codehouse.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.itbuddy.codehouse.controller","com.itbuddy.codehouse.config" })
@PropertySource({"classpath:profiles/${spring.profiles.active}/application.properties"})
public class RootConfig implements WebMvcConfigurer {
	@Value("${uploads.location}")
    private String uploadsLocation;
    @Value("${uploads.uri_path}")
    private String uploadsUriPath;
    
    private static final Logger logger = LoggerFactory.getLogger(RootConfig.class);
    
	
	private final int MAX_SIZE = 20 * 1024 * 1024;
	
	
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }



	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//mapping="/resources/**" locations=/resources/
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler(uploadsUriPath+"/**").addResourceLocations("file://"+uploadsLocation);
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

		logger.info(uploadsUriPath + " : "+ uploadsLocation);

		
	}

	   @Bean
	   public MultipartResolver multipartResolver() {
	      CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	      multipartResolver.setMaxUploadSize(MAX_SIZE); // 10MB
	      multipartResolver.setMaxUploadSizePerFile(MAX_SIZE); // 10MB
	      multipartResolver.setMaxInMemorySize(0);
	      return multipartResolver;
	   }
	   



	

	
}
