package com.example.member.exception;

/**
 * 이미 가입된 회원 예외.
 */
public class AreadyJoinedMemberException extends BusinessException {

  /**
   * 비즈니스 Exception을 생성합니다.
   */
  public AreadyJoinedMemberException() {
    super("이미 가입된 내역이 있습니다.");
  }

}
