package com.example.member.exception;

/**
 * 회원 예외 Exception class.
 */
public class BusinessException extends RuntimeException {

  /**
   * 비즈니스 Exception을 생성합니다.
   *
   * @param message 안내 메시지
   */
  public BusinessException(final String message) {
    super(message);
  }

}
