package com.example.member.config.interceptor;

import com.example.member.config.JwtManager;
import com.example.member.exception.NotPermimtException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

/**
 * 인증 처리 Interceptor.
 */
@Component
@RequiredArgsConstructor
public class AuthorizationInterceptor implements AsyncHandlerInterceptor {

  private final JwtManager jwtManager;

  @Override
  public boolean preHandle(final HttpServletRequest request,
                           final HttpServletResponse response,
                           final Object handler) throws Exception {
    final String authorization = request.getHeader("Authorization");

    if (!authorization.startsWith("Bearer")) {
      throw new NotPermimtException();
    }

    final String token = authorization.substring(authorization.indexOf("Bearer")).trim();

    if (!jwtManager.verify(token)) {
      throw new NotPermimtException();
    }

    return true;
  }

}
