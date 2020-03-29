package com.b.myproject.Security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class Webconfiga implements WebMvcConfigurer {
    @Value("${corslogin}")
    String origin;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/login")
                // Cho phép các trang có thể request đến
                .allowedOrigins(origin, "*")
                // cho phép các phương thức được request
                .allowedMethods("POST","PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true).maxAge(3600);

    }
}
