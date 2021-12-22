package com.example.member.application.port.in;

import com.example.member.application.port.in.command.RegisterMemberCommand;

/**
 * 회원 가입 UseCase.
 */
public interface RegisterMemberUseCase {

  /**
   * 회원 정보를 저장합니다.
   *
   * @param command 회원정보 저장 커멘드
   */
  void register(RegisterMemberCommand command);

}
