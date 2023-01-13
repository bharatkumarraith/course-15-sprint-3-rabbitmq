package com.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class gatewayconfig {
    @Bean
    RouteLocator getRoutes(RouteLocatorBuilder builder)
    {
        return builder.routes()
                .route(p->p
                        .path("/auth-app/**")
                        .uri("http://localhost:3456/*"))
                .route(p->p
                        .path("/product-app/**")
                        .uri("http://localhost:9999/*"))
                .build();
    }
}
