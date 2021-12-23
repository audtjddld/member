package com.example.member.config;

/**
 * 토큰 매니저.
 */
public interface TokenManager {

  /**
   * 토큰을 생성합니다.
   *
   * @param id    회원 아이디
   * @param email 이메일
   * @return 인증토큰
   */
  String create(long id, final String email);

  /**
   * 토큰을 검증합니다.
   *
   * @param jwtToken 인증토큰
   * @return 유효하면 true, 나머지 false
   */
  boolean verify(final String jwtToken);

}
