package com.example.member.application.port.in.command;

import lombok.Builder;
import lombok.Getter;

/**
 * 회원 정보 저장 Command.
 */
@Getter
public class RegisterMemberCommand {

  private final String email;
  private final String nickname;
  private final String password;
  private final String name;
  private final String mobile;

  /**
   * 회원 정보 저장 커멘드를 생성합니다.
   *
   * @param email    이메일
   * @param nickname 닉네임
   * @param password 패스워드
   * @param name     성명
   * @param mobile   전화번호
   */
  @Builder
  public RegisterMemberCommand(final String email,
                               final String nickname,
                               final String password,
                               final String name,
                               final String mobile) {
    this.email = email;
    this.nickname = nickname;
    this.password = password;
    this.name = name;
    this.mobile = mobile;
  }

}
