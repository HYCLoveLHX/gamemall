package com.hyc.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("success");
    }
    @Bean //将组件注册在容器
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer adapter=new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index") ;
                registry.addViewController("/main.html").setViewName("index");
            }
        };
        return adapter;
    }

}
