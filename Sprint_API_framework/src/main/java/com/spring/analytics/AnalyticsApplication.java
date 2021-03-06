package com.spring.analytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableSwagger2
public class AnalyticsApplication {

	public static void main(String[] args) {
			SpringApplication.run(AnalyticsApplication.class, args);
			System.out.println("Spring api server start");
	}
	
	
	 @Bean
	    public FilterRegistrationBean corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();
	        config.setAllowCredentials(true);
	        config.addAllowedOrigin("*");
	        config.addAllowedHeader("*");
	        config.addAllowedMethod("*");
	        source.registerCorsConfiguration("/**", config);
	        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
	        bean.setOrder(0);
	        return bean;
	    }
	 
	    @Bean
	    public Docket swaggerPlugin() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .groupName("springboot")
	                .apiInfo(apiInfo())
	                .select()
	                .paths(regex("/.*"))
	                .build();
	    }

	 
	    @Component
	    class WebConfigurer extends WebMvcConfigurerAdapter {
	        @Override
	        public void addResourceHandlers(ResourceHandlerRegistry registry) {
	            registry.addResourceHandler("/resources/**")	                                              
	                    .addResourceLocations("file:/tmp/disk2/thumbnails/");                           
	        }
	    }

	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("Spring REST API")
	                .version("1.0")
	                .build();
	    }
}
