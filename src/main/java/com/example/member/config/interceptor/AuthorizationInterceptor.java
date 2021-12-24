package com.example.member.config.interceptor;

import com.example.member.config.JwtManager;
import com.example.member.exception.NotPermimtException;
import io.jsonwebtoken.Claims;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

/**
 * 인증 처리 Interceptor.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AuthorizationInterceptor implements AsyncHandlerInterceptor {

  private final JwtManager jwtManager;
  private final static String AUTHORIZATION = "Authorization";

  @Override
  public boolean preHandle(final HttpServletRequest request,
                           final HttpServletResponse response,
                           final Object handler) throws Exception {


    final String token = extract(request, "Bearer");

    log.info("token : {}", token);

    final Claims verify = jwtManager.verify(token);

    final long userId = Long.parseLong(request.getRequestURI().split("/")[2]);

    final long id = Long.parseLong(verify.get("id").toString());
    log.info("claims userId: {}", id);

    if (id != userId) {
      throw new NotPermimtException();
    }

    return true;
  }

  public String extract(final HttpServletRequest request, final String type) {
    final Enumeration<String> headers = request.getHeaders(AUTHORIZATION);
    while (headers.hasMoreElements()) {
      final String value = headers.nextElement();
      if (value.toLowerCase().startsWith(type.toLowerCase())) {
        return value.substring(type.length()).trim();
      }
    }

    return Strings.EMPTY;
  }

}
