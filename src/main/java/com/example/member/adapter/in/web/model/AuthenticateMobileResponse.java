package com.example.member.adapter.in.web.model;

import lombok.Getter;

/**
 * 인증 요청 응답.
 */
@Getter
public class AuthenticateMobileResponse {

  private final String authenticationNumber;

  /**
   * 인증 요청 모델을 생성합니다.
   *
   * @param authenticationNumber 인증번호
   */
  public AuthenticateMobileResponse(final String authenticationNumber) {
    this.authenticationNumber = authenticationNumber;
  }

}
