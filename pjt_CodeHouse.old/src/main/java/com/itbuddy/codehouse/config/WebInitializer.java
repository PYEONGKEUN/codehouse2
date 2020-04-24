package com.itbuddy.codehouse.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;



public class WebInitializer implements WebApplicationInitializer{
	
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {        
    	AnnotationConfigWebApplicationContext DataSourceContext = new AnnotationConfigWebApplicationContext();
    	DataSourceContext.register(DataSourceConfig.class);
    	        
    	ContextLoaderListener listener = new ContextLoaderListener(DataSourceContext);
    	servletContext.addListener(listener);
    	
    	
    	
    	
        AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
        servletAppContext.register(RootConfig.class);
        
        DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
 
        
        ServletRegistration.Dynamic servlet  = servletContext.addServlet("DispatcherServlet", dispatcherServlet);
        servlet .setLoadOnStartup(1);
        servlet .addMapping("/");
        
        
        // 인코딩 필터 적용
        FilterRegistration.Dynamic charaterEncodingFilter = servletContext.addFilter("charaterEncodingFilter", new CharacterEncodingFilter());
        charaterEncodingFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        charaterEncodingFilter.setInitParameter("encoding", "UTF-8");
        charaterEncodingFilter.setInitParameter("forceEncoding", "true");
        
        //spring Security
    	FilterRegistration.Dynamic delegatingFilterReg = servletContext.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
    	delegatingFilterReg.addMappingForUrlPatterns(null, true, "/*");
        
    } 



	

}

