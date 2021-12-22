package com.example.member.exception;

/**
 * 토큰 정보 만료 예외.
 */
public class ExpiredTokenException extends BusinessException {

  /**
   * 비즈니스 Exception을 생성합니다.
   */
  public ExpiredTokenException() {
    super("인증 정보가 만려되었습니다.");
  }

}
