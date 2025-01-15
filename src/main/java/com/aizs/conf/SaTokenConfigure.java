package com.aizs.conf;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor(handle -> StpUtil.checkLogin()))
                .addPathPatterns("/**")
                .excludePathPatterns("/api/login",
                        "/api/register","/api/chat",
                        "/api/exam/records",
                        "/api/exam/records/export",
                        "/api/exam/records/{workerid}",
                        "/api/exam/records/{workerid}/export",
                        "/api/tts",
                        "/api/tts/synthesize",
                        "/api/tts/**");
    }
}