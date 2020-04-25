package org.itbuddy.codehouse.config;


import com.zaxxer.hikari.HikariDataSource;

import org.itbuddy.codehouse.config.security.CustomAccessDeniedHandler;
import org.itbuddy.codehouse.config.security.CustomLoginSuccessHandler;
import org.itbuddy.codehouse.config.security.CustomNoOpPasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.filter.CharacterEncodingFilter;

@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter{
    private static Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);


    @Autowired
    HikariDataSource dataSource;
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	CharacterEncodingFilter filter = new CharacterEncodingFilter();
    	
    	filter.setEncoding("UTF-8");
    	filter.setForceEncoding(true);
    	
    	
    	
        //웹 페이지 접근 권한 설정
        

		http.authorizeRequests()
		.antMatchers("/uploadimg.action").authenticated()
		.antMatchers("/").permitAll()
		.antMatchers("/mypage").hasRole("MEMBER")
		.antMatchers("/signup","/signup.action").permitAll()
		.antMatchers("/common/topnav").permitAll()
		.antMatchers("/uploadimg.action").authenticated();// 인증을 한 사용자
		
		http.formLogin()
		.loginPage("/login")
		.successHandler(createAuthenticationSuccessHandler());
		
		http.logout()
		.logoutUrl("/logout.action")
		.invalidateHttpSession(true);


        
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 지정된 아이디와 패스워드로 로그인이 가능하도록 한다.

        auth.inMemoryAuthentication()
        .withUser("member")
        .password("{noop}1234")
        .roles("MEMBER");

        auth.inMemoryAuthentication()
        .withUser("admin")
        .password("{noop}1234")
        .roles("ADMIN");


        //jdbc 인증 제공자
        auth.jdbcAuthentication()
        .dataSource(dataSource)
        .passwordEncoder(createPasswordEncoder());


    }

    @Bean
    public PasswordEncoder createPasswordEncoder(){
        return new CustomNoOpPasswordEncoder();
    }


    @Bean
    public AccessDeniedHandler createAccessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public AuthenticationSuccessHandler createAuthenticationSuccessHandler(){
        return new CustomLoginSuccessHandler();
    }

}