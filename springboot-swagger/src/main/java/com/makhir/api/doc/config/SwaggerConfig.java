package com.makhir.api.doc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket produceApiDoc()
	{
		log.info("Generating API docs");
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		docket.apiInfo(createApiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.makhir.api.doc.controller")).paths(getApiPaths()).build();
		
		/*    Enable this if you want to disable the global response code and message provided by the swagger.
		.useDefaultResponseMessages(false)
        .globalResponseMessage(RequestMethod.GET, newArrayList(new ResponseMessageBuilder().code(500)
            .message("500 message")
            .responseModel(new ModelRef("Error"))
            .build(),
            new ResponseMessageBuilder().code(403)
                .message("Forbidden!!!!!")
                .build()));
		*/
		return docket;
	}

	private ApiInfo createApiInfo() {
		return new ApiInfoBuilder()
				.title("Customer Management Rest APIs")
				.description("This page lists all the rest apis for Customer Management App.")
				.contact(new Contact("Ashish", "https://github.com/akmishra30", "akmishra30@hotmail.com"))
				.version("1.0.0").build();
	}
	
	private Predicate<String> getApiPaths(){
		log.info("Getting API paths");
		return (Predicate<String>) Predicates.and(
			    PathSelectors.regex("/customer.*"),
			    Predicates.not(PathSelectors.regex("/error.*")));

	}
}
