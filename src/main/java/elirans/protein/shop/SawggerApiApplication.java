package elirans.protein.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableScheduling
@EnableJpaRepositories
public class SawggerApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SawggerApiApplication.class, args);
		}
	
	@Bean
	public Docket swaggerConfiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/items/*"))
				.apis(RequestHandlerSelectors.basePackage("elirans.protein.shop"))
				.build()
				.apiInfo(apiDetails());
	}
	
	@SuppressWarnings("deprecation")
	private ApiInfo apiDetails() {
		
		return new ApiInfo(
				"Eliran's Protein Store",
				"Open Legacy Qualification API Exercise",
				"Free to use",
				"Swole is the goal, Size is the prise",
				" "," "," ");
		
		
	}

}
