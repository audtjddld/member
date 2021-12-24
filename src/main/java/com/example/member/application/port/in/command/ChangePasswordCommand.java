package com.example.member.application.port.in.command;

import lombok.Getter;

/**
 * 패스워드 변경 커멘드.
 */
@Getter
public class ChangePasswordCommand {

  private final String password;
  private final long id;

  /**
   * 패스워드 변경 커멘드를 생성합니다.
   *
   * @param id       유저 아이디
   * @param password 패스워드
   */
  public ChangePasswordCommand(final long id,
                               final String password) {
    this.password = password;
    this.id = id;
  }

}
