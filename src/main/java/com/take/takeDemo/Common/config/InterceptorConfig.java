package com.take.takeDemo.Common.config;

import com.take.takeDemo.Common.interceptors.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/**")//.addPathPatterns("/**")拦截其他所有接口进行token验证
                .excludePathPatterns("/user/**")//.excludePathPatterns("/user/**")放行
        ;
    }
}
