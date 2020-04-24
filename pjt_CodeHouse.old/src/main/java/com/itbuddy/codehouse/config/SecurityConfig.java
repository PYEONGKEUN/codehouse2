package com.itbuddy.codehouse.config;



import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.itbuddy.codehouse.config.security.CustomAccessDeniedHandler;
import com.itbuddy.codehouse.config.security.CustomLoginSuccessHandler;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
	
	  
	
	@Autowired
	DataSource dataSource;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//UploadCOntroller
		
		http.authorizeRequests()
		.antMatchers("/uploadimg.action").authenticated()
		.antMatchers("/").permitAll()
		.antMatchers("/mypage").hasRole("MEMBER")
		.antMatchers("/signup","/signup.action").permitAll()
		.antMatchers("/common/topnav").permitAll()
		.antMatchers("/uploadimg.action").authenticated();// 인증을 한 사용자
		
		http.formLogin()
		.loginPage("/login")
		.successHandler(createSuccessHandler());
		
		http.logout()
		.logoutUrl("/logout.action")
		.invalidateHttpSession(true);
				
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		
		String usersByUsernameQuery = "SELECT mem_id AS userName, mem_pw AS password, mem_enabled AS enabled FROM member WHERE mem_id = ?";
		String authoritiesByUsernameQuery = "SELECT mem_id AS userName, mem_typ_type AS authority FROM mem_type WHERE mem_typ_type = ?";
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery(usersByUsernameQuery)
		.authoritiesByUsernameQuery(authoritiesByUsernameQuery)
		.passwordEncoder(createPasswordEncoder());
	}
	

	
	
	@Bean
	public AccessDeniedHandler createAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	@Bean
	public AuthenticationSuccessHandler createSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	@Bean
	public PasswordEncoder createPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
