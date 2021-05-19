package com.mtit.userservice.user_service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Collections;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.mtit.userservice.user_service"))
                .build().apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {

        return new ApiInfo(
                "Swagger API by Vithanage E.D",
                "API reference for MTIT Assignment 4",
                "1.0.0",
                "Public API",
                new Contact(
                        "SachinthaAnujaya",
                        "https://mvnrepository.com/artifact/io.springfox/springfox-swagger2/2.9.2",
                        "it19234458@my.sliit.lk"),
                "API Dashboard",
                "http://localhost:8083/swagger-ui.html#/",
                Collections.emptyList()
        );
    }
}
