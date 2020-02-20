package com.leyou.filters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MvcConfig
 * @Description: TODO
 * @Author 79440
 * @Date 2020/2/18
 * @Version V1.0
 **/
@Configuration
public class MvcConfig implements WebMvcConfigurer {


    @Bean
    public LoginInterceptor getLogin(){
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.getLogin()).addPathPatterns("/**");
    }
}
