package com.example.ProductApp;

import com.example.ProductApp.Filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.FilterRegistration;

@SpringBootApplication
@EnableEurekaClient
public class ProductAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductAppApplication.class, args);
	}
@Bean
	public FilterRegistrationBean filterBean()
{
	FilterRegistrationBean filterRegistration=new FilterRegistrationBean();
	filterRegistration.setFilter(new JwtFilter());
	filterRegistration.addUrlPatterns("/product-app/get-User-Details","/product-app/ADD-PRODUCT");
	return filterRegistration;

}
@Bean
	public FilterRegistrationBean filterRegistrationBean()
{
	final CorsConfiguration configuration= new CorsConfiguration();
	configuration.setAllowCredentials(true);
	configuration.addAllowedOrigin("http://localhost:4200");
	configuration.addAllowedHeader("*");
	configuration.addAllowedMethod("*");
	final UrlBasedCorsConfigurationSource source= new UrlBasedCorsConfigurationSource();
	source.registerCorsConfiguration("/**",configuration);
	FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean(new CorsFilter(source));
	filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	return filterRegistrationBean;
}
}


