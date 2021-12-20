package com.example.member.application.port.in.command;

import lombok.Getter;

/**
 * 전화번호 검증 Command.
 */
@Getter
public class AuthenticateMobileCommand {

  private final String mobile;

  /**
   * 전화번호 검증 Command를 생성합니다.
   *
   * @param mobile 전화번호
   */
  public AuthenticateMobileCommand(final String mobile) {
    this.mobile = mobile;
  }

}
