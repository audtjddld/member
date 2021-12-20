package com.example.member.application.port.in.command;

import lombok.Getter;

/**
 * 전화번호 검증 Command.
 */
@Getter
public class ValidateAuthenticationNumberCommand {

  private final String mobile;
  private final String authenticationNumber;

  /**
   * 전화 번호 검증 Command를 생성합니다.
   *
   * @param mobile               전화번호
   * @param authenticationNumber 전화번호
   */
  public ValidateAuthenticationNumberCommand(final String mobile,
                                             final String authenticationNumber) {
    this.mobile = mobile;
    this.authenticationNumber = authenticationNumber;
  }

}
