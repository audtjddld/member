package com.example.member.config;

import com.example.member.config.interceptor.AuthorizationInterceptor;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web Mvc Configurer.
 */
@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

  private final AuthorizationInterceptor authorizationInterceptor;

  @Override
  public void addInterceptors(final InterceptorRegistry registry) {
    registry.addInterceptor(authorizationInterceptor)
        .excludePathPatterns(List.of("/login", "/login/*"))
        .addPathPatterns("/**");
  }

}
