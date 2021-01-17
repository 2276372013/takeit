package com.take.takeDemo.Common.config;

import com.take.takeDemo.Common.interceptors.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Chilly Cui on 2020/9/9.
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/user/test")//.addPathPatterns("/**")拦截其他所有接口进行token验证
                .excludePathPatterns("/user/login")//.excludePathPatterns("/user/**")放行
        ;
    }
}
