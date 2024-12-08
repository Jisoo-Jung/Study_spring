package com.app.app.configuration;

import com.app.app.interceptor.LogInterceptor;
import com.app.app.interceptor.TestInterceptor;
import com.app.app.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
    private final MemberService memberService;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LogInterceptor(memberService)).excludePathPatterns("/member/**", "/css/**", "/images/**", "/js/**");
        registry.addInterceptor(new LogInterceptor(memberService)).addPathPatterns("/member/**");
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/post/**");
    }
}
