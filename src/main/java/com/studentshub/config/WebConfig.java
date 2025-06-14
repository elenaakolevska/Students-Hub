package com.studentshub.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${materials.upload-dir:materialUploads}")
    private String materialsUploadDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("classpath:/static/uploads/")
                .setCachePeriod(0);

        String materialsPath = Paths.get(materialsUploadDir).toAbsolutePath().toString();
        registry.addResourceHandler("/files/**")
                .addResourceLocations("file:" + materialsPath + "/")
                .setCachePeriod(0);
    }
}