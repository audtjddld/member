package com.example.member.adapter.in.web.model;

import lombok.Getter;

/**
 * 로그인 응답.
 */
@Getter
public class LoginResponse {

  private final String token;

  /**
   * 로그인 응답 객체를 생성합니다.
   *
   * @param token 인증토큰
   */
  public LoginResponse(final String token) {
    this.token = token;
  }

}
