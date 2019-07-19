package br.com.firstdatacorp.apipagamentos;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	public static final String AUTHORIZATION_HEADER = "Authorization";
	public static final String DEFAULT_INCLUDE_PATTERN = "/resources/.*";

	@Bean
	public Docket detalheApi() {

		Docket docket = new Docket(DocumentationType.SWAGGER_2);

		docket.apiInfo(informacoesApi().build()).pathMapping("/").apiInfo(ApiInfo.DEFAULT).forCodeGeneration(true)
				.securityContexts(Lists.newArrayList(securityContext())).securitySchemes(Lists.newArrayList(apiKey()))
				.useDefaultResponseMessages(false);

		docket = docket.select().paths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN)).build();

		return docket;
	}

	private ApiInfoBuilder informacoesApi() {

		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

		apiInfoBuilder.title("Api-Validator");
		apiInfoBuilder.description("Api para validação cadastral via token");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder
				.termsOfServiceUrl("Termo de uso: Serviços de geração e validação do token para permitir cadastros");
		apiInfoBuilder.license("Licença - Open Source");
		apiInfoBuilder.licenseUrl("https://www.firstdata.com/pt_br/home.html");
		apiInfoBuilder.contact(this.contato());

		return apiInfoBuilder;

	}

	private Contact contato() {

		return new Contact("First Data", "https://www.firstdata.com/pt_br/home.html", "");
	}

	private ApiKey apiKey() {
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth())
				.forPaths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN)).build();
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Lists.newArrayList(new SecurityReference("JWT", authorizationScopes));
	}

}