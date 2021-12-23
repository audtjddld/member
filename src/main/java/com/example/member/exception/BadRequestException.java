package com.example.member.exception;

/**
 * 입력값 검증 실패 Exception.
 */
public class BadRequestException extends BusinessException {

  /**
   * 비즈니스 Exception을 생성합니다.
   */
  public BadRequestException() {
    super("입력값이 올바르지 않습니다.");
  }

}
