package in.sachinit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {//this class generate the swagger documentation
    @Bean
	public Docket apiDoc() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("in.sachinit.rest"))// tell the swager create the documentation only   for in this package classes
		        .paths(PathSelectors.any())//all the method to generate the documentation ,all the paths selec from that classes
		        .build();//based on this above configuration build the documentation
		
	}
	
	
}
