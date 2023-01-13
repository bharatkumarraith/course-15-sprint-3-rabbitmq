package com.example.ProductApp;

import com.example.ProductApp.Filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

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
}


