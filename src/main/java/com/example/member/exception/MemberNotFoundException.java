package com.example.member.exception;

/**
 * 회원 조회 실패 Exception.
 */
public class MemberNotFoundException extends BusinessException {

  /**
   * 비즈니스 Exception을 생성합니다.
   */
  public MemberNotFoundException() {
    super("이메일 또는 비밀번호가 올바르지 않습니다.");
  }

}
