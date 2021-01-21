package com.take.takeDemo.Common.config;

import com.take.takeDemo.Common.interceptors.JWTInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    JWTInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .excludePathPatterns("/user/**")
                .addPathPatterns("/**")//拦截其他所有接口进行token验证
        ;
    }
//
//    /**
//     * 解决跨域问题
//     *
//     * @param registry
//     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        //项目中的所有接口都支持跨域
//        registry.addMapping("/**")
//                //所有地址都可以访问，也可以配置具体地址
//                .allowedOrigins("http://localhost:4200")
//                .allowedHeaders("*")
//                //允许的请求方式
//                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
//                //是否支持跨域Cookie
//                .allowCredentials(true);
//                // 跨域允许时间
//                //.maxAge(3600);
//    }
}
