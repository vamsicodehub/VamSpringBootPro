package com.vamsi.sbapp.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SpringFoxSwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.vamsi.sbapp.controllers"))
				.paths(PathSelectors.any()).build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Vamsi Swagger Demo")
				.description("</b>Vamsi's API Documentation Demo using Swagger..</b>")
				.termsOfServiceUrl("http://www.vamsigroup.com")
				.contact(new Contact("Vamsi Group", "http://www.vamsigroup.com", "contact@vamsigroup.com"))
				.license("copyright@2021 Vamsi Group. All Rights Reserved.")
				.licenseUrl("contact@vamsigroup.com")
				.version("1.0")
				.build();
	}

}
