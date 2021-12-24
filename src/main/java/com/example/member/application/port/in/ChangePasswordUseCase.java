package com.example.member.application.port.in;

import com.example.member.application.port.in.command.ChangePasswordCommand;
import java.security.NoSuchAlgorithmException;

/**
 * 패스워드 변경 UseCase.
 */
public interface ChangePasswordUseCase {

  /**
   * 패스워드 변경합니다.
   *
   * @param command 패스워드 변경 커멘드
   */
  void change(ChangePasswordCommand command) throws NoSuchAlgorithmException;

}
