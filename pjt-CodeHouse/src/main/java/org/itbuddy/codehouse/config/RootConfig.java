package org.itbuddy.codehouse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


@ComponentScan(basePackages = { "org.itbuddy.codehouse.service","org.itbuddy.codehouse.serviceImpl" })


public class RootConfig {
	
	
	private final int MAX_UPLOAD_SIZE = 20 * 1024 * 1024;
	
	
	
	   @Bean
	   public MultipartResolver multipartResolver() {
	      CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	      multipartResolver.setMaxUploadSize(MAX_UPLOAD_SIZE); // 10MB
	      multipartResolver.setMaxUploadSizePerFile(MAX_UPLOAD_SIZE); // 10MB
	      multipartResolver.setMaxInMemorySize(0);
	      return multipartResolver;
	   }
}
