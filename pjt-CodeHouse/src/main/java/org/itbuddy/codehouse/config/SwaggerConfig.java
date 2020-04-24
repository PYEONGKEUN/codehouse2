package org.itbuddy.codehouse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("org.itbuddy.codehouse")) // 기본 패키지 설정
        .paths(PathSelectors.ant("/api/*")) // swagger 노출할 api 경로의 패턴 설정
        .build()
        .apiInfo(apiInfo());
    }

    // swagger ui 페이지에 노출할 내용들 커스텀
    @SuppressWarnings("deprecation")
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
            "REST API",
            "API 리스트",
            "API V1.0",
            "Terms of service",
            "asdf@naver.com",
            "License of API",
            "/");
        return apiInfo;
    }
}
