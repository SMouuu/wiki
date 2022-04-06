// package com.jiawa.wiki.config;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// import javax.annotation.Resource;

// import com.jiawa.wiki.interceptor.LogInterceptor;

// @Configuration
// public class SpringMvcConfig implements WebMvcConfigurer {
// @Resource
// LogInterceptor loginInterceptor;

// public void addInterceptors(InterceptorRegistry registry) {
// registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login");
// }
// }