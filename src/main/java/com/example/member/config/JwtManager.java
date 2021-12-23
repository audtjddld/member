package com.example.member.config;

import com.example.member.exception.ExpiredTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * token 관리자.
 */
@Component
public class JwtManager implements TokenManager {

  @Value("${secret.token}")
  private String secretKey;

  @Value("${secret.ttl}")
  private Long ttl;

  private static final String ISSUER = "my-member-api-service";

  /**
   * jwt token을 생성합니다.
   *
   * @param id    회원 아이디
   * @param email 대상자
   * @return jwt token
   */
  @Override
  public String create(final long id, final String email) {
    final Date expiredTime = new Date();
    expiredTime.setTime(ttl);

    final Map<String, Object> header = new HashMap<>();
    header.put("typ", "JWT");
    header.put("alg", "HS256");


    final JwtBuilder builder = Jwts.builder()
        .setHeader(header)
        .setIssuer(ISSUER)
        .setAudience(email)
        .setIssuedAt(new Date())
        .setExpiration(expiredTime)
        .setSubject("user-auth")
        .setIssuer(ISSUER)
        .claim("id", id)
        .claim("email", email)
        .signWith(SignatureAlgorithm.HS256, secretKey);

    return builder.compact();
  }

  /**
   * 토큰을 검증합니다.
   *
   * @param jwtToken jwt token
   * @return 유효한 토큰 true, 나머지 false
   */
  public boolean verify(final String jwtToken) {
    final Claims body = Jwts.parser()
        .setSigningKey(secretKey)
        .parseClaimsJws(jwtToken)
        .getBody();

    if (body.getExpiration().before(new Date())) {
      throw new ExpiredTokenException();
    }

    return !body.isEmpty();
  }

}
