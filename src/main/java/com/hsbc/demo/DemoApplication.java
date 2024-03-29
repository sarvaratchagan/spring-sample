package com.hsbc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.hsbc.demo.repository"})
@EntityScan(basePackages = "com.hsbc.demo")
@EnableTransactionManagement
@EnableScheduling
@EnableSwagger2
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    public Docket swaggerPersonApi10() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("demo-api-1.0")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hsbc.demo"))
                .paths(regex("/api/v1.*"))
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Demo API").description("Documentation Demo API " +
                        "v1.0").build());
    }


//    @Bean
//    public Docket swaggerPersonApi11() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("demo-api-1.1")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.hsbc.demo.controller"))
//                .paths(regex("/**/v1.1.*"))
//                .build()
//                .apiInfo(new ApiInfoBuilder().version("1.1").title("Demo API").description("Documentation Demo API v1.1").build());
//    }
//
//    @Bean
//    public Docket swaggerPersonApi12() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("demo-api-1.2")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.hsbc.demo.controller"))
//                .paths(regex("/**/v1.2.*"))
//                .build()
//                .apiInfo(new ApiInfoBuilder().version("1.2").title("Demo API").description("Documentation Demo API v1.2").build());
//    }

}
