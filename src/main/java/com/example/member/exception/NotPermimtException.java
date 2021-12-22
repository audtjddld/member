package com.example.member.exception;

/**
 * 토근 검증 실패 Exception.
 */
public class NotPermimtException extends BusinessException {

  /**
   * 비즈니스 Exception을 생성합니다.
   */
  public NotPermimtException() {
    super("인증 정보가 옳바르지 않습니다.");
  }

}
