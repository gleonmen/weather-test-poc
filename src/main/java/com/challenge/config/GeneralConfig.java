package com.challenge.config;


import com.challenge.apis.clients.APIClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class GeneralConfig {

    @Autowired
    private ApiConfigReader applicationConfig;

    @Bean
    public APIClientFactory apiClientFactory() {
        return new APIClientFactory();
    }

    @Bean
    public ApiConfigReader applicationConfig() {
        return new ApiConfigReader();
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }


    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.challenge.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfo(
                "Central Challenge Weather",
                "An API that allows you to get the weather for a specific city based on its name, It searches info in differents sources",
                "1.0",
                "",
                new Contact("Giovanni Leon", "", "gleonmen@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
    }

}
