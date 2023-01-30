package br.com.evasion.src.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

import static com.google.common.collect.Sets.newHashSet;


@Configuration
@EnableSwagger2
public class SpringConfig implements WebMvcConfigurer {

    @Bean
    public Docket apiDoc(final Environment environment) {

        final String DESCRIPTION = "API avoidance prediction";

        final ApiInfo build = new ApiInfoBuilder().title("SWAGGER API avoidance prediction")
                .description(DESCRIPTION)
                .build();

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("br.com.evasion.src.resource"))
                .paths(PathSelectors.any())
                .build()
                .protocols(newHashSet("https", "http"))
                .apiInfo(build)
                .enableUrlTemplating(false);
    }

}
