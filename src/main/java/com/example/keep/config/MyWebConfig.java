package com.example.keep.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootConfiguration
public class MyWebConfig {
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/api/file/**").addResourceLocations("file:" + "C:\\Users\\25737\\IdeaProjects\\springboot\\img\\");
    }
}
