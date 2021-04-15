package com.spring.andre.demo.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;



@Configuration
public class SwaggerConfig {
	
	//url para o swagger http://localhost:8080/swagger-ui/

	 /*@Bean
     public Docket api(ServletContext servletContext) {
       return new Docket(DocumentationType.SWAGGER_2)
           .securitySchemes(Arrays.asList(apiKey()))
           .securityContexts(Collections.singletonList(securityContext()));
     }*/

     /*private SecurityContext securityContext() {
       return SecurityContext.builder().securityReferences(defaultAuth()).build();
     }

     private List<SecurityReference> defaultAuth() {
       final AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
       final AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{authorizationScope};
       return Collections.singletonList(new SecurityReference("Bearer", authorizationScopes));
     }*/

     /*private ApiKey apiKey() {
       return new ApiKey("Bearer", "Authorization", "header");
     }*/
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}
	
}
