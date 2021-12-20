package com.example.member.adapter.in.web.model;

import lombok.Getter;

/**
 * 인증 문자 검증 결과.
 */
@Getter
public class ValidationAuthenticationNumberResponse {

  private final boolean result;

  /**
   * 인증 문자 검증 결과를 생성합니다.
   *
   * @param result 인증 결과
   */
  public ValidationAuthenticationNumberResponse(final boolean result) {
    this.result = result;
  }

}
