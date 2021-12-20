package com.example.member.application.port.in;

import com.example.member.adapter.in.web.model.ValidationAuthenticationNumberResponse;
import com.example.member.application.port.in.command.ValidateAuthenticationNumberCommand;

/**
 * 인증 문자 검증 UseCase.
 */
public interface ValidateAuthenticationNumberUseCase {

  /**
   * 인증 문자를 검증합니다.
   *
   * @param command 인증문자검증 command
   * @return 인증문자검증결과
   */
  ValidationAuthenticationNumberResponse validate(ValidateAuthenticationNumberCommand command);

}
