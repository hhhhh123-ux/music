package com.javaclimb.music.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
   解决springboot与vue的port

        **/
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
   @Override
    public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping("/**")
               .allowedOrigins("*")
               .allowedMethods("*")
//               .maxAge(3600)
               .allowCredentials(true);
    }

}
