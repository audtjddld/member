package com.example.member.application.port.in;

import com.example.member.adapter.in.web.model.AuthenticateMobileResponse;
import com.example.member.application.port.in.command.AuthenticateMobileCommand;

/**
 * 휴대번호 인증 요청 UseCase.
 */
public interface AuthenticateMobileUseCase {

  /**
   * 인증번호 요청을 처리합니다.
   *
   * @param command 인증번호 요청 command.
   * @return 인증번호 응답
   */
  AuthenticateMobileResponse authenticate(AuthenticateMobileCommand command);

}
